package com.ms.chatApp.domain.chat.chatRoom.entity;

import com.ms.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ms.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class ChatRoom  extends BaseEntity {
    private String name;

    @OneToMany
    private List<ChatMessage> chatMessages;
}