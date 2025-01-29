package ru.liga.kafkataskclient.kafka.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.liga.kafkataskclient.dto.AnswerDto;
import ru.liga.kafkataskclient.dto.TaskDto;
import ru.liga.kafkataskclient.util.TaskSolver;

@Service
@RequiredArgsConstructor
public class KafkaListenService {

    private final KafkaProduceService kafkaProduceService;

    @KafkaListener(
            topics = "in-task-1-sort-numbers-topic",
            groupId = "client",
            containerFactory = "taskDtoConcurrentKafkaListenerContainerFactory"
    )
    public void listenFirstTask(@Payload TaskDto taskDto) {
        kafkaProduceService.send(
                "out-answer-task-1-topic",
                "Тимур Беженарь",
                new AnswerDto(
                        taskDto.taskUuid(),
                        TaskSolver.solveFirstTask(taskDto.numbers())
                )
        );
    }

    @KafkaListener(
            topics = "in-task-2-prime-numbers-topic",
            groupId = "client",
            containerFactory = "taskDtoConcurrentKafkaListenerContainerFactory"
    )
    public void listenSecondTask(@Payload TaskDto taskDto) {
        kafkaProduceService.send(
                "out-answer-task-2-topic",
                "Тимур Беженарь",
                new AnswerDto(
                        taskDto.taskUuid(),
                        TaskSolver.solveSecondTask(taskDto.numbers())
                )
        );
    }
}