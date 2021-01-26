package org.o7planning.fontend.controller;

import java.util.List;

import org.o7planning.fontend.model.Room;
import org.o7planning.fontend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class RoomController {
	@Autowired
	private RoomService roomService;

	

	@RequestMapping("/list-room")
	public String listRoom(Model model) throws JsonMappingException, JsonProcessingException {
		List<Room> rooms = roomService.getAllRoom();
		model.addAttribute("listRoom", rooms);
		return "Room/list-room";
	}

	

	@RequestMapping("/add-room")
	public String linkAddRoom() {
		return "Room/add-room";
	}

	@RequestMapping("/createRoom")
	public String addRoom(Room room) {
		// DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// room.setBirth_day(formatter.parse(room.getBirth_day()));
		// Room room = (Room) model.getAttribute("room");
//		System.out.println(room);
		room.setNumberpcurrent(0);
		roomService.insertRoom(room);
		return "redirect:/list-room";
	}

	@RequestMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable("id") Long id) {
		roomService.deleteRoom(id);
		return "redirect:/list-room";
	}

	@RequestMapping("/infoRoom/{id}")
	public String infoRoom(@PathVariable("id") Long id, Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		return "Room/info-room";
	}

	@RequestMapping("/pageUpdateRoom/{id}")
	public String pageUpdateRoom(@PathVariable("id") Long id, Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		return "Room/edit-room";
	}

	@RequestMapping("/updateRoom")
	public String updateRoom(Room room) {
		roomService.updateRoom(room);
		return "redirect:/list-room";
	}

	@RequestMapping("/info-room")
	public String infoRoom() {
		return "Room/info-room";
	}
}
