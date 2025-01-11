package com.ms.chatApp.domain.chat.chatRoom.controller;

import com.ms.chatApp.domain.chat.chatRoom.dto.ChatDto;
import com.ms.chatApp.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
public class ApiV1ChatRoomController {
    private final ChatRoomService chatRoomService;
    private final Map<String, WebSocketSession> ActiveUserMap = new ConcurrentHashMap<>();

    // 채팅 리스트 화면
    @GetMapping
    public String getChatRooms(Model model) {
        return "chatRooms";
    }

    @GetMapping("/chat/rooms/{roomId}")
    public String getChatRoom(@PathVariable("roomId") Long roomId) {
        return roomId + "번 채팅방 조회완료";
    }

    @PostMapping
    public String createChatRoom() {
        return "채팅방 생성완료";
    }

    // 채팅방 입장
    public void enter(ChatDto chatDto, WebSocketSession session) {
        String username = (String) session.getAttributes().get("username");
        ActiveUserMap.put(username, session);
    }
}