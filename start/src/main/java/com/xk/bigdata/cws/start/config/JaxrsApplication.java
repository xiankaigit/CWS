package com.xk.bigdata.cws.start.config;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@Component
@ApplicationPath("/")
public class JaxrsApplication extends Application {

//	private  Set<Object> singletons = new HashSet<>();
//
//	@Override
//	public Set<Object> getSingletons() {
//		return singletons;
//	}

}