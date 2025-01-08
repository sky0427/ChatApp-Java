package com.ms.chatApp.domain.chat.chatMessage.dto;

import lombok.Builder;

@Builder
public record ChatMessageResponse(Long id, String content, String writer) {
}