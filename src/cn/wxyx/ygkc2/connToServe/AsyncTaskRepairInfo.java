package cn.wxyx.ygkc2.connToServe;

import cn.wxyx.ygkc2.service.IServiceAPI;
import cn.wxyx.ygkc2.service.impl.ServiceAPIimpl;
import cn.wxyx.ygkc2.ui.RepairActivity;
import cn.wxyx.ygkc2.ui.TrackRepair;
import android.content.Intent;
import android.os.AsyncTask;

public class AsyncTaskRepairInfo extends AsyncTask <Integer, Integer, String>{


	private RepairActivity repairActivity;
	private String clientName;
	private String clientNum;
	private String repairContent;
	
	
	public AsyncTaskRepairInfo(RepairActivity repairActivity,
			String clientName, String clientNum, String repairContent) {
		super();
		this.repairActivity = repairActivity;
		this.clientName = clientName;
		this.clientNum = clientNum;
		this.repairContent = repairContent;
	}

	@Override
	protected String doInBackground(Integer... params) {
		IServiceAPI service = new ServiceAPIimpl();
		String result = service.sendClientInfo("Type your URL", clientName, clientNum, repairContent);
		return result;
	}
	
	@Override  
    protected void onPostExecute(String loginResult) {  
		Intent intent = new Intent();
		intent.setClass(repairActivity, TrackRepair.class);
//		intent.putExtra("gotResult", loginResult);
		repairActivity.startActivity(intent);
		}

}
