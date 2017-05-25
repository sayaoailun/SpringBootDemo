package com.dc.springboot.demo.backend.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.springboot.demo.backend.dao.UserDAO;

@Service("UserService")
public class UserService {

	@Resource
	private UserDAO dao;
	
	public int insert(Map<String, Object> param) {
		return dao.insert(param);
	}
	
	public int multiInsert(Map<String, Object> param) {
		return dao.multiInsert(param);
	}
	
	public int update(Map<String, Object> param) {
		return dao.update(param);
	}
	
	public List<Map<String, Object>> select(Map<String, Object> param) {
		return dao.select(param);
	}
	
	public int delete(Map<String, Object> param) {
		return dao.delete(param);
	}
	
	@Transactional
	public int multiDelete(String[] param) {
		return dao.multiDelete(param);
	}
	
}
