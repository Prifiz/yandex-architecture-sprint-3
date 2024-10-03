package ru.yandex.practicum.smarthome.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.smarthome.dto.CommandDto;
import ru.yandex.practicum.smarthome.dto.DeviceDto;
import ru.yandex.practicum.smarthome.dto.DeviceResponseDto;
import ru.yandex.practicum.smarthome.dto.DeviceStatusDto;
import ru.yandex.practicum.smarthome.service.DeviceService;

@RestController
@RequestMapping("/api/device")
@RequiredArgsConstructor
public class DeviceController {

    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceResponseDto> createDevice(@RequestBody DeviceDto request) {
        DeviceResponseDto created = deviceService.createDevice(request);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{device_id}")
    public ResponseEntity<DeviceResponseDto> getDevice(@PathVariable("device_id") Long deviceId) {
        DeviceResponseDto found = deviceService.getDevice(deviceId);
        return ResponseEntity.ok(found);
    }


    @PostMapping("/{device_id}/command")
    public ResponseEntity<Void> executeCommandOnDevice(@PathVariable("device_id") Long deviceId,
                                               @RequestBody CommandDto command) {
        deviceService.sendCommand(deviceId, command);
        logger.info("Command message has been successfully sent");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{device_id}/status")
    public ResponseEntity<Void> updateDeviceStatus(@PathVariable("device_id") Long deviceId,
                                             @RequestBody DeviceStatusDto deviceStatusDto) {
        deviceService.updateStatus(deviceId, deviceStatusDto);
        logger.info("Status update message has been successfully sent");
        return ResponseEntity.noContent().build();
    }
}
