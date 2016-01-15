package com.example.reminderdemo;

import cn.wxyx.ygkc2.R;


import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.net.Uri;

public class CallMainActivity extends Activity {

	private Button mCallButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_callactivity_mainw);
		final TelephonyManager tm = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);
		dialog(tm);
//		mCallButton = (Button) findViewById(R.id.btn_call);
//		mCallButton.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				// �����ͨ�ͷ�10010
//
//				exPhoneCallListener myPhoneCallListener = new exPhoneCallListener();
//				tm.listen(myPhoneCallListener,
//						PhoneStateListener.LISTEN_CALL_STATE);
//				Intent intent = new Intent(Intent.ACTION_CALL, Uri
//						.parse("tel:18861840630"));
//				startActivity(intent);
//				 finish();
//			}
//		});
 
	}
//	protected void dialog(final TelephonyManager tm) {
//		AlertDialog.Builder builder = new Builder(CallMainActivity.this);
//		builder.setMessage("是否联系成功？");
//		builder.setTitle("提示");
//
//		builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				exPhoneCallListener myPhoneCallListener = new exPhoneCallListener();
//				tm.listen(myPhoneCallListener,
//						PhoneStateListener.LISTEN_CALL_STATE);
//				Intent intent = new Intent(Intent.ACTION_CALL, Uri
//						.parse("tel:18861840630"));
//				startActivity(intent);
//				dialog.dismiss();
//				CallMainActivity.this.finish();
//
//			}
//		});
//
//		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				dialog.dismiss();
//				CallMainActivity.this.finish();
//			}
//		});
//		builder.create().show();
//	}
	

	public class exPhoneCallListener extends PhoneStateListener {
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:// ����

				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:// �Ҷ�
				Intent in = new Intent();
				in.setClass(CallMainActivity.this, NotificationActivity.class);
				startActivity(in);
				break;
			case TelephonyManager.CALL_STATE_RINGING:// ���绰

				break;
			default:
				break;
			}
			super.onCallStateChanged(state, incomingNumber);
		}
	}
	
	protected void dialog(final TelephonyManager telephonyManager) {
		AlertDialog.Builder builder = new Builder(CallMainActivity.this);
		builder.setMessage("Are you sure to call？");
		builder.setTitle("Notification");

		builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				exPhoneCallListener myPhoneCallListener = new exPhoneCallListener();
				telephonyManager.listen(myPhoneCallListener,
						PhoneStateListener.LISTEN_CALL_STATE);
				Intent intent = new Intent(Intent.ACTION_CALL, Uri
						.parse("tel:18861840630"));
				startActivity(intent);
				
				
				dialog.dismiss();
				CallMainActivity.this.finish();

			}
		});

		builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				CallMainActivity.this.finish();
			}
		});
		builder.create().show();
	}

}
