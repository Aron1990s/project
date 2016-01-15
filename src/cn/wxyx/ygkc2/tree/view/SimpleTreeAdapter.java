package cn.wxyx.ygkc2.tree.view;

import java.util.List;

import com.example.reminderdemo.CallMainActivity;
import com.example.reminderdemo.NotificationActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import cn.wxyx.ygkc2.R;
import cn.wxyx.ygkc2.tree.bean.Node;
import cn.wxyx.ygkc2.tree.bean.TreeListViewAdapter;
import cn.wxyx.ygkc2.ui.LoginActivity;

public class SimpleTreeAdapter<T> extends TreeListViewAdapter<T> {

	private Context context;

	public SimpleTreeAdapter(ListView mTree, Context context, List<T> datas,
			int defaultExpandLevel) throws IllegalArgumentException,
			IllegalAccessException {
		super(mTree, context, datas, defaultExpandLevel);
		this.context = context;
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getConvertView(Node node, int position, View convertView,
			ViewGroup parent) {

		ViewHolder viewHolder = null;
		if (node.getName().equals("固定电话") || node.getName().equals("手机")) {
			convertView = mInflater.inflate(R.layout.activity_list_item2,
					parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView
					.findViewById(R.id.id_treenode_label);
			viewHolder.submit = (Button) convertView.findViewById(R.id.button1);
			viewHolder.submit.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
					intent.setClass(context, CallMainActivity.class);
					context.startActivity(intent);
				}
			});
			convertView.setTag(viewHolder);
			viewHolder = (ViewHolder) convertView.getTag();
		} else if (node.getName().substring(0, 1).equals("约")) {
			convertView = mInflater.inflate(R.layout.activity_list_item4,
					parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView
					.findViewById(R.id.id_treenode_label);
			viewHolder.submit = (Button) convertView.findViewById(R.id.submit);
			viewHolder.submit.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// Intent intent=new Intent();
					// intent.setClass(context,CallMainActivity.class );
					// context.startActivity(intent);
					// exPhoneCallListener myPhoneCallListener = new
					// exPhoneCallListener();
					// tm.listen(myPhoneCallListener,PhoneStateListener.LISTEN_CALL_STATE);
					// Intent intent = new
					// Intent(Intent.ACTION_CALL,Uri.parse("tel:18861840630"));
					// context.startActivity(intent);
				}
			});
			convertView.setTag(viewHolder);
			viewHolder = (ViewHolder) convertView.getTag();
		} else {
			convertView = mInflater.inflate(R.layout.activity_list_item,
					parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView
					.findViewById(R.id.id_treenode_label);
			convertView.setTag(viewHolder);
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (node.getIcon() == -1) {
			viewHolder.icon.setVisibility(View.INVISIBLE);
		} else {
			viewHolder.icon.setVisibility(View.VISIBLE);
			viewHolder.icon.setImageResource(node.getIcon());
		}

		viewHolder.label.setText(node.getName());

		return convertView;
	}

	private final class ViewHolder {
		ImageView icon;
		TextView label;
		Button submit;
	}

	public class exPhoneCallListener extends PhoneStateListener {
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:// 待机

				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:// 挂断
				Intent in = new Intent();
				in.setClass(context, NotificationActivity.class);

				context.startActivity(in);
				break;
			case TelephonyManager.CALL_STATE_RINGING:// 来电话

				break;
			default:
				break;
			}
			super.onCallStateChanged(state, incomingNumber);
		}
	}

}
