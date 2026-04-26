package com.example.chatrecord.controller;

import com.example.chatrecord.model.MessageRecord;
import com.example.chatrecord.service.ChatRecordService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ChatPageController {

    private final ChatRecordService chatRecordService;

    public ChatPageController(ChatRecordService chatRecordService) {
        this.chatRecordService = chatRecordService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("form", new ChatInputForm());
        model.addAttribute("records", List.of());
        return "chat";
    }

    @PostMapping("/generate")
    public String generate(@ModelAttribute("form") ChatInputForm form, Model model) {
        List<MessageRecord> records = chatRecordService.generate(form.getConversation());
        model.addAttribute("records", records);
        return "chat";
    }

    public static class ChatInputForm {
        @NotBlank(message = "请输入对话内容")
        private String conversation;

        public String getConversation() {
            return conversation;
        }

        public void setConversation(String conversation) {
            this.conversation = conversation;
        }
    }
}
