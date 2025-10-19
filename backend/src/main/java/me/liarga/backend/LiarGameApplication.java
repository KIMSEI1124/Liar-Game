package me.liarga.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
@SpringBootApplication
public class LiarGameApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiarGameApplication.class, args);
	}
}