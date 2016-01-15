package cn.wxyx.ygkc2.connToServe;

import cn.wxyx.ygkc2.service.IServiceAPI;
import cn.wxyx.ygkc2.service.impl.ServiceAPIimpl;
import cn.wxyx.ygkc2.ui.SignActivity;
import android.os.AsyncTask;
import android.widget.Toast;

public class AsyncTaskSignIn extends AsyncTask<Integer, Integer, String> {

	private String mobileSign;
	private SignActivity signActivity;
	public AsyncTaskSignIn(SignActivity signActivity, String m) {
		super();
		this.signActivity=signActivity;
		this.mobileSign=m;
				
	}

	@Override
	protected String doInBackground(Integer... params) {
		IServiceAPI service = new ServiceAPIimpl();
		String result = service.signIn("http://192.168.7.116:8080/ygkc/MobileSign?act=save",mobileSign);
		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		Toast.makeText(signActivity.getApplicationContext(), result,
			     Toast.LENGTH_SHORT).show();
	}
}
