package com.example.reminderdemo;



import cn.wxyx.ygkc2.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver { 
	
	private NotificationManager manager;
	
    /** 
     * called when the BroadcastReceiver is receiving an Intent broadcast. 
     */  
    @Override  
    public void onReceive(Context context, Intent intent) {  
		
        /* start another activity - MyAlarm to display the alarm 直接跳出activity*/  
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
//        intent.setClass(context, MyAlarm.class);  
//        context.startActivity(intent);  
    	Toast.makeText(context, "Time to contact client", Toast.LENGTH_LONG).show();
    	
    	manager = (NotificationManager)context.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
    	//例如这个id就是你传过来的
    	String id = intent.getStringExtra("id");
    	id= "0";
    	//MainActivity是你点击通知时想要跳转的Activity
    	Intent playIntent = new Intent(context, MyAlarm.class);
    	playIntent.putExtra("id", id);
    	PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, playIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    	NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
    	builder.setContentTitle("Contact Client").setContentText("Content of Notification").setSmallIcon(R.drawable.ic_launcher).setDefaults(Notification.DEFAULT_ALL).setContentIntent(pendingIntent).setAutoCancel(true).setSubText("该打电话了");
    	manager.notify(1, builder.build());

    }  
  
}
