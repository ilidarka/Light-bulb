package com.vladik.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladik.application.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}