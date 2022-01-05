package ru.charov.mcthree.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.charov.mcthree.model.Message;
import ru.charov.mcthree.service.MC3Service;

@Component
@RequiredArgsConstructor
public class Listener {

    private final MC3Service mc3Service;

    @KafkaListener(topics = "topicMC3")
    public void get(@Payload Message msg) {
        mc3Service.send(msg);
    }
}
