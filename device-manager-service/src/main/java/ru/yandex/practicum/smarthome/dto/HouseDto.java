package ru.yandex.practicum.smarthome.dto;

import lombok.Data;

@Data
public class HouseDto {

    private Long id;
    private String address;
    private Long userId;
}
