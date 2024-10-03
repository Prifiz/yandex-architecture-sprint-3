package ru.yandex.practicum.smarthome.service;

import ru.yandex.practicum.smarthome.dto.CommandDto;
import ru.yandex.practicum.smarthome.dto.DeviceDto;
import ru.yandex.practicum.smarthome.dto.DeviceResponseDto;
import ru.yandex.practicum.smarthome.dto.DeviceStatusDto;
import ru.yandex.practicum.smarthome.entity.DeviceStatus;

public interface DeviceService {

    DeviceResponseDto createDevice(DeviceDto requestDto);

    DeviceResponseDto getDevice(Long deviceId);

    void sendCommand(Long deviceId, CommandDto commandDto);

    void updateStatus(Long deviceId, DeviceStatusDto statusToSet);
}
