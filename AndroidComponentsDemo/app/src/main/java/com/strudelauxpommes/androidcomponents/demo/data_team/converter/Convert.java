package com.strudelauxpommes.androidcomponents.demo.data_team.converter;

import android.arch.persistence.room.TypeConverter;

import com.strudelauxpommes.androidcomponents.demo.view_team.FormViewModel;

import java.util.Date;

/**
 * An example of a converter for storing complex objects in simple database format.
 *
 * Created by Marc-Antoine Sauvé on 11/11/17.
 */

public class Convert {
    @TypeConverter
    public FormViewModel.BackgroundColor toEnum(String value) {
        return FormViewModel.BackgroundColor.valueOf(value);
    }

    @TypeConverter
    public String fromEnum(FormViewModel.BackgroundColor value) {
        return value.name();
    }

    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }
}
