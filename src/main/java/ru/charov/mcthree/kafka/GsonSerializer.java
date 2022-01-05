package ru.charov.mcthree.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Serializer;
import ru.charov.mcthree.config.LocalDateTimeDeserializer;
import ru.charov.mcthree.config.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Map;

public class GsonSerializer<T> implements Serializer<T> {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    private Gson gson = new GsonBuilder()
            .setDateFormat(DATETIME_FORMAT)
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .create();

    @Override
    public void configure(Map<String, ?> config, boolean isKey) {
        // this is called right after construction
        // use it for initialisation
    }

    @Override
    public byte[] serialize(String s, T t) {
        return gson.toJson(t).getBytes();
    }

    @Override
    public void close() {
        // this is called right before destruction
    }
}
