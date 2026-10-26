package ru.liga.kafkataskclient.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.liga.kafkataskclient.dto.AnswerDto;
import ru.liga.kafkataskclient.dto.TaskDto;
import ru.liga.kafkataskclient.kafka.impl.DefaultMessageProducer;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TaskConsumer {

    private final DefaultMessageProducer messageProducer;

    @KafkaListener(topics = "in-task-1-sort-numbers-topic", groupId = "kafka-race")
    public void listen(@Payload TaskDto task) {
        System.out.println("Received task: " + task);

        processTask(task);
    }

    private void processTask(TaskDto task) {
        UUID taskUuid = task.taskUuid();
        List<Integer> numbers = task.numbers();

        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        messageProducer.send("out-answer-task-1-topic", "vadim.myachin", new AnswerDto(taskUuid, sortedNumbers));
    }
}