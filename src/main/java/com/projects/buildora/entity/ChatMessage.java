package com.projects.buildora.entity;


import com.projects.buildora.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ChatMessage {

    Long id;

    ChatSession chatSession;

    MessageRole role;

    String content;

    String toolCalls;

    Integer tokensUsed;

    Instant createdAt;



}
