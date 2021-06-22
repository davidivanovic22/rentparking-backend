package com.example.rentparking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "parking")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Parking extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "PARKING_ID")
	private Integer id;
	@JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
	@ManyToOne
	private Location location;
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	@ManyToOne
	private User user;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PARKING_PIC")
	private String parkingPic;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "LENGTH")
	private Double length;
	@Column(name = "WIDTH")
	private Double width;
	@Column(name = "PRICE")
	private Double price;
	
}