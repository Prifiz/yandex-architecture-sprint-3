package ru.yandex.practicum.smarthome.service;

import ru.yandex.practicum.smarthome.dto.UserDto;
import ru.yandex.practicum.smarthome.entity.User;

public interface UserService {

    UserDto createUser(UserDto request);

}
