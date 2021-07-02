package com.github.kaydunovDenis.javarush;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EventListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageReceivedEvent implements EventListener {
    private String message;
}
