/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author gian
 */
public class Conversor {
    private Object DateTimeZone;
    private Object DateTimeFormat;

    /**
     *
     * @param utilDate
     * @return String com a data no formato de banco de dados MySQL 5.5,
     * "yyyy-MM-dd"
     */
    public String converterUtilDateToSqlDate(java.util.Date utilDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sqlDate = sdf.format(utilDate);
        return sqlDate;
    }

    /**
     *
     * @param utilDate
     * @return String com a data no formato de "dd/MM/yyyy"
     */
    public String converterSqlDateToUtilDate(java.util.Date utilDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String sqlDate = sdf.format(utilDate);
        return sqlDate;
    }

    /**
     *
     * @param strDate
     * @return Java date no formato "dd/MM/yyyy"
     * @throws ParseException
     */
    public Date converterStringDateToUtilDate(String strDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date data = new java.sql.Date(format.parse(strDate).getTime());
        return data;
    }

    /**
     *
     * @param strTime
     * @return
     * @throws ParseException
     */
    public java.sql.Time converterStringHH_mmToHH_mm_ss(String strTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        java.sql.Time time = new java.sql.Time(format.parse(strTime).getTime());
        return time;
    }

    /**
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public String converterSqlTimeHH_mm_ssToHH_mm(java.sql.Time time) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String sqlDate = sdf.format(calendar.getTime());
        return sqlDate;
    }

    /**
     * 
     * @param yourmilliseconds
     * @return SimpleDateFormat("dd/MM/yyyy HH:mm")
     */
    public String converterMilliSecsToJavaUtil(long yourmilliseconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
        calendar.setTimeInMillis(yourmilliseconds);
        return (String) sdf.format(calendar.getTime());
    }
    
    /**
     * 
     * @param yourmilliseconds
     * @return SimpleDateFormat("dd/MM/yyyy")
     */
    public String converterMilliSecsToDateUtil(long yourmilliseconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
        calendar.setTimeInMillis(yourmilliseconds);
        return (String) sdf.format(calendar.getTime());
    }
    
    /**
     * 
     * @param yourmilliseconds
     * @return SimpleDateFormat("HH:mm")
     */
    public String converterMilliSecsToTimeUtil(long yourmilliseconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
        calendar.setTimeInMillis(yourmilliseconds);
        return (String) sdf.format(calendar.getTime());
    }
    
    /**
     * 
     * @param strDate
     * @param strTime
     * @return calendar.getTimeInMillis()
     * @throws ParseException 
     */
    public long converterStringDateAndTimeToMilliSecs(String strDate,String strTime) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        java.util.Date data = new java.sql.Date(formatDate.parse(strDate+" "+strTime).getTime());
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
        calendar.setTime(data);
        return calendar.getTimeInMillis();
    }

    /**
     * 
     * @param strDate
     * @return calendar.getTimeInMillis()
     * @throws ParseException 
     */
    public long converterStringDateToMilliSecs(String strDate) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date data = new java.sql.Date(formatDate.parse(strDate).getTime());
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
        calendar.setTime(data);
        return calendar.getTimeInMillis();
    }
    
    /**
     * 
     * @param strTime
     * @return calendar.getTimeInMillis()
     * @throws ParseException 
     */
    public long converterStringTimeToMilliSecs(String strTime) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm:ss");
        java.util.Date data = new java.sql.Date(formatDate.parse(strTime).getTime());
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
        calendar.setTime(data);
        return calendar.getTimeInMillis();
    }
}
