package bookshop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getNow(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return format.format(date);
	}
}
