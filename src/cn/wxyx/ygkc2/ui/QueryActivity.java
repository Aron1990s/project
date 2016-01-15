package cn.wxyx.ygkc2.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cn.wxyx.ygkc2.R;



/**
 * 查询设备的界面类
 * 
 * @author 夏晨俊
 * 
 * 
 */
@SuppressLint("Recycle")
public class QueryActivity extends Activity {
//	private final static int SCANNIN_GREQUEST_CODE = 1;
//	private Gson gson = new Gson();// gson对象用于将java类转字符串
//	private Handler mHandler;// 异步处理对象，主要用于和服务器通信
	private Button button1;
	private Button button2;
	private TextView userName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkequ);

		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.callForRepair);
		userName = (TextView) findViewById(R.id.textForCustomerName);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("scanWhich", "1");
				intent.setClass(QueryActivity.this, MipcaActivityCapture.class);
				// intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
				startActivity(intent);
				
				finish();
			}
		});

		Intent intentForScan = getIntent();
		final String re = intentForScan.getStringExtra("gotResult");
		userName.setText(re);

		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("info", userName.getText().toString());
//				System.out.println(userName.getText().toString());
				intent.setClass(QueryActivity.this, RepairActivity.class);
				startActivity(intent);
			}
		});

	}

	// @Override
	// protected void onActivityResult(int requestCode, int resultCode, Intent
	// data) {
	// super.onActivityResult(requestCode, resultCode, data);
	// switch (requestCode) {
	// case SCANNIN_GREQUEST_CODE:
	// if (resultCode == RESULT_OK) {
	// Bundle bundle = data.getExtras();
	// // 得到二维码所包含的url地址
	// String url = UrlSet.MAIN + bundle.getString("result");
	// // 需要向服务器发送的数据
	// ConnMessage connMessage = new ConnMessage(url);
	// mHandler.obtainMessage(1, gson.toJson(connMessage))
	// .sendToTarget();
	// break;
	// }
	// }
	// }
	//
	// /**
	// * Handler类主要用于接收和处理服务器传输过来的数据。并在页面显示。
	// */
	// protected class MyHandler extends Handler {
	// public MyHandler(Looper looper) {
	// super(looper);
	// }
	//
	// public MyHandler() {
	//
	// }
	//
	// public void handleMessage(Message msg) {
	// super.handleMessage(msg);
	// String message = msg.obj.toString();// 获取数据
	// switch (msg.what) {// 根据请求编码分发数据进行处理
	// case 1:
	// textView1.setText(message);
	// break;
	// }
	//
	// }
	// }
	//
	// /**
	// * 实现数据交互的线程
	// */
	//
	// protected class MyThread implements Runnable {
	//
	// @SuppressLint("HandlerLeak")
	// @Override
	// public void run() {
	// // final IServiceAPI service = new ServiceAPIimpl();
	// // Looper.prepare();// 1、初始化Looper
	// // mHandler = new Handler() {// 2、绑定handler到MyThread实例的Looper对象
	// // public void handleMessage(Message msg) {// 3、定义处理消息的方法
	// // switch (msg.what) {// 根据请求编号分发处理信息
	// // case 1:
	// // ConnMessage cm = gson.fromJson(msg.obj.toString(),
	// // new TypeToken<ConnMessage>() {
	// // }.getType());
	// // String result = service.login(cm.getUrl(),
	// // cm.getMessage());// 调用与服务器通信的接口
	// // Handler myA = new MyHandler(Looper.getMainLooper());
	// // myA.obtainMessage(1, result).sendToTarget();
	// // break;
	// // }
	// // }
	// // };
	// // Looper.loop();// 4、启动消息循环
	// }
	// }
}
