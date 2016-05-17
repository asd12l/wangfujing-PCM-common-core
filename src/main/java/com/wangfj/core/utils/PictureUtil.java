package com.wangfj.core.utils;

public class PictureUtil {

	private static final String PIC_URL = "/blgroup-osp-prod/userfiles/";

	private static final String PIC_IP = "http://211.147.91.92/pic/";

	public static String formatUrl (String url) {
		if (url == null || "".endsWith(url.trim())) {
			return "";
		}
		String result = url.replace(PIC_URL, PIC_IP);
		return result;
	}
	
	public static String formatUrl (String url,String picIp) {
        if (url == null || "".endsWith(url.trim())) {
            return "";
        }
        String result = url.replace(PIC_URL, picIp);
        return result;
    }
}