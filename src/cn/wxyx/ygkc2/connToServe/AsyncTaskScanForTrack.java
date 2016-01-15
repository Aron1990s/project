package cn.wxyx.ygkc2.connToServe;

import cn.wxyx.ygkc2.ui.MipcaActivityCapture;
import cn.wxyx.ygkc2.ui.TrackRepair;
import android.content.Intent;
import android.os.AsyncTask;

public class AsyncTaskScanForTrack extends AsyncTask <Integer, Integer, String>{

	private MipcaActivityCapture mipcaActivityCapture;
	private String fromScan;
	public AsyncTaskScanForTrack(MipcaActivityCapture mipcaActivityCapture,
			String fromScan) {
		super();
		this.mipcaActivityCapture = mipcaActivityCapture;
		this.fromScan = fromScan;
//		this.userName=userName;
//		this.equipId=equipId;
//		this.hardwareConfig=hardwareConfig;
//		this.serveLength=serveLength;
	}
	@Override
	protected String doInBackground(Integer... params) {
				String result=fromScan;
		return result;
	}

	@Override  
    protected void onPostExecute(String loginResult) {  
//		Toast.makeText(mipcaActivityCapture.getApplicationContext(), loginResult,
//			     Toast.LENGTH_SHORT).show();
//			userName.setText(loginResult);
//			equipId.setText(loginResult);
//			hardwareConfig.setText(loginResult);
//			serveLength.setText(loginResult);
			Intent intent = new Intent();
			intent.putExtra("gotResult", loginResult);
			intent.setClass(mipcaActivityCapture, TrackRepair.class);
			mipcaActivityCapture.startActivity(intent);

    }
}
