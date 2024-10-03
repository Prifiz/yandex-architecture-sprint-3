package ru.yandex.practicum.smarthome.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.smarthome.dto.HouseDto;
import ru.yandex.practicum.smarthome.entity.House;
import ru.yandex.practicum.smarthome.entity.User;
import ru.yandex.practicum.smarthome.repository.HouseRepository;
import ru.yandex.practicum.smarthome.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;
    private final UserRepository userRepository;

    @Override
    public HouseDto createHouse(HouseDto requestDto) {

        User owner = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        House house = new House();
        house.setAddress(requestDto.getAddress());
        house.setUser(owner);
        House saved = houseRepository.save(house);
        HouseDto result = new HouseDto();
        result.setId(saved.getId());
        result.setAddress(saved.getAddress());
        result.setUserId(saved.getUser().getId());
        return result;
    }
}
