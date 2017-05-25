package com.dc.springboot.demo.backend.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service("UserDAO")
public class UserDAO {

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
	
	public int insert(Map<String, Object> param) {
		return this.sqlSessionTemplate.insert("user.insert", param);
	}
	
	public int multiInsert(Map<String, Object> param) {
		return this.sqlSessionTemplate.insert("user.multiInsert", param);
	}
	
	public int update(Map<String, Object> param) {
		return this.sqlSessionTemplate.update("user.update", param);
	}
	
	public List<Map<String, Object>> select(Map<String, Object> param) {
		return this.sqlSessionTemplate.selectList("user.select", param);
	}
	
	public int delete(Map<String, Object> param) {
		return this.sqlSessionTemplate.delete("user.delete", param);
	}
	
	public int multiDelete(String[] param) {
		return this.sqlSessionTemplate.delete("user.multiDelete", param);
	}
	
}
