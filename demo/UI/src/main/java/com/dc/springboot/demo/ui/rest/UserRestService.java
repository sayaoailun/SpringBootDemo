package com.dc.springboot.demo.ui.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.dc.springboot.demo.ui.utils.RestClient;

@RestController
@EnableAutoConfiguration
@RequestMapping("user")
public class UserRestService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	@ResponseBody
	public String getUsers(HttpServletRequest request, HttpServletResponse response) {
		WebTarget target = RestClient.getBackend();
		String result = target.path("user").path("users").request().get(String.class);
		log.info("getUsers: {}", result);
		return result;
	}
	
	@RequestMapping(value = "user", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body) {
		WebTarget target = RestClient.getBackend();
		String entity_body = JSON.toJSONString(body);
		String result = target.path("user").path("user").request().post(Entity.entity(entity_body, MediaType.APPLICATION_JSON), String.class);
		log.info("addUser: {}", result);
		return result;
	}
	
	@RequestMapping(value = "users", method = RequestMethod.POST)
	@ResponseBody
	public String addUsers(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Map<String, Object>> body) {
		WebTarget target = RestClient.getBackend();
		String entity_body = JSON.toJSONString(body);
		String result = target.path("user").path("users").request().post(Entity.entity(entity_body, MediaType.APPLICATION_JSON), String.class);
		log.info("addUsers: {}", result);
		return result;
	}
	
	@RequestMapping(value = "user", method = RequestMethod.PUT)
	@ResponseBody
	public String updateUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body) {
		WebTarget target = RestClient.getBackend();
		String entity_body = JSON.toJSONString(body);
		String result = target.path("user").path("user").request().put(Entity.entity(entity_body, MediaType.APPLICATION_JSON), String.class);
		log.info("updateUser: {}", result);
		return result;
	}
	
	@RequestMapping(value = "user/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("name") String name) {
		WebTarget target = RestClient.getBackend();
		String result = target.path("user").path("user").path(name).request().delete(String.class);
		log.info("updateUser: {}", result);
		return result;
	}
	
	@RequestMapping(value = "users", method = RequestMethod.PUT)
	@ResponseBody
	public String deleteUsers(HttpServletRequest request, HttpServletResponse response, @RequestBody String[] ids) {
		WebTarget target = RestClient.getBackend();
		String entity_body = JSON.toJSONString(ids);
		String result = target.path("user").path("users").request().put(Entity.entity(entity_body, MediaType.APPLICATION_JSON), String.class);
		log.info("updateUser: {}", result);
		return result;
	}

}
