package ru.yandex.practicum.smarthome.dto;

import lombok.Data;

@Data
public class CommandDto {

    // давайте считать, что модуль умеет это парсить,
    // некогда накручивать гибкость и маппинг девайсов на поддерживаемые ими команды с передачей значений
    private String commandText;

}
