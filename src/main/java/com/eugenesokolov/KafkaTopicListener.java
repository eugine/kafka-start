package com.eugenesokolov;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class KafkaTopicListener {

    private final CountDownLatch latch1 = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "test")
    public void listen(String foo) {
        System.out.println("Msg received: " + foo);
        this.latch1.countDown();
    }
}
