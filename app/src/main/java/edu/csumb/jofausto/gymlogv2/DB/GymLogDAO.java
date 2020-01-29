package edu.csumb.jofausto.gymlogv2.DB;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.csumb.jofausto.gymlogv2.GymLog;

@Dao
public interface GymLogDAO {
    @Insert
    void insert(GymLog...gymLogs);

    @Update
    void update(GymLog...gymLogs);

    @Delete
    void delete(GymLog...gymLogs);

    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " ORDER BY date DESC")
    List<GymLog> getAllGymLogs();

    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " WHERE logId = :logId")
    GymLog getGymLogById(int logId);

}
