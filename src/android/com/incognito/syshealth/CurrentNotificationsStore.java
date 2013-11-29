package com.incognito.syshealth;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.NotificationCompat;
import android.text.Html;

public class CurrentNotificationsStore
{
  private static List<ProblemAlert> notifications = new ArrayList<ProblemAlert>();
  
  public static List<ProblemAlert> getNotifications()
  {
    return notifications;
  }
  
  public static void addNotification(ProblemAlert notification)
  {
    int existingAlertIdx = notifications.indexOf(notification);
    
    if (existingAlertIdx >= 0)
    {
      notifications.remove(existingAlertIdx);
    }

     notifications.add(notification);
  }
  
  public static void clearAll()
  {
    notifications.clear();
  }
  
  public static void convertToBigViewStyleNotification(NotificationCompat.Builder mBuilder)
  {
    if (notifications.size() > 1)
    {
      // set Big View Style
      NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
      
      String contentTitle = notifications.size() + " new problems";
      
      mBuilder.setContentTitle(contentTitle);
      mBuilder.setTicker(contentTitle);
      inboxStyle.setBigContentTitle(contentTitle);
      
      for (int i=0; i<notifications.size(); i++)
      {
        inboxStyle.addLine(
            Html.fromHtml("<b>"+notifications.get(i).getTitle()+"</b> " + notifications.get(i).getContent()));
      }
      mBuilder.setStyle(inboxStyle);
      mBuilder.setNumber(notifications.size());
    }
    else 
    {
      NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
      bigTextStyle.bigText(notifications.get(0).getContent());
      
      mBuilder.setStyle(bigTextStyle);
    }
  }
}
