package com.ms.chatApp.domain.chat.chatMessage.controller;

import com.ms.chatApp.domain.chat.chatMessage.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ApiV1ChatMessageController {
    private final ChatMessageService chatMessageService;
    // private final SimpleMessageSendingOperation template;

    @GetMapping("/api/v1/chat/rooms/{roomId}/messages")

    //1번채팅방 메시지 목록 조회 완료 id : 2
    public String getChatMessages(@PathVariable("roomId") Long roomId, @RequestParam(value ="afterChatMessageId", defaultValue = "-1") long afterChatMessageId) {
        return roomId+"번 채팅방 메시지 목록 조회완료 id :" + afterChatMessageId;
    }

    @PostMapping("/api/v1/chat/rooms/{roomId}/messages")
    public String createChatMessage(@PathVariable("roomId") Long roomId) {
        return roomId + "번 채팅방 메시지 생성완료";
    }
}
