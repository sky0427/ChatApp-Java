package com.ms.chatApp.domain.chat.chatRoom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDto {

    public enum ChatType {
        MSG, RTC
    }

    private String roomId; // 채팅방 아이디
    private String roomName; // 채팅방 이름
    private Integer userCount; // 채팅방 인원수
    private Integer maxUserCount; // 채팅방 최대 인원

    private String roomPwd; // 채팅방 삭제 시 필요한 비밀번호
    private boolean isSecret; // 채팅방 잠금 여부
    private ChatType chatType; // 채팅 타입 여부

    // ChatRoomDto 클래스는 하나로 가되 서비스를 나누었음.
    // ConcurrentHashMap - HashMap 의 안전한 버전으로 key, value 에 null 값을 허용하지 않는다. + 동기화 보장 (Thread-Safe)
    // Key : 유저 UUID, Value : 유저 아이디
    private ConcurrentHashMap<String, ?> memberList = new ConcurrentHashMap<>();
}
