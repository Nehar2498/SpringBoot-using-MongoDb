package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.DeviceDTO;
import com.example.demo.exception.InfyDeviceException;
import com.example.demo.entity.Device;
import com.example.demo.repository.DeviceRepository;

@Service(value = "deviceService")
@Transactional
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceRepository deviceRepository;
	@Override
	public List<DeviceDTO> getAllDevices() throws InfyDeviceException
	{
		Iterable<Device> deviceList = deviceRepository.findAll();
		List<DeviceDTO> devices = new ArrayList<>();
		deviceList.forEach(device ->{
			DeviceDTO dev = new DeviceDTO();
			dev.setDeviceId(device.getDeviceId());
			dev.setOS(device.getOS());
			dev.setDeviceType(device.getDeviceType());
			dev.setOsVersion(device.getOsVersion());
			devices.add(dev);
		});
		if(devices.isEmpty())
			throw new InfyDeviceException("Service.Devices_Not_Found");
		
		return devices;
	}
	@Override
	public DeviceDTO getDeviceById(Integer deviceId) throws InfyDeviceException
	{
		Optional<Device> opt = deviceRepository.findById(deviceId);
		Device devices = opt.orElseThrow(()-> new InfyDeviceException("Service.Device_Not_Found"));
		DeviceDTO device = new DeviceDTO();
		device.setDeviceId(devices.getDeviceId());
		device.setOS(devices.getOS());
		device.setDeviceType(devices.getDeviceType());
		device.setOsVersion(devices.getOsVersion());
		return device;
		
	}
	@Override
	public Integer addDevice(DeviceDTO device) throws InfyDeviceException{
		
		Device deviceToAdd = new Device();
		deviceToAdd.setDeviceId(device.getDeviceId());
		deviceToAdd.setOS(device.getOS());
		deviceToAdd.setDeviceType(device.getDeviceType());
		deviceToAdd.setOsVersion(device.getOsVersion());
		Device addedDevice = deviceRepository.save(deviceToAdd);
		return addedDevice.getDeviceId();
		
	}
	@Override
	public void updateDevice(Integer deviceId, String osVersion) throws InfyDeviceException {
		// TODO Auto-generated method stub
		Optional <Device> opt = deviceRepository.findById(deviceId);
		Device device = opt.orElseThrow(()->new InfyDeviceException("Service.Device_Not_Found"));
		device.setOsVersion(osVersion);
		deviceRepository.save(device);
	}
	@Override
	public void deleteDeviceById(Integer deviceId) throws InfyDeviceException
	{
		Optional<Device> optional = deviceRepository.findById(deviceId);
		Device device = optional.orElseThrow(()-> new InfyDeviceException("Service.No_Device_Found"));
		if(device.getDeviceType().equals("Server"))
			throw new InfyDeviceException("Service.Cannot_delete_Server");
		deviceRepository.deleteById(device.getDeviceId());
		
	}
	
}
