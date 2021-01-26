package org.o7planning.fontend.service;

import java.util.List;

import org.o7planning.fontend.model.Room;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RoomService {
	public static final String REST_SERVICE_URI = "http://localhost:8081/room/";
	RestTemplate restTemplate = new RestTemplate();

	public List<Room> getAllRoom() throws JsonMappingException, JsonProcessingException {
		String rooms = restTemplate.getForObject(REST_SERVICE_URI, String.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(rooms, new TypeReference<List<Room>>() {
		});
	}

	public void insertRoom(Room room) {
		restTemplate.postForObject(REST_SERVICE_URI, room, Room.class);
	}

	public void updateRoom(Room room) {
		Long id = room.getId();
		restTemplate.put(REST_SERVICE_URI + id, room);
	}

	public void deleteRoom(Long id) {
		restTemplate.delete(REST_SERVICE_URI + id);
	}

	public Room getRoomById(Long id) {
		Room room = restTemplate.getForObject(REST_SERVICE_URI + id, Room.class);
		return room;
	}
}
