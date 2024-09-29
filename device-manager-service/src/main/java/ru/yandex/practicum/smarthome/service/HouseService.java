package ru.yandex.practicum.smarthome.service;

import ru.yandex.practicum.smarthome.dto.HouseDto;

public interface HouseService {

    HouseDto createHouse(HouseDto requestDto);
}
