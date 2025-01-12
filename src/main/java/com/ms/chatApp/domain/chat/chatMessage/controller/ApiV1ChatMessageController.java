package com.ms.chatApp.domain.chat.chatMessage.controller;

import com.ms.chatApp.domain.chat.chatMessage.dto.ChatDto;
import com.ms.chatApp.domain.chat.chatMessage.service.ChatMessageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Transactional
public class ApiV1ChatMessageController {
    private final ChatMessageService chatMessageService;

    // MessageMapping 을 통해 WebSocket 로 들어오는 메세지를 발신 처리한다.
    // 이때, 클라이언트에서 /pub/chat/message 로 요청하게 되고 이것을 controller 가 받아서 처리한다.
    // 처리가 완료되면, /sub/chat/room/:roomId 로 메세지가 전송된다.
    @MessageMapping("/chat/enterUser")
    public void enterUser(@Payload ChatDto chatDto) {

    }

    // getChatMessages (Slice -> Infinite Scroll)

    // sendChatMessage
    @MessageMapping("/chat/sendMessage")
    public void sendChatMessage(@Payload ChatDto chatDto) {
        log.info(chatDto.toString());
        chatDto.setMessage(chatDto.getMessage());
    }

}
