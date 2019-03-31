package cn.goktech.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.goktech.pojo.Users;
import cn.goktech.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("register")
	public String register(Users users, MultipartFile file, HttpServletRequest req) {
		String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String path = req.getServletContext().getRealPath("images/") + fileName;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		users.setPhoto(fileName);
		int index = usersServiceImpl.insRegister(users);
		if(index > 0) {
			req.getSession().setAttribute("user", users);
			return "redirect:/show";
		}else {
			return "redirect:/register.jsp";
		}
	}
}
