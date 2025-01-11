package com.ms.chatApp.domain.chat.chatRoom.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class ChatDto {

    public enum MessageType {
        ENTER, TALK, LEAVE;
    }

    private MessageType messageType; // 메세지 타입
    private final Long chatRoomId; // 채팅방 번호
    private final String sender; // 채팅을 보낸 사람
    private String message; // 메세지
    private String time; // 채팅 발송 시간
}
