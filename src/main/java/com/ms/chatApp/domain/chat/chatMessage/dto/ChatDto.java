package com.ms.chatApp.domain.chat.chatMessage.dto;

import com.ms.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ms.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class ChatDto {

    public enum MessageType {
        // 메세지 타입에 따라서 동작하는 구조가 달라진다.
        // ENTER - 입장, LEAVE - 퇴장, TALK - 채팅방을 SUB 하고 있는 모든 클라이언트에게 전달
        ENTER, TALK, LEAVE;
    }

    private MessageType messageType; // 메세지 타입
    private Long chatRoomId; // 채팅방 번호
    private Long senderId; // 채팅을 보낸 사람 ID
    private String message; // 메세지

    public ChatMessage toEntity(ChatRoom chatRoom) {
        return ChatMessage.builder()
                .chatRoom(chatRoom)
                .senderId(senderId)
                .message(message)
                .build();
    }
}
