package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static void main(String[] args) {
        System.out.println(formatDateTime12("2019-06-11 09:05:46"));
        System.out.println(convertByFommat("2019-06-11 09:05:46","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss"));
    }

    /**
     * 根据指定格式进行转化
     *
     * @param  srcDateString 来源时间字符串
     * @param srcFormat 来源时间格式
     * @param targetFormat 目标格式
     * @return  获取 按照指定格式转化得字符串
     * @createTime 2019年06月17日
     * @author zhaomh
     */
    public static String convertByFommat(String srcDateString, String srcFormat, String targetFormat) {
        String targetDateString = "";
        try {
            Date parsedDate = new SimpleDateFormat(srcFormat).parse(srcDateString);
            targetDateString = new SimpleDateFormat(targetFormat).format(parsedDate);
        }catch (ParseException ignore){}
        return targetDateString;
    }

    public static String formatDateTime12(String time) {
        return formatDateTime12(time, "-");
    }

    public static String formatDateTime12(String time, String Separator) {
        if (time == null) {
            return "";
        } else {
            StringBuffer ret = new StringBuffer();
            if (time != null && time.length() == 6) {
                ret.append("20" + time.substring(0, 2));
                ret.append(Separator);
                ret.append(time.substring(2, 4));
                ret.append(Separator);
                ret.append(time.substring(4, 6));
                ret.append(" ");
                ret.append("00");
                ret.append(":");
                ret.append("00");
                return ret.toString();
            } else if (time != null && time.length() == 8) {
                ret.append(time.substring(0, 4));
                ret.append(Separator);
                ret.append(time.substring(4, 6));
                ret.append(Separator);
                ret.append(time.substring(6, 8));
                ret.append(" ");
                ret.append("00");
                ret.append(":");
                ret.append("00");
                return ret.toString();
            } else if (time != null && time.length() == 14) {
                ret.append(time.substring(0, 4));
                ret.append(Separator);
                ret.append(time.substring(4, 6));
                ret.append(Separator);
                ret.append(time.substring(6, 8));
                ret.append(" ");
                ret.append(time.substring(8, 10));
                ret.append(":");
                ret.append(time.substring(10, 12));
                return ret.toString();
            } else {
                return time;
            }
        }
    }
}
