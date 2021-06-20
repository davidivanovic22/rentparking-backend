package com.example.rentparking.entity;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "location")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Location extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "LOCATION_ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "LONGITUDE")
	private Double longitude;
	@Column(name = "LATITUDE")
	private Double latitude;
	
}