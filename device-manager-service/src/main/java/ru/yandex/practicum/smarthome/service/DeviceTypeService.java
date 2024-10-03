package ru.yandex.practicum.smarthome.service;

import ru.yandex.practicum.smarthome.dto.DeviceTypeDto;

public interface DeviceTypeService {

    DeviceTypeDto createDeviceType(DeviceTypeDto requestDto);
}
