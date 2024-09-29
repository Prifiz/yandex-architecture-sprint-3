package ru.yandex.practicum.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.smarthome.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
