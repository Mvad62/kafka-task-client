package ru.liga.kafkataskclient.dto;

import java.util.List;
import java.util.UUID;

public record AnswerDto(

        UUID taskUuid,

        List<Integer> numbers
) {
}
