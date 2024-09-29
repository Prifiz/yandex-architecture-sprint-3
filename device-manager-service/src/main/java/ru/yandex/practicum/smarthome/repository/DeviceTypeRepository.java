package ru.yandex.practicum.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.smarthome.entity.DeviceType;

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {
}
