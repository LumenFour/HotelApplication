package com.demo.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.task.entity.Hotel;
import com.demo.task.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
		return hotelService.getHotelById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/search")
	public List<Hotel> searchHotels(@RequestParam(required = false) String name,
			@RequestParam(required = false) String brand, @RequestParam(required = false) String city,
			@RequestParam(required = false) String county, @RequestParam(required = false) String amenities) {
		return hotelService.searchHotels(name, brand, city, county, amenities);
	}
}