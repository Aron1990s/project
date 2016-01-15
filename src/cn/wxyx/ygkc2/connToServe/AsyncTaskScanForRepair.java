package cn.wxyx.ygkc2.connToServe;



import cn.wxyx.ygkc2.ui.MipcaActivityCapture;
import cn.wxyx.ygkc2.ui.RepairActivity;
import android.content.Intent;
import android.os.AsyncTask;

public class AsyncTaskScanForRepair extends AsyncTask <Integer, Integer, String>{

	private MipcaActivityCapture mipcaActivityCapture;
	private String fromScan;
//	private TextView userName;
//	private TextView equipId;
//	private TextView hardwareConfig;
//	private TextView serveLength;
	public AsyncTaskScanForRepair(MipcaActivityCapture mipcaActivityCapture,
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
//		IServiceAPI service = new ServiceAPIimpl();
//		String result = service.checkEquTwo("Type your URL",fromScan);// 调用与服务器通信的接口
//		return result;
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
			intent.setClass(mipcaActivityCapture, RepairActivity.class);
			mipcaActivityCapture.startActivity(intent);

    }

}
