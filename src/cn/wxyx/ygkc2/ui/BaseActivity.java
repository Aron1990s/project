package cn.wxyx.ygkc2.ui;

import android.app.Activity;
import android.content.Intent;

public class BaseActivity extends Activity {

	protected void changUI(Class<?> to) {
		Intent intent = new Intent();
		intent.setClass(this, to);
		startActivity(intent);
	}
}
