package com.ms.chatApp.domain.chat.chatRoom.entity;

import com.ms.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ms.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom  extends BaseEntity {
    private String roomId; // 채팅방 아이디
    private String roomName; // 채팅방 이름
    private Integer userCount; // 채팅방 인원수

    @OneToMany
    private List<ChatMessage> chatMessages;

    public ChatRoom create(String roomName) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName = roomName;
        return chatRoom;
    }
}