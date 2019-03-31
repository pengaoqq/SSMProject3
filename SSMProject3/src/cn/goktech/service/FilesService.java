package cn.goktech.service;

import java.util.List;

import cn.goktech.pojo.Files;
import cn.goktech.pojo.Users;

public interface FilesService {
	//显示全部
	List<Files> selAll();
	//根据id修改资料下载次数
	int updCountById(int id, Users users, String name);
}
