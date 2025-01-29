package ru.liga.kafkataskclient.dto;

import lombok.Builder;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Builder
public record TaskDto (

        UUID taskUuid,

        List<Integer> numbers
) {}
