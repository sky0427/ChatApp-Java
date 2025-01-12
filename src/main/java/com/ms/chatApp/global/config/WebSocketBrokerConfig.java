package com.ms.chatApp.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

    // STOMP를 사용하면 웹소켓만 사용할 때와 다르게 하나의 연결주소마다 핸들러 클래스를 구현할 필요없이 Controller 방식으로 간편하게 사용 가능

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // stomp 접속 주소 URL
        registry.addEndpoint("/chat") // 엔드포인트
                .setAllowedOrigins("*") // CORS 설정
                .withSockJS(); // SocketJS 연결 설정
    }

    // 메세지 브로커 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // enableSimpleBroker : 내장 메세지 브로커를 사용하기 위한 메소드
        // 파라미터로 지정한 prefix가 붙은 메세지를 발행할 경우 -> 메세지 브로커가 이를 처리
        // 메세지를 구독하는 요청 URL = 메세지 받을 때
        registry.enableSimpleBroker("/sub");

        // 메세지 핸들러로 라우틸되는 prefix를 파라미터로 지정 가능
        // 메세지 가공 처리가 필요한 경우, 가공 핸들러로 메세지를 라우팅 되도록하는 설정
        // 메세지를 발행하는 요청 URL = 메세지 보낼 때
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
