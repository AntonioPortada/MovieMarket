package com.antonio.MovieMarket.persistence.mapper;

import org.mapstruct.Named;

public class StatusMapper {

    @Named("stringToBoolean")
    public static Boolean stringToBoolean(String estado) {
        if(estado == null) {
            return null;
        }

        return switch (estado) {
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }

    @Named("booleanToString")
    public static String booleanToString(boolean status) {
        return status ? "D" : "N";
    }
}
