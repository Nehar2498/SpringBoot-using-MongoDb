package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Device;

public interface DeviceRepository extends MongoRepository<Device, Integer> {

}
