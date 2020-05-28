package com.sun.shard.service.impl;

import com.sun.shard.bean.User;
import com.sun.shard.mapper.AloneUserMapper;
import com.sun.shard.mapper.UserMapper;
import com.sun.shard.service.AloneUserService;
import com.sun.shard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AloneUserServiceImpl implements AloneUserService {

	
		@Autowired
		private AloneUserMapper aloneUserMapper;

		@Override
		public void save(User user) {
			user.setCreateTime(new Date());
			aloneUserMapper.save(user);
		}

		@Override
		public User get(Long id) {
			// TODO Auto-generated method stub
			return aloneUserMapper.get(id);
		}
		
		
}
