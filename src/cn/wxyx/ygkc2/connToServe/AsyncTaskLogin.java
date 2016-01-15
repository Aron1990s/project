package cn.wxyx.ygkc2.connToServe;

import cn.wxyx.ygkc2.service.IServiceAPI;
import cn.wxyx.ygkc2.service.impl.ServiceAPIimpl;
import cn.wxyx.ygkc2.ui.LoginActivity;
import cn.wxyx.ygkc2.ui.MainActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class AsyncTaskLogin extends AsyncTask <Integer, Integer, String>{

	private LoginActivity textView;  
	String name;
	String password;
	 public AsyncTaskLogin(LoginActivity textView,String n, String p) {  
	        super();  
	        this.textView = textView; 
	        this.name=n;
	        this.password=p;
	    }  
	@Override
	protected String doInBackground(Integer... params) {
		IServiceAPI service = new ServiceAPIimpl();
		String result = service.login("localhost:8080/ygkc/AndroidLogin", name,password);// 调用与服务器通信的接口
		return result;
	}
	
	@Override  
    protected void onPostExecute(String loginResult) {  
		if(loginResult.equals("账号/密码不可为空！")){
			Toast.makeText(textView.getApplicationContext(), "账号/密码不可为空！",
				     Toast.LENGTH_SHORT).show();
		}else if(loginResult.equals("账号/密码错误！")){
			Toast.makeText(textView.getApplicationContext(), "账号/密码错误",
				     Toast.LENGTH_SHORT).show();
		}else if(loginResult.equals("无效的账户信息")){
			Toast.makeText(textView.getApplicationContext(), "无效账户信息",
				     Toast.LENGTH_SHORT).show();
		}else if(loginResult.substring(2, 6).equals("rows")){
			Toast.makeText(textView.getApplicationContext(), "欢迎进入",
				     Toast.LENGTH_SHORT).show();
			Intent intent = new Intent();
			intent.setClass(textView, MainActivity.class);
			intent.putExtra("gotResult", loginResult);
			textView.startActivity(intent);
		}else{
			Toast.makeText(textView.getApplicationContext(), "应用异常,请检查网络",
				     Toast.LENGTH_SHORT).show();
/*
 * Test
 */
			Intent intent = new Intent();
			intent.setClass(textView, MainActivity.class);
//			intent.putExtra("gotResult", loginResult);
			textView.startActivity(intent);
		}
    }
 

}
