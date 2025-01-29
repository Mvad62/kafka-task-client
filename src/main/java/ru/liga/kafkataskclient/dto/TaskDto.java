package ru.liga.kafkataskclient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Serializable {

    private UUID taskUuid;
    private List<Integer> numbers;

    public UUID taskUuid() {
        return taskUuid;
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
