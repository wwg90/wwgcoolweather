package com.wwg.coolweather.app.util;

import android.text.TextUtils;
import android.util.Log;

import com.wwg.coolweather.app.db.CoolWeatherDB;
import com.wwg.coolweather.app.model.City;
import com.wwg.coolweather.app.model.County;
import com.wwg.coolweather.app.model.Province;

public class Utility {

	/**
	 * �����ʹ�����������ص�ʡ������
	 * @param coolWeatherDB
	 * @param response
	 * @return
	 */
	public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
		if(!TextUtils.isEmpty(response)){
			Log.d("wwg", "utility-province-response="+response);
			String[] allProvinces = response.split(",");
			if(allProvinces != null && allProvinces.length > 0){
				for(String p : allProvinces){
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//���������������ݴ浽Province��
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �����ʹ�����������ص��м�����
	 * @param coolWeatherDB
	 * @param response
	 * @param provinceId
	 * @return
	 */
	
	public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			Log.d("wwg", "utility-city-response="+response);
			String[] allCities = response.split(",");
			if(allCities != null && allCities.length > 0){
				for(String c : allCities){
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					
					//���������������ݴ洢��City��
					coolWeatherDB.saveCity(city);
					
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �����ʹ�����������ص��ؼ�����
	 * @param coolWeatherDB
	 * @param response
	 * @param cityId
	 * @return
	 */
	public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
		
		if(!TextUtils.isEmpty(response)){
			Log.d("wwg", "utility-county-response="+response);
			String[] allCounties = response.split(",");
			if(allCounties != null && allCounties.length > 0){
				for(String c : allCounties){
					String[] array = c.split("\\|");
					County county = new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					
					//���������������ݴ浽County��
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		
		return false;
	}
	
	
}
