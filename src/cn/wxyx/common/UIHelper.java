package cn.wxyx.common;

import android.content.Context;
import android.content.Intent;

public class UIHelper {
	private static UIHelper instance;

	private UIHelper() {
	}

	public static UIHelper getHelper() {
		if (instance == null) {
			instance = new UIHelper();
		}
		return instance;
	}

	public void changUI(Context from, Class<?> to) {
		Intent intent = new Intent();
		intent.setClass(from, to);
		from.startActivity(intent);
	}
}
