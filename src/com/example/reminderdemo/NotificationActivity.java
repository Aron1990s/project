package com.example.reminderdemo;

import java.util.Calendar;

import cn.wxyx.ygkc2.R;



import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class NotificationActivity extends Activity {

	Button btnEnable;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fornotificationmain);
		moveTaskToBack(true);
		/*
		 * create a button. When you click the button, the alarm clock is
		 * enabled
		 */
		dialog();
//		btnEnable = (Button) this.findViewById(R.id.btnEnable);
//		btnEnable.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
////				setReminder(true);
//
//				finish();
//			}
//		});
	}

	/**
	 * Set the alarm
	 * 
	 * @param b
	 *            whether enable the Alarm clock or not
	 */
	private void setReminder(boolean b) {

		// get the AlarmManager instance
		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		// create a PendingIntent that will perform a broadcast
		PendingIntent pi = PendingIntent.getBroadcast(
				NotificationActivity.this, 0,
				new Intent(this, MyReceiver.class), 0);
		NotificationActivity.this.finish();

		if (b) {
			// just use current time + 10s as the Alarm time.
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(System.currentTimeMillis());
			// 鍙互鏍规嵁椤圭洰瑕佹眰淇敼锛岀銆佸垎閽熴�佹彁鍓嶃�佸欢鍚�
			c.add(Calendar.SECOND, 10);
			// schedule an alarm
			am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
		} else {
			// cancel current alarm
			am.cancel(pi);
		}
		
		NotificationActivity.this.finish();

	}

	protected void dialog() {
		AlertDialog.Builder builder = new Builder(NotificationActivity.this);
		builder.setMessage("Successfully Contact？");
		builder.setTitle("Notification");

		builder.setPositiveButton("YES", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.dismiss();
				NotificationActivity.this.finish();

			}
		});

		builder.setNegativeButton("NO", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				setReminder(true);
				dialog.dismiss();
				NotificationActivity.this.finish();
			}
		});
		builder.create().show();
	}

	
//	public boolean onKeyDown(int keyCode, KeyEvent event){
//		 if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
//			 dialog();
//		 }
//		 return false;
//	}
}
