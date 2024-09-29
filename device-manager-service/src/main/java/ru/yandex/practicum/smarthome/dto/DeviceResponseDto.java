package ru.yandex.practicum.smarthome.dto;

import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.smarthome.entity.DeviceStatus;

@Data
@Builder
public class DeviceResponseDto {

    private Long id;
    private String name;
    private String deviceTypeName;
    private String serial;
    private DeviceStatus status;
    private String locationAddress;
}
