package com.brandonn.springboottemplate2.shared.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateUtils {
    public static LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("d/M/u"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/uuuu"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/uuuu"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("d-M-u"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-uuuu"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-uuuu"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .toFormatter();
        return LocalDate.parse(dateStr, formatter);
    }
}
