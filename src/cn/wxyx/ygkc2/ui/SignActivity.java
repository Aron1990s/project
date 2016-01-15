package cn.wxyx.ygkc2.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup.OnCheckedChangeListener;
import cn.wxyx.ygkc2.R;
import cn.wxyx.ygkc2.bean.MobileSign;
import cn.wxyx.ygkc2.connToServe.AsyncTaskSignIn;
import cn.wxyx.ygkc2.service.IServiceAPI;
import cn.wxyx.ygkc2.service.impl.ServiceAPIimpl;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.google.gson.Gson;

/**
 * @author 夏晨俊
 *
 * 2015年4月17日 上午9:24:10
 */
/**
 * @author 夏晨俊
 *
 *         2015年4月17日 上午9:24:13
 */
public class SignActivity extends Activity {

	// 定位相关
	LocationClient mLocClient;
	public MyLocationListenner myListener = new MyLocationListenner();
	BitmapDescriptor mCurrentMarker;
	MapView mMapView;
	BaiduMap mBaiduMap;
	MobileSign mobileSign;
	private Button endWork;
//	private BaseApplication baseApplication;
	// UI相关
	OnCheckedChangeListener radioButtonListener;
	boolean isFirstLoc = true;// 是否首次定位
	// 数据提交类
	IServiceAPI netService = new ServiceAPIimpl();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign);
		SDKInitializer.initialize(this);
		final EditText signRemark = (EditText) findViewById(R.id.signRemark);
		Button startWork = (Button) findViewById(R.id.startWork);
		endWork =(Button)findViewById(R.id.button2);
//		baseApplication=new BaseApplication();
		Intent intentToGetId=getIntent();
		final int id=intentToGetId.getIntExtra("id", Integer.MAX_VALUE);
		
		startWork.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				signRemark.setText(mobileSign.getLatitude().toString()+"  "+mobileSign.getLongitude().toString()+" "+String.valueOf(id));
				signIn(signRemark.getText().toString(),mobileSign.getLatitude(),mobileSign.getLongitude(),id);
			}
		});

		endWork.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				signOff(signRemark.getText().toString(),mobileSign.getLatitude(),mobileSign.getLongitude(), id);
			}
		});
		// 地图初始化
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		// 设置缩放级别
		mBaiduMap.setMapStatus(MapStatusUpdateFactory
				.newMapStatus(new MapStatus.Builder().zoom(16).build()));
		// 开启定位图层
		mBaiduMap.setMyLocationEnabled(true);
		// 定位初始化
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();
	}
	public void signIn(String remark, Double la, Double Lo, int id){
			MobileSign m=new MobileSign();
			m.setuserId(id);
			m.setStatus(1);
			m.setRemark(remark);
			m.setLatitude(la);
			m.setLongitude(Lo);
			Gson gs=new Gson();
			String s=gs.toJson(m);
			System.out.println("s="+s);
		AsyncTaskSignIn asyncTask = new AsyncTaskSignIn(this,s);
		asyncTask.execute();
	}
	
	public void signOff(String remark, Double la, Double Lo,int id){
		MobileSign m=new MobileSign();
		m.setuserId(id);
		m.setStatus(0);
		m.setRemark(remark);
		m.setLatitude(la);
		m.setLongitude(Lo);
		Gson gs=new Gson();
		String s=gs.toJson(m);
		System.out.println("s="+s);
	AsyncTaskSignIn asyncTask = new AsyncTaskSignIn(this,s);
	asyncTask.execute();
}

	/**
	 * 定位SDK监听函数
	 */
	public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null || mMapView == null)
				return;
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())
					.latitude(location.getLatitude())
					.longitude(location.getLongitude()).build();
			mobileSign = new MobileSign();
			mobileSign.setLatitude(location.getLatitude());
			mobileSign.setLongitude(location.getLongitude());
			mBaiduMap.setMyLocationData(locData);
			if (isFirstLoc) {
				isFirstLoc = false;
				LatLng ll = new LatLng(location.getLatitude(),
						location.getLongitude());
				MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
				mBaiduMap.animateMapStatus(u);
			}
		}


		public void onReceivePoi(BDLocation poiLocation) {
		}
	}

	@Override
	protected void onPause() {
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// 退出时销毁定位
		mLocClient.stop();
		// 关闭定位图层
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;
		super.onDestroy();
	}
}
