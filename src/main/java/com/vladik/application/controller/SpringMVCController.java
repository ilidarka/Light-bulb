package com.vladik.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vladik.application.entity.Room;
import com.vladik.application.service.RoomService;

@Controller
@RequestMapping("/")
public class SpringMVCController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value="/room/", method = RequestMethod.GET)
	public String getRoomById(ModelMap map, @RequestParam("roomButton") Long id) {
		Room room = roomService.read(id);
		map.addAttribute("roomById", room);
		return "room";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getAllRooms(ModelMap map) {
		List<Room> rooms = roomService.read();
		map.addAttribute("roomList", rooms);
		return "rooms";
	}
	
	@RequestMapping(value="/changeCondition", method = RequestMethod.POST)
	@ResponseBody
    public boolean changeCondition(@RequestParam("id") Long id) { 
		Room room = roomService.read(id);
		roomService.changeCondition(room);
		roomService.save(room);
		return room.isEnabled();
    }
	
	@MessageMapping("/request")
	@SendTo("/topic/messages")
	public String send(String message) throws Exception {
		System.out.println("Request from room: " + message);
	    return message;
	}
}
