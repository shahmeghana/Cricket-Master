package com.nouhoun.springboot.jwt.integration.util;

import java.util.Calendar;
import java.util.Date;

public class Utility {

	public static Date addCalenderDays(Date date, int days)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		c.add(Calendar.DATE, days);
		
		return c.getTime();
	}
	
	public static Date addCalenderMinutes(Date date, int min)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		c.add(Calendar.MINUTE, min);
		
		return c.getTime();
	}
}
