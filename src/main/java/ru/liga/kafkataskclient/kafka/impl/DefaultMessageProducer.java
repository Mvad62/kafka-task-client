package ru.liga.kafkataskclient.kafka.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.liga.kafkataskclient.dto.AnswerDto;
import ru.liga.kafkataskclient.kafka.MessageProducer;

@Component
@RequiredArgsConstructor
public class DefaultMessageProducer implements MessageProducer<AnswerDto> {
    private final KafkaTemplate<String, AnswerDto> kafkaTemplate;

    @Override
    public void send(String topic, String ownerName, AnswerDto message) {
        kafkaTemplate.send(topic, ownerName, message);
    }
}