package ru.kustikov.cakes.mail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailData {
    public String email;
    public String text;
}

