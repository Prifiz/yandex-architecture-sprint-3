package ru.yandex.practicum.smarthome.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.smarthome.dto.TelemetryArray;
import ru.yandex.practicum.smarthome.dto.TelemetryDto;
import ru.yandex.practicum.smarthome.entity.Telemetry;
import ru.yandex.practicum.smarthome.repository.TelemetryRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TelemetryServiceImpl implements TelemetryService {

    private final TelemetryRepository telemetryRepository;

    @Override
    public TelemetryDto getLatestTelemetryRecord(Long deviceId) {
        Telemetry found = telemetryRepository.findFirstByDeviceIdOrderByProducedAtDesc(deviceId)
                .orElseThrow(() -> new RuntimeException("Telemetry records not found"));
        return TelemetryDto.builder()
                .id(found.getId())
                .deviceId(found.getDeviceId())
                .telemetryUnit(found.getTelemetryUnit())
                .data(found.getData())
                .producedAt(found.getProducedAt())
                .build();
    }

    @Override
    public TelemetryArray getTelemetryForPeriod(
            Long deviceId, LocalDateTime from, LocalDateTime to) {
        return TelemetryArray.builder().items(
                telemetryRepository.findAllByDeviceIdBetweenDates(deviceId, from, to)
                        .stream()
                        .map(telemetry -> TelemetryDto.builder()
                                .id(telemetry.getId())
                                .deviceId(telemetry.getDeviceId())
                                .telemetryUnit(telemetry.getTelemetryUnit())
                                .data(telemetry.getData())
                                .producedAt(telemetry.getProducedAt())
                                .build())
                        .toList()).build();
    }
}
