package ru.charov.mcthree.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.charov.mcthree.model.Message;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MC3Service {

    private final String URI = "http://mcone:8080/mc1/send";
    private final Gson mapper;

    public void send(Message msg) {
        msg.setMC3_timestamp(LocalDateTime.now());
        new RestTemplate().postForEntity(java.net.URI.create(URI), mapper.toJson(msg), String.class);
    }
}
