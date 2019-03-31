package cn.goktech.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.goktech.mapper.FilesMapper;
import cn.goktech.pojo.Files;
import cn.goktech.pojo.Users;
import cn.goktech.service.FilesService;

@Service
public class FilesServiceImpl implements FilesService {
	@Resource
	private FilesMapper filesMapper;

	@Override
	public List<Files> selAll() {
		return filesMapper.selAll();
	}

	@Override
	public int updCountById(int id, Users users, String name) {
		Logger logger = Logger.getLogger(FilesServiceImpl.class);
		logger.info(users.getUsername()+"下载了"+name);
		return filesMapper.updCountById(id);
	}
	
}
