package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SimpleDate {
	private static String simpledate;
	Date realdate = new Date();
	public static String getSimpleDate(Date realdate){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpledate = simpleDateFormat.format(realdate);
		return simpledate;
	}
}
