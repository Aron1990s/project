package cn.wxyx.ygkc2.ui;

import cn.wxyx.ygkc2.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TrackRepair extends Activity{

	private Button trackRepair;
	private Button scan;
	private TextView userName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trackrepair);
		trackRepair=(Button) findViewById(R.id.trackRepair);
		userName = (TextView) findViewById(R.id.textForCustomerName);
		scan=(Button)findViewById(R.id.button1);
		trackRepair.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(TrackRepair.this, CommentRepair.class);
				startActivity(intent);
			}
		});
		
		Intent intentForScan = getIntent();
		String ree = intentForScan.getStringExtra("gotResult");
		userName.setText(ree);
		scan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("scanWhich", "3");
				intent.setClass(TrackRepair.this, MipcaActivityCapture.class);	
				startActivity(intent);
				finish();
			}
		});
		
	}
}
