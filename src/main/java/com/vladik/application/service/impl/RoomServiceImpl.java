package com.vladik.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladik.application.entity.Room;
import com.vladik.application.repository.RoomRepository;
import com.vladik.application.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomRepository repository;

	@Override
	public boolean changeCondition(Room room) {
		if(room.isEnabled()) {
			room.setEnabled(false);
			return room.isEnabled();
		} else {
			room.setEnabled(true);
			return room.isEnabled();
		}
	}

	@Override
	public Room read(Long id) {
		if(id != null) {
			return repository.getOne(id);
		}
		return null;
	}

	@Override
	public List<Room> read() {
		return this.repository.findAll();
	}

	@Override
	public void save(Room entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}