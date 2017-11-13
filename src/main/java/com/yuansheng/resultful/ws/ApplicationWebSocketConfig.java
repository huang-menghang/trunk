package com.yuansheng.resultful.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.yuansheng.resultful.handler.ApplicationWebSocketHandler;
import com.yuansheng.resultful.interceptor.HandshakeInterceptor;

// 注册websocket连接接口..
// 配置xml实现
@Configuration
@EnableWebMvc
@EnableWebSocket
public class ApplicationWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

		registry.addHandler(applicationWebSocketHandler(), "/websocket").addInterceptors(new HandshakeInterceptor()).setAllowedOrigins("*");

		// 前台 不可以使用websocket环境，则使用sockjs进行模拟连接
		registry.addHandler(applicationWebSocketHandler(), "/socketjs/websocket").addInterceptors(new HandshakeInterceptor()).withSockJS();

	}

	@Bean
	public ApplicationWebSocketHandler applicationWebSocketHandler() {

		return new ApplicationWebSocketHandler();
	}

}
