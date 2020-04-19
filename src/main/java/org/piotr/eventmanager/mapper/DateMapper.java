package org.piotr.eventmanager.mapper;

import java.time.LocalDateTime;

public class DateMapper {

        public static LocalDateTime mapToDateTime(int year, int month, int dayOfMonth, int hour, int minute){
            return LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        }
}
