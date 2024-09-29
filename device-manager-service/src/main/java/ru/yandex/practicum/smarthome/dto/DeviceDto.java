package ru.yandex.practicum.smarthome.dto;

import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.smarthome.entity.DeviceStatus;

@Data
@Builder
public class DeviceDto {

    private Long id;
    private Long houseId;
    private Long deviceTypeId;
    private String name;
    private String serial;
    private DeviceStatus status;

}
