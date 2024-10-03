package ru.yandex.practicum.smarthome.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.smarthome.dto.CommandDto;
import ru.yandex.practicum.smarthome.dto.DeviceDto;
import ru.yandex.practicum.smarthome.dto.DeviceResponseDto;
import ru.yandex.practicum.smarthome.dto.DeviceStatusDto;
import ru.yandex.practicum.smarthome.entity.Device;
import ru.yandex.practicum.smarthome.entity.DeviceType;
import ru.yandex.practicum.smarthome.entity.House;
import ru.yandex.practicum.smarthome.repository.DeviceRepository;
import ru.yandex.practicum.smarthome.repository.DeviceTypeRepository;
import ru.yandex.practicum.smarthome.repository.HouseRepository;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final HouseRepository houseRepository;
    private final DeviceTypeRepository deviceTypeRepository;

    @Override
    public DeviceResponseDto createDevice(DeviceDto requestDto) {
        DeviceType deviceType = deviceTypeRepository.findById(requestDto.getDeviceTypeId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("No such device type by id: %s", requestDto.getDeviceTypeId())));
        House house = houseRepository.findById(requestDto.getHouseId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("No such house by id: %s", requestDto.getHouseId())));
        Device toBeCreated = new Device();
        toBeCreated.setHouse(house);
        toBeCreated.setDeviceType(deviceType);
        toBeCreated.setSerial(requestDto.getSerial());
        toBeCreated.setStatus(requestDto.getStatus());
        toBeCreated.setName(requestDto.getName());
        Device created = deviceRepository.save(toBeCreated);
        return this.toResponseDto(created);
    }

    @Override
    public DeviceResponseDto getDevice(Long deviceId) {
        return this.toResponseDto(deviceRepository.findById(deviceId)
                .orElseThrow(() -> new RuntimeException("No such device")));
    }

    private DeviceResponseDto toResponseDto(Device device) {
        return DeviceResponseDto.builder()
                .id(device.getId())
                .name(device.getName())
                .deviceTypeName(device.getDeviceType().getName())
                .serial(device.getSerial())
                .status(device.getStatus())
                .locationAddress(device.getHouse().getAddress())
                .build();
    }

    @Override
    public void sendCommand(Long deviceId, CommandDto commandDto) {
        // копипаст и хардкод ужасный
        Properties props = new Properties();
        props.put("bootstrap.servers", "broker:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(
                "device_commands",
                Long.toString(deviceId), commandDto.getCommandText());
        producer.send(record);
        producer.close();
    }

    @Override
    @Transactional
    public void updateStatus(Long deviceId, DeviceStatusDto statusToSet) {
        Device deviceToUpdate = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new RuntimeException("No such device"));
        // копипаст и хардкод ужасный
        Properties props = new Properties();
        props.put("bootstrap.servers", "broker:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(
                "device_statuses",
                Long.toString(deviceId), statusToSet.getStatus().name());
        producer.send(record);
        producer.close();
        deviceToUpdate.setStatus(statusToSet.getStatus());
        deviceRepository.save(deviceToUpdate);
    }
}
