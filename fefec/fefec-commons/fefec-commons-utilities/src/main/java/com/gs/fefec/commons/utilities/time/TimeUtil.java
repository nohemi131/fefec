package com.gs.fefec.commons.utilities.time;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeSet;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

/**
 *
 * @author B739496 Nohemi Zavaleta Sanchez
 * @version 0.0.1 SNAPSHOT
 * @see 07/22/2014
 */
public class TimeUtil {
   private static final Logger log = Logger.getLogger(TimeUtil.class.getName());
   private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

   private TimeUtil(){

   }

   public static String formatSysDateMMDDYYYY(String time){
	   Date date = new Date();
	   return dateFormat.format(date)+" "+ time;
   }

    public static double getElapsedTime(double startTime) {
        return (System.nanoTime() - startTime) / 1000000;
    }

    public static Date dateNearestUpper(ArrayList<Date> dates, Date targetDate) {
        Date dateNearest = new Date();
        TreeSet<Date> treeSet = new TreeSet<Date>(dates);

        if (treeSet.contains(targetDate)) {
            dateNearest = targetDate;
        } else {
            dateNearest = treeSet.ceiling(targetDate);
        }
        return dateNearest;
    }

    public static Date stringToDate(String strDate, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
        	 log.info(e.getMessage());
        }
        return date;
    }

    public static String dateToString(Date date, String format) {
        String strDate = new String();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        strDate = simpleDateFormat.format(date);
        return strDate;
    }
    /**
     * Converts Date object into XMLGregorianCalendar
     * @return XMLGregorianCalendar
     * */
    public static XMLGregorianCalendar dateToXMLGregorianCalendar()
    {

        DatatypeFactory dtf=null;
        try {
            dtf = DatatypeFactory.newInstance();
        } catch (Throwable e) {
        	log.error(e.getMessage());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        XMLGregorianCalendar
                xmlGregCal =  dtf.newXMLGregorianCalendar(new GregorianCalendar(calendar.getTimeZone()));

        return xmlGregCal;
    }

	//  validate dateOriination and Daye now
	  public static long validaFec(Date now, Date origitaion) {
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			long diffDays;
			try {
				Date todayWithZeroTime = formatter.parse(formatter.format(now));
				cal1.setTime(todayWithZeroTime);
				cal2.setTime(origitaion);

				long milis1 = cal1.getTimeInMillis();
				long milis2 = cal2.getTimeInMillis();

				long diff = milis2 - milis1;

				diffDays = diff / (24 * 60 * 60 * 1000);
			} catch (ParseException e) {
				log.info(""+ e.fillInStackTrace());
				return 0;
			}
			return diffDays;
		}
}
