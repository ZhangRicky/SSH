package com.mark.service;

import java.util.List;

import com.mark.entity.City;
import com.mark.entity.Country;

/**
 * 数据查询接口
 * @author Mark
 *
 */
public interface BrandStoreService {
	
	List<City> selectAllCityMessage();
	
	List<Country> selectAllCountryMessage();
}
