package weather;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
 public static String getWeekOfDate(Date dt) {
 String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
Calendar cal = Calendar.getInstance();
 cal.setTime(dt);
 int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
 if (w < 0)
 w = 0;
 return weekDays[w];
}
 public static String getYear(){
 Calendar calendar = Calendar.getInstance();
 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 String time = format.format(calendar.getTime());
 return time;
 }
}
