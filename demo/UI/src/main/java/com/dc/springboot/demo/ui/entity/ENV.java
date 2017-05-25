package com.dc.springboot.demo.ui.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ENV {
	
	public static String BACKEND_URL;
	
	public ENV(@Value("${backend_url}")String backend_url) {
		BACKEND_URL = backend_url;
	}

}
