package com.ms.chatApp.domain.chat.chatMessage.service;

import com.ms.chatApp.domain.chat.chatMessage.dto.ChatDto;
import com.ms.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ms.chatApp.domain.chat.chatMessage.repository.ChatMessageRepository;
import com.ms.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ms.chatApp.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public void saveChatMessage(ChatDto chatDto) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatDto.getChatRoomId())
                .orElseThrow(() -> new NoSuchElementException("ChatRoom not found with id: " + chatDto.getChatRoomId()));
        chatMessageRepository.save(chatDto.toEntity(chatRoom));
    }
}
