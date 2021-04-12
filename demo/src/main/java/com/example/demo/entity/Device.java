package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Document(collection = "Device")
public class Device {
	@Id
	@Indexed(unique = true)
	private Integer deviceId;
	private String deviceType;
	private String OS;
	private String osVersion;
	
	
}
