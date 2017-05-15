package com.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisCacheServiceImpl<T> implements RedisCacheService<T> {

	@Autowired
	RedisTemplate jedisTemplate;
	
	@Override
	public ValueOperations<String, T> setCacheObject(String key, T value) {
		ValueOperations<String, T> opration =jedisTemplate.opsForValue();
		opration.set(key, value);
		return opration;
	}

	@Override
	public T getCacheObject(String key) {
		ValueOperations<String, T> opration =jedisTemplate.opsForValue();
		return opration.get(key);
	}

	@Override
	public ListOperations<String, T> setCacheList(String key, List<T> dataList) {
		ListOperations<String, T> opration=jedisTemplate.opsForList();
		if(dataList != null){
			for(int i =0; i<dataList.size(); i++){
				opration.rightPush(key,dataList.get(i));
			}
		}
		return opration;
	}

	@Override
	public List<T> getCacheList(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundSetOperations<String, T> setCacheSet(String key, Set<T> dataSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<T> getCacheSet(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashOperations<String, String, T> setCacheMap(String key, Map<String, T> dataMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, T> getCacheMap(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashOperations<String, Integer, T> setCacheIntegerMap(String key, Map<Integer, T> dataMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, T> getCacheIntegerMap(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
