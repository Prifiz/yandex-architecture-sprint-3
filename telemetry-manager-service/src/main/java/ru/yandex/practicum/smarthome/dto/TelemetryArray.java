package ru.yandex.practicum.smarthome.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TelemetryArray {

    private List<TelemetryDto> items;
}
