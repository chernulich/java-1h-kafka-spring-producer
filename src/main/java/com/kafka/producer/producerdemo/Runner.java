package com.kafka.producer.producerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Enter your message:");
            String message = new Scanner(System.in).nextLine();
            if (message.equals("exit")) {
                break;
            }
            kafkaTemplate.send("test", message);
        }
    }
}
