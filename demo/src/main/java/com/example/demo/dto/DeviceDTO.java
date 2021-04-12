package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
@Data
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
}
