package ru.charov.mcthree.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.charov.mcthree.model.Message;

import java.net.URI;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MC3Service {

    private final String MC1_URL = "http://mcone:8080/mc1/send";
    @Qualifier("client")
    private final RestTemplate restTemplate;


    public void send(Message msg) {
        msg.setMC3_timestamp(LocalDateTime.now());
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application","json"));
        HttpEntity<Message> requestEntity = new HttpEntity<>(msg, requestHeaders);
        restTemplate.postForObject(URI.create(MC1_URL), requestEntity, String.class);
    }
}
