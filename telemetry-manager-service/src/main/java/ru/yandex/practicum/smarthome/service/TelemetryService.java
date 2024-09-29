package ru.yandex.practicum.smarthome.service;

import ru.yandex.practicum.smarthome.dto.TelemetryArray;
import ru.yandex.practicum.smarthome.dto.TelemetryDto;

import java.time.LocalDateTime;

public interface TelemetryService {

    TelemetryDto getLatestTelemetryRecord(Long deviceId);

    TelemetryArray getTelemetryForPeriod(Long deviceId, LocalDateTime from, LocalDateTime to);
}
