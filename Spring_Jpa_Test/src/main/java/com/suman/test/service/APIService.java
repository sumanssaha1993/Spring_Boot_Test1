package com.suman.test.service;

import java.util.ArrayList;
import java.util.Map;

import com.suman.test.DTO.UserDTO;

public interface APIService {

	public void insertUser(String username, String password);
	public UserDTO getUser(String user_name);
	public void insertDataFromExcel(Map<Integer, ArrayList<String>> data);
}
