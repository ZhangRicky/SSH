package com.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;

/**
 * 操作Redis服务器的数据接口
 * 
 * 增，删，改，查
 * @author Mark
 * @param <T>
 *
 */
public interface RedisCacheService<T> {
	/**
	 * 缓存基本的对象，Integer、String、实体类等
	 * @param key	缓存的键
	 * @param value	缓存的值
	 * @return 返回缓存对象
	 */
	ValueOperations<String,T> setCacheObject(String key,T value);
	
	/**
	 * 获取基本对象
	 * @param key
	 * @return
	 */
	T getCacheObject(String key);
	
	/**
	 * 缓存List对象
	 * @param key
	 * @param dataList
	 * @return
	 */
	ListOperations<String, T> setCacheList(String key,List<T> dataList);
	
	/**
	 * 获取List对象
	 * @param key
	 * @return
	 */
	List<T> getCacheList(String key);
	
	/**
	 * 缓存Set对象
	 * @param key
	 * @param dataSet
	 * @return
	 */
	BoundSetOperations<String,T> setCacheSet(String key,Set<T> dataSet);
	
	/**
	 * 获取缓存的Set对象
	 * @param <T>
	 * @param key
	 * @return
	 */
	Set<T> getCacheSet(String key);
	
	/**
	 * 缓存Map对象
	 * @param key
	 * @param dataMap
	 * @return
	 */
	HashOperations<String,String,T> setCacheMap(String key,Map<String,T> dataMap);
	
	/**
	 * 获取Map对象
	 * @param key
	 * @return
	 */
	Map<String,T> getCacheMap(String key);
	
	/**
	 * 缓存Map对象，
	 * @param key
	 * @param dataMap
	 * @return
	 */
	HashOperations<String,Integer,T> setCacheIntegerMap(String key,Map<Integer,T> dataMap);
	
	/**
	 * 获取Map缓存
	 * @param key
	 * @return
	 */
	Map<Integer,T> getCacheIntegerMap(String key);

}
