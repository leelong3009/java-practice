package com.sample.common;

import java.io.IOException;
import java.net.URISyntaxException;

import redis.embedded.RedisServer;

public class StartRedisServer {

	public static void main(String[] args) throws IOException, URISyntaxException {
		RedisServer server = new RedisServer("2.8.2400", 6379);
		server.start();

	}

}
