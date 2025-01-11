package com.ms.chatApp.global.config;

import com.ms.chatApp.global.config.handler.SocketTextHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket // websocket 서버로서 동작하도록
public class WebSocketConfig implements WebSocketConfigurer {

    private final SocketTextHandler socketTextHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(socketTextHandler, "/ws/chat")
                .setAllowedOrigins("*")
                .withSockJS();
    }
}
