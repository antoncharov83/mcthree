package ru.charov.mcthree.kafka;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.charov.mcthree.model.Message;
import ru.charov.mcthree.service.MC3Service;

@Component
@RequiredArgsConstructor
@Slf4j
public class Listener {

    private final MC3Service mc3Service;

    private final Gson mapper;

    @KafkaListener(topics = "topicMC3")
    public void get(String msgTxt) {
        var msg = mapper.fromJson(msgTxt, Message.class);
        mc3Service.send(msg);
    }
}
