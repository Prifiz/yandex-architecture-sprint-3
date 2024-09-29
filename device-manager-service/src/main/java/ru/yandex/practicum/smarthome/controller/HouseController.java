package ru.yandex.practicum.smarthome.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.smarthome.dto.HouseDto;
import ru.yandex.practicum.smarthome.service.HouseService;

@RestController
@RequestMapping("/api/house")
@RequiredArgsConstructor
public class HouseController {

    private static final Logger logger = LoggerFactory.getLogger(HouseController.class);

    private final HouseService houseService;

    @PostMapping()
    public ResponseEntity<HouseDto> createHouse(@RequestBody HouseDto requestDto) {
        logger.info("Adding new house {}", requestDto);
        HouseDto created = houseService.createHouse(requestDto);
        return ResponseEntity.ok(created);
    }
}
