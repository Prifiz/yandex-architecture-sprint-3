package ru.yandex.practicum.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.yandex.practicum.smarthome.entity.Telemetry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {

    Optional<Telemetry> findFirstByDeviceIdOrderByProducedAtDesc(Long deviceId);

    @Query("from Telemetry t where t.deviceId = :deviceId and t.producedAt between :startDate and :endDate")
    List<Telemetry> findAllByDeviceIdBetweenDates(@Param("deviceId") Long deviceId,
                                                  @Param("startDate") LocalDateTime startDate,
                                                  @Param("endDate") LocalDateTime endDate);

}
