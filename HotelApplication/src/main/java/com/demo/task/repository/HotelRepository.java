package com.demo.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.task.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	@Query("SELECT h.brand, COUNT(h) FROM Hotel h GROUP BY h.brand")
	List<Object[]> countHotelsByBrand();

	@Query("SELECT h.address.city, COUNT(h) FROM Hotel h GROUP BY h.address.city")
	List<Object[]> countHotelsByCity();

	@Query("SELECT h.address.county, COUNT(h) FROM Hotel h GROUP BY h.address.county")
	List<Object[]> countHotelsByCounty();

	@Query("SELECT a, COUNT(h) FROM Hotel h JOIN h.amenities a GROUP BY a")
	List<Object[]> countHotelsByAmenities();

}