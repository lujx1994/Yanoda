package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Month {
	private static String month;
	Date realdate = new Date();
	public static String getSimpleDate(Date realdate){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
		month = simpleDateFormat.format(realdate);
		return month;
	}
}