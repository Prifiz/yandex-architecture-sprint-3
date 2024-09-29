package ru.yandex.practicum.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.smarthome.entity.House;

public interface HouseRepository extends JpaRepository<House, Long> {
}
