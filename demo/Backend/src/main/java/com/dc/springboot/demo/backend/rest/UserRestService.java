package com.dc.springboot.demo.backend.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.dc.springboot.demo.backend.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("user")
public class UserRestService {
	
	@Resource
	private UserService service;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	@ResponseBody
	public String getUsers(HttpServletRequest request, HttpServletResponse response) {
		return JSON.toJSONString(service.select(null));
	}
	
	@RequestMapping(value = "user", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body) {
		body.put("id", UUID.randomUUID().toString());
		int count = service.insert(body);
		Map<String, Object> result = new HashMap<>();
		if (count == 1) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		return JSON.toJSONString(result);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.POST)
	@ResponseBody
	public String addUsers(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Map<String, Object>> body) {
		for (Map<String, Object> user : body) {
			user.put("id", UUID.randomUUID().toString());
		}
		Map<String, Object> users = new HashMap<>();
		users.put("users", body);
		int count = service.multiInsert(users);
		Map<String, Object> result = new HashMap<>();
		if (count == body.size()) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		return JSON.toJSONString(result);
	}
	
	
	@RequestMapping(value = "user", method = RequestMethod.PUT)
	@ResponseBody
	public String updateUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body) {
		int count = service.update(body);
		Map<String, Object> result = new HashMap<>();
		if (count == 1) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		return JSON.toJSONString(result);
	}
	
	@RequestMapping(value = "user/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("name") String name) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		int count = service.delete(param);
		Map<String, Object> result = new HashMap<>();
		if (count == 1) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		return JSON.toJSONString(result);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.PUT)
	@ResponseBody
	public String deleteUsers(HttpServletRequest request, HttpServletResponse response, @RequestBody String[] ids) {
		int count = service.multiDelete(ids);
		Map<String, Object> result = new HashMap<>();
		if (count == ids.length) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		return JSON.toJSONString(result);
	}

}
