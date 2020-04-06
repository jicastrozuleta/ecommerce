package co.com.application.ecommerce;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utils {
	
	private static Random random = new Random();

	private Utils() {

	}

	public static Date expirationTime() {
		Date now = new Date();
		Calendar exp = Calendar.getInstance();
		exp.setTime(now);
		exp.add(Calendar.MINUTE, 20);
		exp.setTime(exp.getTime());
		return exp.getTime();
	}
	
	
	public static int generateNumber() {
	    return random.ints(100001, 999999).findFirst().getAsInt();
	}
}
