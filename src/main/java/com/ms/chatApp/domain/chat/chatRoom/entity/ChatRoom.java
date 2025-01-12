package com.ms.chatApp.domain.chat.chatRoom.entity;

import com.ms.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ms.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 채팅방 아이디

    private Long masterId; // 채팅방 생성자

    private String chatRoomName; // 채팅방 이름

    private Integer userCount; // 채팅방 인원수

    @OneToMany
    private List<ChatMessage> chatMessages;

    @Builder
    public ChatRoom(Long masterId, String chatRoomName, Integer userCount) {
        this.masterId = masterId;
        this.chatRoomName = chatRoomName;
        this.userCount = userCount;
    }

    public void updateChatRoom(Long masterId, String chatRoomName) {
        this.masterId = masterId;
        this.chatRoomName = chatRoomName;
    }
}