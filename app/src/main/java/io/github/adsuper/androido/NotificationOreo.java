package io.github.adsuper.androido;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;

/**
 * 作者：luoshen/rsf411613593@gmail.com
 * 时间：2017年08月28日
 * 说明：android 8.0 通知
 */

public class NotificationOreo {

    public String chanelId = "android 8.0";
    public String chanelName = "Channel Love";
    public int importance = NotificationManager.IMPORTANCE_HIGH;


    public void showNotification(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(chanelId, chanelName, importance);
            channel.enableLights(true);
            channel.enableVibration(true);

            NotificationManager notificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(channel);

            //设置通知栏点击事件，跳转页面（应用内的页面）
            Intent resultIntent = new Intent(context, ResultActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(ResultActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);


            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher_round);

            Notification.Builder builder =
                    new Notification.Builder(context)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            //设置右侧显示的大图标
                            .setLargeIcon(bitmap)
                            //设置标题
                            .setContentTitle("My Love")
                            //设置内容
                            .setContentText("Hi, my love!")
                            //设置通知多久之后自动消失
//                            .setTimeoutAfter(10000)
                            //设置通知的背景颜色，并启用
                            .setColor(Color.RED)
                            .setColorized(true)

                            //设置通知点击之后的跳转页面
                            .setContentIntent(resultPendingIntent)
                            //设置点击之后清除通知
                            .setAutoCancel(true)
                            //设置渠道 ID
                            .setChannelId(chanelId);
            notificationManager.notify(1, builder.build());

        }


    }

}
