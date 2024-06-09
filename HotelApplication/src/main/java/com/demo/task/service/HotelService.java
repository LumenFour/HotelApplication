package com.demo.task.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.task.dto.HotelDTO;
import com.demo.task.entity.Hotel;
import com.demo.task.repository.HotelRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	public Optional<Hotel> getHotelById(Long id) {
		return hotelRepository.findById(id);
	}

	public List<Hotel> searchHotels(String name, String brand, String city, String county, String amenities) {
		return hotelRepository.findAll().stream()
				.filter(hotel -> StringUtils.isEmpty(name) || hotel.getName().equalsIgnoreCase(name))
				.filter(hotel -> StringUtils.isEmpty(brand) || hotel.getBrand().equalsIgnoreCase(brand))
				.filter(hotel -> StringUtils.isEmpty(city) || hotel.getAddress().getCity().equalsIgnoreCase(city))
				.filter(hotel -> StringUtils.isEmpty(county) || hotel.getAddress().getCounty().equalsIgnoreCase(county))
				.filter(hotel -> StringUtils.isEmpty(amenities) || hotel.getAmenities().contains(amenities))
				.collect(Collectors.toList());
	}

	public Hotel createHotel(HotelDTO hotelDTO) {
		Hotel hotel = new Hotel();
		hotel.setName(hotelDTO.getName());
		hotel.setDescription(hotelDTO.getDescription());
		hotel.setBrand(hotelDTO.getBrand());
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setContacts(hotelDTO.getContacts());
		hotel.setArrivalTime(hotelDTO.getArrivalTime());
		hotel.setAmenities(hotelDTO.getAmenities());

		return hotelRepository.save(hotel);
	}
}
