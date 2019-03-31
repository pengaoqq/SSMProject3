package cn.goktech.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.goktech.mapper.UsersMapper;
import cn.goktech.pojo.Users;
import cn.goktech.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersMapper usersMapper;

	@Override
	public int insRegister(Users users) {
		return usersMapper.insUsers(users);
	}
	
}
