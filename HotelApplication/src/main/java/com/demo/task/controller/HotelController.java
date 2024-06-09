package com.demo.task.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.task.dto.HotelDTO;
import com.demo.task.entity.Hotel;
import com.demo.task.service.HotelService;


@RestController
@RequestMapping("/property-view")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping("/hotels")
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@GetMapping("hotels/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
		return hotelService.getHotelById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/search")
	public List<Hotel> searchHotels(@RequestParam(required = false) String name,
			@RequestParam(required = false) String brand, @RequestParam(required = false) String city,
			@RequestParam(required = false) String county, @RequestParam(required = false) String amenities) {
		return hotelService.searchHotels(name, brand, city, county, amenities);
	}

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> createHotel(@RequestBody HotelDTO hotelDTO) {
		Hotel createdHotel = hotelService.createHotel(hotelDTO);
		return ResponseEntity.ok(createdHotel);
	}

	@PostMapping("hotels/{id}/amenities")
	public ResponseEntity<Hotel> addAmenitiesToHotel(@PathVariable Long id, @RequestBody List<String> amenities) {
		return hotelService.addAmenitiesToHotel(id, amenities).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/histogram/{param}")
	public ResponseEntity<Map<String, Long>> getHistogram(@PathVariable String param) {
		try {
			Map<String, Long> histogram = hotelService.getHistogram(param);
			return ResponseEntity.ok(histogram);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
