package ru.yandex.practicum.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.smarthome.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
