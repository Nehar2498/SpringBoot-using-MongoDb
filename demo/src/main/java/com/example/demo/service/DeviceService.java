package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DeviceDTO;
import com.example.demo.exception.InfyDeviceException;


public interface DeviceService {

	public List<DeviceDTO> getAllDevices() throws InfyDeviceException;
	public DeviceDTO getDeviceById(Integer deviceId)  throws InfyDeviceException;
	public void deleteDeviceById(Integer deviceId)  throws InfyDeviceException;
	public Integer addDevice(DeviceDTO device)  throws InfyDeviceException;
	public void updateDevice(Integer deviceId, String osVersion) throws InfyDeviceException;
}
