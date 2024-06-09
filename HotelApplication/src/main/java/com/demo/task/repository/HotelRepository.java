package com.demo.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.task.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}