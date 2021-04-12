package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DeviceDTO {
	@NotNull(message="device.Id.empty")
	@Pattern(regexp = "[0-9]+",message="device.Id.invalid")
	private Integer deviceId;
	@NotNull(message="device.deviceType.empty")
	@Pattern(regexp="(Laptop|Desktop|Tablet|Mobile)",message="device.deviceType.invalid")
	private String deviceType;
	@NotNull(message="device.Os.empty")
	@Pattern(regexp="(Linux|Mac|Windows)",message="device.Os.invalid")
	private String OS;
	@NotNull(message="device.osVersion.empty")
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
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	@Override
	public String toString() {
		return "DeviceDTO [deviceId=" + deviceId + ", deviceType=" + deviceType + ", OS=" + OS + ", osVersion="
				+ osVersion + "]";
	}
	
}
