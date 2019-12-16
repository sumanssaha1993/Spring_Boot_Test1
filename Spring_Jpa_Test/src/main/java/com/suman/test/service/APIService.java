package com.suman.test.service;

import java.util.ArrayList;
import java.util.Map;

public interface APIService {

	public void insertUser(String username, String password);
	public void insertDataFromExcel(Map<Integer, ArrayList<String>> data);
}
