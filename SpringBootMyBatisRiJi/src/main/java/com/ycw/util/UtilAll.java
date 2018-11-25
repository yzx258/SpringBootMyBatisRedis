package com.ycw.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilAll {

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getTime(int i) {
		if (i == 1) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time = df.format(new Date());
			return time;
		} else {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			return time;
		}
	}
}
