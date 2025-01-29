package ru.liga.kafkataskclient.serializer;

import org.springframework.kafka.support.serializer.JsonSerializer;

public class NoHeaderJsonSerializer<T> extends JsonSerializer<T> {

    @Override
    public byte[] serialize(String topic, T data) {
        return super.serialize(topic, data);
    }
}
