package ru.yandex.practicum.smarthome.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.smarthome.dto.UserDto;
import ru.yandex.practicum.smarthome.entity.User;
import ru.yandex.practicum.smarthome.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto request) {
        User user = new User();
        user.setName(request.getName());
        User saved = userRepository.save(user);
        UserDto result = new UserDto();
        result.setName(saved.getName());
        result.setId(saved.getId());
        return result;
    }




}
