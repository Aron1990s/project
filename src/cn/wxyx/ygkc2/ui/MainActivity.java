package cn.wxyx.ygkc2.ui;

import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cn.wxyx.ygkc2.BaseApplication;
import cn.wxyx.ygkc2.R;
import cn.wxyx.ygkc2.bean.Users;
import cn.wxyx.ygkc2.tree.view.WMainActivity;

/**
 * 主界面
 * 
 * @author 夏晨俊
 *
 *         2015年4月10日 上午11:10:04
 */
@SuppressWarnings("unused")
public class MainActivity extends Activity {
	private TextView todaySurplus;
	private TextView priviousLeft;
	private TextView monthSurplus;
	private TextView todayComplete;
	private TextView userName;
	private TextView userLevel;
	private TextView userWorkTime;
	private TextView currentInfo;
	private Users user=new Users();
	private BaseApplication baseApp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button queryBtn = (Button) findViewById(R.id.queryBtn);
		Button signInBtn = (Button) findViewById(R.id.signInBtn);
		todaySurplus = (TextView) findViewById(R.id.textView9);
		priviousLeft = (TextView) findViewById(R.id.textView5);
		monthSurplus = (TextView) findViewById(R.id.textView7);
		todayComplete = (TextView) findViewById(R.id.textView11);
		currentInfo = (TextView) findViewById(R.id.textView13);		
		userName=(TextView) findViewById(R.id.editText1);
		userLevel=(TextView) findViewById(R.id.editText3);
		userWorkTime=(TextView) findViewById(R.id.editText4);
		currentInfo.setMovementMethod(new ScrollingMovementMethod());
		baseApp=new BaseApplication();
//		Intent in=getIntent();
//		String ss=in.getStringExtra("gotResult");
//		String sss=ss.substring(9, ss.length()-2);
//		currentInfo.setText(sss);
//		this.extractUserInfo(sss);
//		user.setName("ssss");
//		baseApp.setUser(user);
//		userName.setText(user.getRealName());
//		userLevel.setText(judgeLevel(user.getUserLevel()));
//		userWorkTime.setText("");
		queryBtn.setOnClickListener(new OnClickListener() { // 跳转到设备查询界面
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, QueryActivity.class);
				startActivity(intent);
			}
		});
		signInBtn.setOnClickListener(new OnClickListener() { // 跳转到打卡界面
					@Override
					public void onClick(View v) {
						Intent intent = new Intent();
						intent.putExtra("id", user.getId());
						intent.setClass(MainActivity.this, SignActivity.class);
						startActivity(intent);
					}
				});
		todaySurplus.setOnClickListener(new OnClickListener() { // 跳转到任务界面
					@Override
					public void onClick(View v) {
						Intent intent = new Intent();
						intent.setClass(MainActivity.this,
								WMainActivity.class);
						startActivity(intent);
					}
				});
		priviousLeft.setOnClickListener(new OnClickListener() { // 跳转到任务界面
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,
						WMainActivity.class);
				startActivity(intent);
			}
		});
		monthSurplus.setOnClickListener(new OnClickListener() { // 跳转到任务界面
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,
						WMainActivity.class);
				startActivity(intent);
			}
		});
		todayComplete.setOnClickListener(new OnClickListener() { // 跳转到任务界面
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,
						WMainActivity.class);
				startActivity(intent);
			}
		});
		

//		BaseApplication app = (BaseApplication) this.getApplication();
//		Toast.makeText(this, app.getUser().getRealName(), Toast.LENGTH_LONG)
//				.show();
	}

	/**
	 * 
	 * This method is for judging userLevel
	 * 
	 */
	private String judgeLevel(String userLevel2) {
		if(userLevel2.equals("1")){
			return "实习工程师";
		}else if(userLevel2.equals("2")){
			return "助理工程师";
		}else if(userLevel2.equals("3")){
			return "中级工程师";
		}else if(userLevel2.equals("4")){
			return "高级工程师";
		}else if(userLevel2.equals("5")){
			return "资深工程师";
		}else{
		return "无级别";
		}
	}


	/**
	 * 
	 * This method is for extracting userInfo  
	 * 
	 */
	public Users extractUserInfo(String sss) {
//		SimpleDateFormat transFertoDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			JSONObject jsonObject = new JSONObject(sss);
			//Get createTime
//			user.setCreateTime(transFertoDate.parse(jsonObject.getString("createTime")));
			//Get userId
			user.setId(Integer.valueOf(jsonObject.getString("id")));
			//Get name
			user.setName(jsonObject.getJSONObject("account").getString("name"));
			//Get password
			user.setPasswd(jsonObject.getJSONObject("account").getString("pazzwd"));
			//Get realName
			user.setRealName(jsonObject.getString("realName"));
			//Get roleId
			user.setRoleId(Integer.valueOf(jsonObject.getJSONObject("account").getJSONObject("role").getString("id")));
			//Get deptName
			user.setDeptName(jsonObject.getString("deptName"));
			//Get postId
			user.setPostId(Integer.valueOf(jsonObject.getJSONObject("postId").getString("id")));
			//Get shopId
			user.setShopId(Integer.valueOf(jsonObject.getJSONObject("shopId").getString("id")));
			//Get motto
			user.setMotto(jsonObject.getString("motto"));
			//Get photo
			user.setPhoto(jsonObject.getString("photo"));
			//Get recommend
			user.setRecommend(jsonObject.getString("recommend"));
			//Get specialty
			user.setSpecialty(jsonObject.getString("specialty"));
			//Get status
			user.setStatus(Integer.valueOf(jsonObject.getInt("status")));
			//Get userLevel
			user.setUserLevel(jsonObject.getString("userLevel"));
			//Get isDel
			user.setIsDel(Integer.valueOf(jsonObject.getString("isDel")));
			//Get deptId
			user.setDeptId(Integer.valueOf(jsonObject.getJSONObject("deptId").getString("id")));
			//Get chinese
			user.setChinese(jsonObject.getString("chinese"));
			//Get phone
			user.setPhone(jsonObject.getString("phone"));
			//Get qqNum
			user.setQqNum(jsonObject.getString("qqNum"));
			//Get sex
			user.setSex(Integer.valueOf(jsonObject.getString("sex")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
