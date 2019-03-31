package cn.goktech.mapper;

import org.apache.ibatis.annotations.Insert;

import cn.goktech.pojo.Users;

public interface UsersMapper {
	@Insert("insert into users values(default,#{username},#{password},#{photo})")
	int insUsers(Users users);
}
