package com.will.weiyue.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * gson工具类
 */
public class GsonUtils {

	/**
	 * json字符串变为实体类
	 * 
	 * @param json
	 *            json字符串
	 * @param cls
	 *            实体类的class类型
	 */
	public static <T> T getModelfromJson(String json, Class<T> cls) {
		Gson gson = new Gson();
		T t = null;
		try {
			t = gson.fromJson(json, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	/***
	 * 获取list实体列表
	 * 
	 * @param json
	 *            字符串
	 * @return
	 */
	public static <T> ArrayList<T> getListfromJson(String json, Class<T> cls) {
		Gson gson = new Gson();
		ArrayList<T> list = new ArrayList<T>();
		try {
			list = gson.fromJson(json, new TypeToken<ArrayList<T>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/** 获取map的list列表 */
	public static <T> List<Map<String, Object>> getListMapFromJson(String json) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Gson gson = new Gson();
		try {
			list = gson.fromJson(json,
					new TypeToken<List<Map<String, Object>>>() {
					}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 返回cla 类型的list数组
	 *
	 * @param s
	 * @param cla
	 * @return
	 */
	public static <T extends Object> T jsonToBeanList(String s, Class<?> cla) {

		List<Object> ls = new ArrayList<Object>();
		JSONArray ss;
		try {
			ss = new JSONArray(s);
			for (int i = 0; i < ss.length(); i++) {
				String str = ss.getString(i);
				Object a = jsonToBean(str, cla);
				ls.add(a);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (T) ls;
	}

	/**
	 * 将jsonStr转换成cl对象
	 *
	 * @param jsonStr
	 * @return
	 */
	public static <T extends Object> T jsonToBean(String jsonStr, Class<?> cl) {
		Object obj = null;
		Gson gson = new Gson();
		if (gson != null) {
			if (!TextUtils.isEmpty(jsonStr))
				obj = gson.fromJson(jsonStr, cl);
		}
		return (T) obj;
	}



	/** 获取json对象中的值 */
	public static String getValue(String key, JSONObject obj) {
		try {
			JSONObject jobj = obj;
			if (jobj.has(key)) {
				return jobj.getString(key);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * map转json
	 * @param map
	 * @return
	 */
	public static String simpleMapToJsonStr(Map<String ,String > map){
		if(map==null||map.isEmpty()){
			return "null";
		}
		String jsonStr = "{";
		Set<?> keySet = map.keySet();
		for (Object key : keySet) {
			jsonStr += "\""+key+"\":\""+map.get(key)+"\",";
		}
		jsonStr = jsonStr.substring(0,jsonStr.length()-1);
		jsonStr += "}";
		return jsonStr;
	}
}
