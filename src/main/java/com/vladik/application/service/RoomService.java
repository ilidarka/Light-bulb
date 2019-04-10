package com.vladik.application.service;

import java.util.List;

import com.vladik.application.entity.Room;

public interface RoomService extends Service<Room>{

	boolean changeCondition(Room room);
	
	public Room read(Long id);

	public List<Room> read();

	public void save(Room entity);

	public void delete(Long id);
	
}