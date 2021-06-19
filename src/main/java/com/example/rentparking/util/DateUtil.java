package com.example.rentparking.util;


//import rs.ac.metropolitan.kanbanbackend.entity.UserCategory;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
        LocalDate localeDate =  LocalDate.now().with(DayOfWeek.MONDAY);
        return Date.from(localeDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public static Date presentFriday() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localeDate =  LocalDate.now().with(DayOfWeek.FRIDAY);
        return Date.from(localeDate.atStartOfDay(defaultZoneId).toInstant());
    }

//    public static Comparator<UserCategory> compareUserCategoryDate() {
//        return (o1, o2) -> {
//            if (o1.getStartDate().before(o2.getStartDate())) {
//                return -1;
//            } else if (o1.getStartDate().after(o2.getStartDate())) {
//                return 1;
//            } else {
//                return 0;
//            }
//        };
//    }
}
