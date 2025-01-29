package ru.liga.kafkataskclient.kafka.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.liga.kafkataskclient.dto.AnswerDto;
import ru.liga.kafkataskclient.kafka.MessageProducer;

@Service
@RequiredArgsConstructor
public class KafkaProduceService implements MessageProducer<AnswerDto> {

    private final KafkaTemplate<String, AnswerDto> kafkaTemplate;

    @Override
    public void send(String topic, String ownerName, AnswerDto answerDto) {
        kafkaTemplate.send(topic, ownerName, answerDto);
    }
}
