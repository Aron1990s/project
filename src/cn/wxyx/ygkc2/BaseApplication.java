package cn.wxyx.ygkc2;

import android.app.Application;
import cn.wxyx.ygkc2.bean.Users;

import com.baidu.mapapi.SDKInitializer;

public class BaseApplication extends Application {
	private Users user;

	@Override
	public void onCreate() {
		super.onCreate();
		// 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
		SDKInitializer.initialize(this);
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}