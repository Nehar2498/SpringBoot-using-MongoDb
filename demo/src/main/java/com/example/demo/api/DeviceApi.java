package com.example.demo.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DeviceDTO;
import com.example.demo.exception.InfyDeviceException;

import com.example.demo.service.DeviceService;


@RestController
public class DeviceApi {

	@Autowired
	DeviceService deviceService;
	@Autowired
	Environment env;
	@GetMapping("/devices")
	public ResponseEntity<List<DeviceDTO>> getAllDevices() throws InfyDeviceException{
		List<DeviceDTO> deviceList = deviceService.getAllDevices();
		return new ResponseEntity<>(deviceList, HttpStatus.OK);
	}
	@GetMapping("/devices/{deviceId}")
	public ResponseEntity<DeviceDTO> getDevice(@PathVariable Integer deviceId) throws InfyDeviceException{
		DeviceDTO device1 = deviceService.getDeviceById(deviceId);
		return new ResponseEntity<>(device1, HttpStatus.OK);
	}
	@PostMapping("/devices")
	public ResponseEntity<String> addDevice(@RequestBody DeviceDTO device) throws InfyDeviceException{
		Integer deviceID = deviceService.addDevice(device);
		String success = env.getProperty("API.Insert_Success")+deviceID;
		return new ResponseEntity<>(success, HttpStatus.CREATED);
	}
	@PutMapping("/devices/{deviceId}")
	public ResponseEntity<String> updateDevice(@PathVariable Integer deviceId, @RequestBody DeviceDTO device) throws InfyDeviceException{
		deviceService.updateDevice(deviceId, device.getOsVersion());
		String success = env.getProperty("API.Updated_Success");
		return new ResponseEntity<>(success, HttpStatus.OK);
}
	@DeleteMapping("/devices/{deviceId}")
	public ResponseEntity<String> deleteDevice(@PathVariable Integer deviceId) throws InfyDeviceException{
		deviceService.deleteDeviceById(deviceId);
		String success = env.getProperty("API.Delete_Success");
		return new ResponseEntity<>(success, HttpStatus.OK);
		
	}
	
}
