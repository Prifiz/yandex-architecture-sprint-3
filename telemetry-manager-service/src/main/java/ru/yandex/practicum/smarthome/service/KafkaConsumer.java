package ru.yandex.practicum.smarthome.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.smarthome.dto.TelemetryDto;
import ru.yandex.practicum.smarthome.entity.Telemetry;
import ru.yandex.practicum.smarthome.repository.TelemetryRepository;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    private final TelemetryRepository telemetryRepository;

    @KafkaListener(topics = "sensor_data", containerFactory = "telemetryKafkaListenerFactory")
    public void consumeTelemetry(TelemetryDto telemetryMessage) {
        logger.info("Consumed message: {}", telemetryMessage);
        Telemetry telemetry = new Telemetry();
        telemetry.setDeviceId(telemetryMessage.getDeviceId());
        telemetry.setTelemetryUnit(telemetryMessage.getTelemetryUnit());
        telemetry.setData(telemetryMessage.getData());
        telemetry.setProducedAt(telemetryMessage.getProducedAt());
        telemetryRepository.save(telemetry);
    }
}
