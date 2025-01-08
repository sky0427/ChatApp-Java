package com.ms.chatApp.domain.chat.chatMessage.entity;

import com.ms.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ms.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Entity
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_message_id")
    private Long id;

    private String writerName;
    private String content;
    @ManyToOne
    private ChatRoom chatRoom;
}