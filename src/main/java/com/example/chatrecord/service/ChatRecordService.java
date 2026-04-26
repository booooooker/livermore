package com.example.chatrecord.service;

import com.example.chatrecord.model.MessageRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatRecordService {

    public List<MessageRecord> generate(String conversationInput) {
        List<MessageRecord> records = new ArrayList<>();
        if (conversationInput == null || conversationInput.isBlank()) {
            return records;
        }

        String[] lines = conversationInput.split("\\r?\\n");
        LocalDateTime baseTime = LocalDateTime.now();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) {
                continue;
            }

            String speaker = "用户";
            String content = line;
            int splitIndex = line.indexOf('：');
            if (splitIndex < 0) {
                splitIndex = line.indexOf(':');
            }

            if (splitIndex > 0 && splitIndex < line.length() - 1) {
                speaker = line.substring(0, splitIndex).trim();
                content = line.substring(splitIndex + 1).trim();
            }

            records.add(new MessageRecord(speaker, content, baseTime.plusSeconds(i * 15L)));
        }

        return records;
    }
}
