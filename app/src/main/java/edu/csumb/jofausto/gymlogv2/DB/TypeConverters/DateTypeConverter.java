package edu.csumb.jofausto.gymlogv2.DB.TypeConverters;

import java.util.Date;

import androidx.room.TypeConverter;

public class DateTypeConverter {
    @TypeConverter
    public long convertDatetoLong(Date date){
        return date.getTime();
    }
    @TypeConverter
    public Date convertLongtoDate(long time){
        return new Date(time);
    }
}
