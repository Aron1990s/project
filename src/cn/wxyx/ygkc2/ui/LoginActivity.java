package cn.wxyx.ygkc2.ui;

import java.lang.reflect.Type;
import java.util.Date;



import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import cn.molos.tool.ToolFactory;
import cn.molos.tool.common.IDateTool;
import cn.wxyx.ygkc2.R;
import cn.wxyx.ygkc2.connToServe.AsyncTaskLogin;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LoginActivity extends BaseActivity {
	private Button button1;
	private EditText editText1;
	private EditText editText2;
//	private TextView tex;
	String loginResult;
	String loginName;
	String loginPassword;
	String url = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		button1 = (Button) findViewById(R.id.button1);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText1.setText("admin");
		editText2 = (EditText) findViewById(R.id.editText2);
		editText2.setText("123");
//		tex = (TextView) findViewById(R.id.textForText);

		loginName=editText1.getText().toString();
		loginPassword=editText2.getText().toString();
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				loginIn();
			}
		});
	}

	protected void loginIn() {
		loginName = editText1.getText().toString();
		loginPassword = editText2.getText().toString();
		AsyncTaskLogin asyncTask = new AsyncTaskLogin(this, loginName,
				loginPassword);
		asyncTask.execute();
	}

	class TimeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
		IDateTool tool = ToolFactory.getDateTool();

		@Override
		public Date deserialize(JsonElement arg0, Type arg1,
				JsonDeserializationContext arg2) throws JsonParseException {
			if (arg0 == null) {
				return null;
			}
			try {
				return tool.str2Date(arg0.getAsString());
			} catch (Exception e) {
			}
			return null;
		}

		@Override
		public JsonElement serialize(Date d, Type arg1,
				JsonSerializationContext arg2) {
			if (d != null) {
				return new JsonPrimitive(tool.date2Str(d));
			}
			return null;
		}
	}
}

//@Override
//public void handleMessage(Message msg) {
//	super.handleMessage(msg);
//	String message = msg.obj.toString();// 获取数据
//	switch (msg.what) {// 根据请求编码分发数据进行处理
//	case 1:
//		 if (message == null || message.trim().equals("")) {
//		 Toast.makeText(LoginActivity.this, R.string.loginfail,
//		 Toast.LENGTH_LONG).show();
//		 } else {
//		 BaseApplication myApplication = (BaseApplication)
//		 LoginActivity.this
//		 .getApplication();
//		 GsonBuilder gsonb = new GsonBuilder();
//		 gsonb.registerTypeAdapter(java.util.Date.class,
//		 new TimeAdapter());
//		 Users user = gsonb.create().fromJson(message,
//		 new TypeToken<Users>() {
//		 }.getType());
//		 myApplication.setUser(user);
//		changUI(MainActivity.class);
//		 }
//		break;
//	}
//
//	
//
//}
//}
