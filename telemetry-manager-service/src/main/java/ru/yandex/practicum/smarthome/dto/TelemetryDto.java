package ru.yandex.practicum.smarthome.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class TelemetryDto {

    private Long id;
    private Long deviceId;
    private LocalDateTime producedAt;
    private String telemetryUnit;
    private String data;

}
