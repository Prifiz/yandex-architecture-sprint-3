package ru.yandex.practicum.smarthome.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.smarthome.dto.DeviceTypeDto;
import ru.yandex.practicum.smarthome.service.DeviceTypeService;

@RestController
@RequestMapping("/api/device-type")
@RequiredArgsConstructor
public class DeviceTypeController {

    private static final Logger logger = LoggerFactory.getLogger(DeviceTypeController.class);

    private final DeviceTypeService deviceTypeService;

    @PostMapping()
    public ResponseEntity<DeviceTypeDto> createDeviceType(@RequestBody DeviceTypeDto deviceTypeDto) {
        logger.info("Adding new device type {}", deviceTypeDto);
        DeviceTypeDto created = deviceTypeService.createDeviceType(deviceTypeDto);
        return ResponseEntity.ok(created);
    }
}
