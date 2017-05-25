package com.dc.springboot.demo.ui.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.dc.springboot.demo.ui.entity.ENV;

public class RestClient {
	
	private static WebTarget backend;
	
	public static WebTarget getBackend() {
		if (backend == null) {
			Client client = ClientBuilder.newClient();
			backend = client.target(ENV.BACKEND_URL);
		}
		return backend;
	}

}
