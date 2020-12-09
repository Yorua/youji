package com.travelElf.youji.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTools {
    /**
     * value = yyyy-MM-dd HH:mm:ss
     */
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * value = yyyy-MM-dd HH:mm:ss
     */
    public static final String FULL_STAND_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * value = yyyy/MM/dd HH:mm:ss
     */
    public static final String FULL_STAND_FORMAT_2 = "yyyy/MM/dd HH:mm:ss";
    /**
     * value = yyyyMMddHHmmss
     */
    public static final String FULL_SPECIAL_FORMAT = "yyyyMMddHHmmss";
    /**
     * value = yyyyMMdd HH:mm:ss
     */
    public static final String FULL_SPECIAL_FORMAT2 = "yyyyMMdd HH:mm:ss";
    /**
     * value = yy-MM-dd HH:mm"
     */
    public static final String SIMPLE_STAND_FORMAT = "yy-MM-dd HH:mm";
    /**
     * value = yyyy-MM-dd HH:mm
     */
    public static final String FULL_DATE_SIMPLE_TIME = "yyyy-MM-dd HH:mm";

    /**
     * value = yyyy-MM-dd
     */
    public static final String SIMPLE_STAND_DATE = "yyyy-MM-dd";
    /**
     * value = yyyy
     */
    public static final String SIMPLE_STAND_YEAR = "yyyy";
    /**
     * value = HH:mm:ss
     */
    public static final String FULL_TIME = "HH:mm:ss";

    /**
     * value = yyyyMMdd
     */
    public static final String SIMPLE_STAND_DATE2 = "yyyyMMdd";

    /**
     * value = yyyy_MM_dd
     */
    public static final String SIMPLE_STAND_DATE3 = "yyyy_MM_dd";

    /**
     * value = yyyy/MM/dd
     */
    public static final String SIMPLE_STAND_DATE4 = "yyyy/MM/dd";
    
    /**
     * value = yyyy-MM
     */
    public static final String SIMPLE_STAND_MONTH = "yyyy-MM";

    /**
     * value = yyyyMMdd
     */
    public static final String SIMPLE_STAND_MONTH2 = "yyyyMM";

    /**
     * value = yyyy_MM_dd
     */
    public static final String SIMPLE_STAND_MONTH3 = "yyyy_MM";

    /**
     * value = yyyy/MM/dd
     */
    public static final String SIMPLE_STAND_MONTH4 = "yyyy/MM";

    /**
     * value = yyyy/MM/dd HH:mm:ss
     */
    public static final String SIMPLE_STAND_DATE5 = "yyyy/MM/dd HH:mm:ss";

    public static String getCurrentDate(String pattern) {
        return dateFormat(new Date(), pattern);
    }

    /**
     * return format yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        return dateFormat(date, FULL_STAND_FORMAT);
    }

    public static String dateFormat(Date date, String pattern) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String result = sdf.format(date);
        return result;
    }

    public static Date intConvertDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar ca = Calendar.getInstance();
        ca.set(year, month, day, hour, minute, second);
        return ca.getTime();
    }

    public static Date strConvertDate(String str) throws ParseException {
        DateFormat df = DateFormat.getDateInstance();
        return df.parse(str);
    }

    public static Date strConvertDate(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(str);
    }
    
    public static Calendar strConverCalendar(String source) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(FULL_SPECIAL_FORMAT);
        df.parse(source);
        return df.getCalendar();
    }

    public static Calendar strConverCalendar(String source, String pattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        df.parse(source);
        return df.getCalendar();
    }

    public static Calendar dateConverCalendar(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }
    
    /**
     * 在日期上加上一定的秒数
     * 
     * @param date
     *            日期
     * @param seconds
     *            需要增加的秒数, 如果为负数，表示减去多少秒
     * @return
     */
    public static Date dateAddSeconds(Date date, int seconds) {
        return new Date(date.getTime() + ((long) seconds * 1000));
    }

    /**
     * 在日期上加上一定的分钟
     * 
     * @param date
     *            日期
     * @param minutes
     *            需要增加的分钟数, 如果为负数，表示减去多少分钟
     * @return
     */
    public static Date dateAddMinutes(Date date, int minutes) {
        return new Date(date.getTime() + ((long) minutes * 60 * 1000));
    }

    /**
     * 在日期上加上一定的小时
     * 
     * @param date
     *            日期
     * @param hours
     *            需要增加的小时数, 如果为负数，表示减去多少小时
     * @return
     */
    public static Date dateAddHours(Date date, int hours) {
        return new Date(date.getTime() + ((long) hours * 60 * 60 * 1000));
    }

    /**
     * 在日期上加上一定的天数
     * 
     * @param date
     *            日期
     * @param days
     *            需要增加的天数, 如果为负数，表示减去多少天
     * @return
     */
    public static Date dateAddDays(Date date, int days) {
        return new Date(date.getTime() + ((long) days * 24 * 60 * 60 * 1000));
    }
    /**
     * 在日期上加上一定的月数
     * @param date
     * @param months
     * @return
     */
    public static Date dateAddMonths(Date date, int months){
    	GregorianCalendar gc=new GregorianCalendar(); 
    	gc.setTime(date); 
    	gc.add(Calendar.MONTH, months);
    	return gc.getTime();
    }

    /**
     * 获取当前时间戳
     * 
     * @return
     */
    public static Long getTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 将时间段分割成每一天
     * 
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public static List<Date> dateSplit(Date startDate, Date endDate) throws Exception {
        if (startDate.compareTo(endDate) > 0)
            throw new Exception("结束时间应该在开始时间之后");

        Long msec = endDate.getTime() - startDate.getTime(); // 相差毫秒数
        Long days = msec / 1000 / 60 / 60 / 24; // 相差天数

        List<Date> dateList = new ArrayList<Date>();
        for (int i = 0; i <= days; i++) {
            Long temp = (long) i * (24 * 60 * 60 * 1000);
            dateList.add(new Date(endDate.getTime() - temp));
        }
        return dateList;
    }

    /**
     * 获取年
     * 
     * @param date
     * @return
     * @throws Exception
     * @author qtj
     * @date 2015年1月28日
     */
    public static int getYear(Date date) throws Exception {
        if (null == date)
            throw new Exception("日期格式错误");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月
     * 
     * @param date
     * @return
     * @throws Exception
     * @author qtj
     * @date 2015年1月28日
     */
    public static String getMonth(Date date) throws Exception {
        if (null == date)
            throw new Exception("日期格式错误");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        return month < 10 ? "0" + month : String.valueOf(month);
    }

    /**
     * 获取昨天的日期
     * 
     * @param pattern
     *            日期格式
     * @return
     */
    public static String yesterday(String pattern) {
        Date date = dateAddDays(new Date(), -1);
        return dateFormat(date, pattern);
    }

//去除时间格式最后的点0
    public static String stringToDate(String date) {
        if (date!=null && !date.trim().equals("")){
            int length = date.length();
            if (length>19){
                return date.substring(0,date.length()-2);
            }
        }
        return date;
    }
    //去除时间格式最后的点0
    public static String stringToDateMin(String date) {
        if (date!=null && !date.trim().equals("")){
            int length = date.length();
            if (length>16){
                return date.substring(0,16);
            }
        }
        return date;
    }
    //格式化年月日
    public static String stringToDateDay(String date) {
        if (date!=null && !date.trim().equals("")){
            int length = date.length();
            if (length>10){
                return date.substring(0,10);
            }
        }
        return date;
    }
    //毫秒转换为日期
    public static String stringChangeDate(String date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long aLong = Long.valueOf(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(aLong);
        String format = formatter.format(calendar.getTime());
        return format;
    }
    
    public static int daysBetween(Date smdate,Date bdate){    
        
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        try {
			smdate=sdf.parse(sdf.format(smdate));
			bdate=sdf.parse(sdf.format(bdate));  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	        return Integer.parseInt(String.valueOf(between_days)); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return 0; 
    }
    //strConvertDate
    //毫秒转换为日期
    public static boolean isOutTime(String date) {
        try {
            Date date1 = strConvertDate(date);
            Date date2=new Date();
            if (date1.getTime()<date2.getTime()){
              return true;
            }else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return false;
    }
   // strConvertDate
   public static boolean isMinTime(String date,long min) {
       try {
           Date date1 = strConvertDate(date,"yyyy-MM-dd HH:mm:ss");
           Date date2=new Date();
           if (date1.getTime()+min<date2.getTime()){
               return true;
           }else {
               return false;
           }
       } catch (ParseException e) {
           e.printStackTrace();
       }
       return false;
   }
   public static int differenceDays(String startDate,String endDate){
	   int days=0;
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   if (!startDate.equals(endDate)) {
	     try {
			long time = sdf.parse(endDate).getTime() - sdf.parse(startDate).getTime();
			days=(int)time/(1000 * 60 * 60 * 24)+1;
			return days;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	   }
		return 1;
   }
   //时间戳转日期
   public static String timestampConvertDate(Long timestamp,String fromat){
	   SimpleDateFormat format =  new SimpleDateFormat(fromat);
	   String  date= null;
	   try {
		   date=format.format(timestamp);  
		   return date;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return date;
   }
   
   /**
    * 根据时间获取小时差
    * @param startDate
    * @param endDate
    * @return
    * @throws Exception
    */
   public static int dateDiffHour(Date startDate, Date endDate) throws Exception {
	   
	   int  diffHour= 0;
       if (startDate.compareTo(endDate) > 0){
    	   return 0;
       }
       
       Long msec = endDate.getTime() - startDate.getTime(); // 相差毫秒数
       Long hours = msec / 1000 / 60 / 60 ; // 相差小时数
       diffHour = hours.intValue();
       if (diffHour*1000*60*60<msec) {
		diffHour=diffHour+1;
	}
       return diffHour;
   }
   
   /**
    * 根据时间计算天差
    * @param startDate
    * @param endDate
    * @return
    * @throws Exception
    */
   public static int dateDiffDay(Date startDate, Date endDate) throws Exception {
	   
	   int  diffDay= 0;
       if (startDate.compareTo(endDate) > 0){
    	   return 0;
       }
       
       Long msec = endDate.getTime() - startDate.getTime(); // 相差毫秒数
       Long days = msec / 1000 / 60 / 60 /24 ; // 相差天数
       diffDay = days.intValue();
       if (diffDay*1000*60*60*24<msec) {
    	   diffDay=diffDay+1;
   	}
       return diffDay;
   }
}
