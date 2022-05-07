package com.spring.runner;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.spring.components.IComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class RestfulApplicationRunner implements ApplicationRunner {
	
	@Autowired
	Map<String, IComponent> components;

	@Value("${opinion}")
	String javaVersion;
	@Autowired
	Environment env;

	private static LoadingCache<String, String> config = CacheBuilder.newBuilder()
	.maximumSize(1000)
	.refreshAfterWrite(10, TimeUnit.SECONDS)
	.build(new CacheLoader<String, String>() {
		@Override
		public String load(String key) throws Exception {
			System.out.println("Load called");
			return "Hello";
		}
		
	});

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(javaVersion);
		System.out.println(env.getProperty("java.runtime.version"));
	}
}
