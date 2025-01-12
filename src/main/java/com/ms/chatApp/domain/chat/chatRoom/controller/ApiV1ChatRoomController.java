package com.ms.chatApp.domain.chat.chatRoom.controller;

import com.ms.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ms.chatApp.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
public class ApiV1ChatRoomController {
    private final ChatRoomService chatRoomService;
    // private final Map<String, WebSocketSession> ActiveUserMap = new ConcurrentHashMap<>();

    // 모든 채팅방 목록 반환 - getChatRooms
    @GetMapping
    public void getChatRooms(ChatRoom chatRoom) {}

    // 채팅방 생성 - createChatRoom
    public void createChatRoom(ChatRoom chatRoom) {}

    // 특정 채팅방 조회 - getChatRoomById
    public void getChatRoomById(ChatRoom chatRoom) {}

    // 특정 채팅방 삭제 - deleteChatRoomById
    public void deleteChatRoomById(ChatRoom chatRoom) {}

    // 유저 퇴장 시에는 EventListener 을 통해서 유저 퇴장을 확인


    // 채팅에 참여한 유저 리스트 반환 - getUserList


    // 채팅방 인원 + 1 - plusUserCnt


    // 채팅방 인원 - 1 - minusUserCnt
}