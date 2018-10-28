package com.blog.ehcache.ehcacheboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EntityScan(basePackages = "com.blog.ehcache.ehcacheboot.entity")
public class EhcacheBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhcacheBootApplication.class, args);
	}
}