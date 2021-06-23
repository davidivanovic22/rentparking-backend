package com.example.rentparking.util;


//import rs.ac.metropolitan.kanbanbackend.entity.UserCategory;

import com.example.rentparking.entity.data.dto.BookingDTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;

public class DateUtil {
    public static Date day(int day, int minus, int plus) {
        DayOfWeek dayOfWeek = DayOfWeek.of(day);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localeDate;
        if (minus > 0 && plus <= 0)
            localeDate = LocalDate.now().with(dayOfWeek).minusDays(minus);
        else if (plus > 0 && minus <= 0)
            localeDate = LocalDate.now().with(dayOfWeek).plusDays(plus);
        else
            localeDate = LocalDate.now().with(dayOfWeek);

        return Date.from(localeDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public static Date presentMonday() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localeDate = LocalDate.now().with(DayOfWeek.MONDAY);
        return Date.from(localeDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public static Date presentFriday() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localeDate = LocalDate.now().with(DayOfWeek.FRIDAY);
        return Date.from(localeDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public static boolean compareFromToDateTime(BookingDTO bookingDTO, LocalDateTime from, LocalDateTime to) {
        System.out.println(bookingDTO);
        System.out.println(from.isBefore(bookingDTO.getBooking().getFrom()));
//        System.out.println(from.equals(bookingDTO.getBooking().getFrom()));
        System.out.println(to.isAfter(bookingDTO.getBooking().getTo()));
//        System.out.println(to.equals(bookingDTO.getBooking().getTo()));
        return (from.isBefore(bookingDTO.getBooking().getFrom())
                || to.isAfter(bookingDTO.getBooking().getTo()));
    }
}
