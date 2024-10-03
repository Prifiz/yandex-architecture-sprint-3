package ru.yandex.practicum.smarthome.dto;

import lombok.Data;
import ru.yandex.practicum.smarthome.entity.DeviceStatus;

@Data
public class DeviceStatusDto {

    private DeviceStatus status;
}
