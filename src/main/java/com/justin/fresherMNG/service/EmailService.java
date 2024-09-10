package com.justin.fresherMNG.service;

public interface EmailService {
    void sendProjectNotification(String to, String subject, String body);
}
