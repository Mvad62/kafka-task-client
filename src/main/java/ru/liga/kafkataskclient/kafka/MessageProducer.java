package ru.liga.kafkataskclient.kafka;

public interface MessageProducer<T> {
    void send(String topic, String ownerName, T message);
}
