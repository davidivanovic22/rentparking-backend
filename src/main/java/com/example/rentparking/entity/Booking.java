package com.example.rentparking.entity;

import com.example.rentparking.entity.data.domen.BookingStatus;

import java.time.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "booking")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Booking extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "BOOKING_ID")
	private Integer id;
	@JoinColumn(name = "PARKING_ID", referencedColumnName = "PARKING_ID")
	@ManyToOne
	private Parking parking;
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	@ManyToOne
	private User user;
	@Column(name = "FROM")
	private LocalDateTime from;
	@Column(name = "TO")
	private LocalDateTime to;
	@Column(name = "BOOKING_STATUS")
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;
	
}