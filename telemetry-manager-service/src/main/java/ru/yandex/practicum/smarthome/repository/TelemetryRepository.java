package ru.yandex.practicum.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.smarthome.entity.Telemetry;

public interface TemperatureSensorRepository extends JpaRepository<Telemetry, Long> {

}
