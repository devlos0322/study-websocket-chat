package org.devlos.chatbackend01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //접속 허용 설정
        registry.addEndpoint("/chat").setAllowedOrigins("http://localhost:3000").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //topic = 1: N 일대 다 구독 방식, queue = 1:1 구독 방식
        registry.enableSimpleBroker("/topic", "/queue");
        //destination 헤더를 @Controller / @MessageMapping으로 라우팅 시킴
        registry.setApplicationDestinationPrefixes("/app");
    }

}
