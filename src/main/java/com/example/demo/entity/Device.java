package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Device")
public class Device {
	@Id
	@Indexed(unique = true)
	private Integer deviceId;
	private String deviceType;
	private String OS;
	private String osVersion;
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceType=" + deviceType + ", OS=" + OS + ", osVersion=" + osVersion
				+ "]";
	}
	
	
}
