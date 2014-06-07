package com.opsunv.cryptsy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ParseUtils {
	private final static ObjectMapper objectMapper = getObjectMapper();
	
	private static ObjectMapper getObjectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"){
			private static final long serialVersionUID = 1L;

			@Override
			public Date parse(String source) throws ParseException {
				if("0000-00-00 00:00:00".equals(source)){
					return null;
				}
				try{
					return super.parse(source);
				}catch (Exception e) {
					return null;
				}
			}
		};
		
		sdf.setTimeZone(TimeZone.getTimeZone("EST"));
		
		objectMapper.setDateFormat(sdf);
		
		return objectMapper;
	}
	
	public static <T> T convertValue(Object obj, Class<T> clazz){
		return objectMapper.convertValue(obj, clazz);
	}
	
	public static JsonNode pack(JsonNode rs,String fieldName){
		ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
		node.put(fieldName, rs);
		return node;
	}
	
	/**
	 * parse string to date use EST timezone
	 * @param str
	 * @return
	 */
	public static Date parseData(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("EST"));
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}
	
}
