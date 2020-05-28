package com.sun.shard.service;

import com.sun.shard.bean.User;

public interface AloneUserService {
	
	void save(User user);

	User get(Long l);
}	
