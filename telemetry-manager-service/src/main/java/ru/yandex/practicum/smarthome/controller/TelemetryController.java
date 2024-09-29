package ru.yandex.practicum.smarthome.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.smarthome.dto.TelemetryArray;
import ru.yandex.practicum.smarthome.dto.TelemetryDto;
import ru.yandex.practicum.smarthome.dto.TelemetryRequestDto;
import ru.yandex.practicum.smarthome.service.TelemetryService;

@RestController
@RequestMapping("/api/device")
@RequiredArgsConstructor
public class TelemetryController {

    private final TelemetryService telemetryService;

    @PostMapping("{device_id}/telemetry")
    public ResponseEntity<TelemetryArray> getTelemetryForPeriod(@PathVariable("device_id") Long deviceId,
                                                                @RequestBody TelemetryRequestDto requestDto) {
        TelemetryArray telemetryArray = telemetryService.getTelemetryForPeriod(
                deviceId, requestDto.getFrom(), requestDto.getTo()); // валидации значений from и to нет
        return ResponseEntity.ok(telemetryArray);
    }

    @GetMapping("{device_id}/telemetry/latest")
    public ResponseEntity<TelemetryDto> getLatestTelemetry(@PathVariable("device_id") Long deviceId) {
        TelemetryDto telemetryDto = telemetryService.getLatestTelemetryRecord(deviceId);
        return ResponseEntity.ok(telemetryDto);
    }
}
