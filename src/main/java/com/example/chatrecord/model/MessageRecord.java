package com.example.chatrecord.model;

import java.time.LocalDateTime;

public record MessageRecord(String speaker, String content, LocalDateTime timestamp) {
}
