package io.github.adsuper.androido;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * 作者：luoshen/rsf411613593@gmail.com
 * 时间：2017年08月24日
 * 说明：7.1 之前的通知
 */

public class NotificationUtils {

    private NotificationCompat.Builder mBuilder;

    private String text = "天龙八部是一款武侠类的游戏，唯美的画面，炫酷的技能，让你爱不释手";
    private String title = "天龙八部";

    /**
     * 显示标题栏
     *
     * @param context
     */
    public void showNotification(Context context) {

        mBuilder = new NotificationCompat.Builder(context);

        mBuilder.setContentTitle(title);

        mBuilder.setContentText(text);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        //设置优先级，-2 到 2 ，越高，显示的越在上边
        mBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        //设置通知栏点击事件，跳转页面（应用内的页面）
        Intent resultIntent = new Intent(context, ResultActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(ResultActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        //设置点击之后时候清除被点击的通知
        mBuilder.setAutoCancel(true);

//// 自定义通知
//        NotificationCompat.InboxStyle inboxStyle =
//                new NotificationCompat.InboxStyle();
//        String[] events = new String[6];
//        inboxStyle.setBigContentTitle("Event tracker details:");
//        for (int i=0; i < events.length; i++) {
//
//            inboxStyle.addLine(events[i]);
//        }
//        mBuilder.setStyle(inboxStyle);


        //内容显示多行
        mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(text)
                .setBigContentTitle(title));

        //当设备处于使用状态下（已经解锁并且屏幕亮着）时，这种通知以一个小的浮动窗口的形式呈现出来,优先级必须为 high 或者以上
        mBuilder.setFullScreenIntent(resultPendingIntent,false);

        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        //第一个参数为 应用唯一，全靠这个 id 来操作这个通知
        notificationManager.notify(1, mBuilder.build());


    }
}
