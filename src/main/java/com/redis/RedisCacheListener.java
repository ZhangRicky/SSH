package com.redis;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.mark.entity.City;
import com.mark.entity.Country;
import com.mark.service.BrandStoreService;
/**
 * 实现监听器，在程序启动的时候就将固定的城市列表加载到redis数据服务器中，
 * 下次读取该数据就可以不用去数据库查询
 * @author Mark
 *
 */
public class RedisCacheListener implements ApplicationListener<ContextRefreshedEvent> {
	
	//日志
	 private final Logger log= Logger.getLogger(RedisCacheListener.class);

	@Autowired
	RedisCacheService RedisCacheService;
	
	//注入从数据库查询数据的接口
	@Autowired
	BrandStoreService brandStoreService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent  event) {
		//spring 启动的时候缓存城市和国家等信息
		if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
			System.out.println("\n\n\n_________\n\n缓存数据 \n\n ________\n\n\n\n");
			List<City> cityList = brandStoreService.selectAllCityMessage();
			List<Country> countryList = brandStoreService.selectAllCountryMessage();
	    
			Map<Integer,City> cityMap = new HashMap<Integer,City>();
	    
			Map<Integer,Country> countryMap = new HashMap<Integer, Country>();
	    
			int cityListSize = cityList.size();
			int countryListSize = countryList.size();
	    
			for(int i = 0 ; i < cityListSize ; i ++ ){
				cityMap.put(cityList.get(i).getCity_id(), cityList.get(i));
			}
	    
			for(int i = 0 ; i < countryListSize ; i ++ ){
				countryMap.put(countryList.get(i).getCountry_id(), countryList.get(i));
			}
	    
			RedisCacheService.setCacheIntegerMap("cityMap", cityMap);
			RedisCacheService.setCacheIntegerMap("countryMap", countryMap);
		}
	}
}
