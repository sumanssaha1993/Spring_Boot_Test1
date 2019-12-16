package com.suman.test.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suman.test.DAO.APIDAO;
import com.suman.test.DTO.UserDTO;

@Service
public class APIServiceImpl implements APIService{

	@Autowired
	public APIDAO dao;

	@Override
	public void insertUser(String username, String password) {
		UserDTO dto = new UserDTO();
		dto.setUser_name(username);
		dto.setPassword(password);
		dao.save(dto);
	}

	@Override
	public void insertDataFromExcel(Map<Integer, ArrayList<String>> data) {
		try {
			for(ArrayList<String> ele : data.values()) {
				UserDTO dto = new UserDTO();
				dto.setUser_name(ele.get(0));
				dto.setPassword(ele.get(1));
				dao.save(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public UserDTO getUser(String user_name) {
		UserDTO user = null;
		try {
			user = dao.findUserData(user_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	
	
	

}
