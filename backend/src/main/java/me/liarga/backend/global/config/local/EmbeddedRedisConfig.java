package me.liarga.backend.global.config.local;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import me.liarga.backend.global.config.local.redis.OS;
import me.liarga.backend.global.config.local.redis.RedisAvailablePortFind;
import me.liarga.backend.global.config.local.redis.RedisAvailablePortFindForDebian;
import me.liarga.backend.global.config.local.redis.RedisAvailablePortFindForLinux;
import me.liarga.backend.global.config.local.redis.RedisAvailablePortFindForMac;
import me.liarga.backend.global.config.local.redis.RedisAvailablePortFindForUbuntu;
import me.liarga.backend.global.config.local.redis.RedisAvailablePortFindForWindows;
import redis.embedded.RedisServer;

@Configuration
public class EmbeddedRedisConfig {

	private static final String OS_NAME = System.getProperty("os.name");

	@Value("${spring.data.redis.port}")
	private int redisPort;

	private RedisServer redisServer;

	@PostConstruct
	private void start() throws IOException {
		RedisAvailablePortFind findAvailablePortUtils = getRedisAvailablePortFind();

		int port = findAvailablePortUtils.isRedisRunning(redisPort)
			? findAvailablePortUtils.findAvailablePort(redisPort)
			: redisPort;
		// log.info("Embedded Redis Running Port : [{}]", port);

		redisServer = new RedisServer(port);
		redisServer.start();
	}

	@PreDestroy
	private void stop() throws IOException {
		if (redisServer != null) {
			redisServer.stop();
		}
	}

	private RedisAvailablePortFind getRedisAvailablePortFind() {
		if (OS.MAC.contains(OS_NAME)) {
			return new RedisAvailablePortFindForMac();
		} else if (OS.WINDOWS.contains(OS_NAME)) {
			return new RedisAvailablePortFindForWindows();
		} else if (OS.UBUNTU.contains(OS_NAME)) {
			return new RedisAvailablePortFindForUbuntu();
		} else if (OS.LINUX.contains(OS_NAME)) {
			return new RedisAvailablePortFindForLinux();
		} else if (OS.DEBIAN.contains(OS_NAME)) {
			return new RedisAvailablePortFindForDebian();
		}
		throw new IllegalArgumentException("Unsupported OS : " + OS_NAME);
	}
}
