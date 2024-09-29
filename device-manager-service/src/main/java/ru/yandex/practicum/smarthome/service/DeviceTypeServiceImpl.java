package ru.yandex.practicum.smarthome.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.smarthome.dto.DeviceTypeDto;
import ru.yandex.practicum.smarthome.entity.DeviceType;
import ru.yandex.practicum.smarthome.repository.DeviceTypeRepository;

@Service
@RequiredArgsConstructor
public class DeviceTypeServiceImpl implements DeviceTypeService {

    private final DeviceTypeRepository deviceTypeRepository;

    @Override
    public DeviceTypeDto createDeviceType(DeviceTypeDto requestDto) {
        DeviceType deviceType = new DeviceType();
        deviceType.setName(requestDto.getName());
        DeviceType saved = deviceTypeRepository.save(deviceType);
        DeviceTypeDto result = new DeviceTypeDto();
        result.setName(saved.getName());
        result.setId(saved.getId());
        return result;
    }
}
