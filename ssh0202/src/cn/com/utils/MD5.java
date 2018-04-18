package cn.com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//base64 反向解密
//MD5 不可逆加密算法
public class MD5 {
	public static String encrypty(String source){
		MessageDigest md=null;
		StringBuffer sb = new StringBuffer();
		try {
			md = MessageDigest.getInstance("md5");
			byte[] result = md.digest(source.getBytes());//加密了
			for(byte b : result){
				int number = b & 0xff;
				String str  =  Integer.toHexString(number);
				if(str.length()==1){
					sb.append("0");
				}
				sb.append(str);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();
	}
}