package edu.csumb.jofausto.gymlogv2;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import edu.csumb.jofausto.gymlogv2.DB.AppDatabase;

@Entity(tableName = AppDatabase.GYMLOG_TABLE)
public class GymLog {

    @PrimaryKey(autoGenerate = true)
    private int logId;

    private String exercise;

    private int weight;
    private int reps;

    private Date date;

    public GymLog(String exercise, int weight, int reps) {
        this.exercise = exercise;
        this.weight = weight;
        this.reps = reps;
        date = new Date();
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date mDate) {
        this.date = date;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @Override
    public String toString() {
        return "GymLog{" +
                "log id = " + logId +
                ", exercise='" + exercise + '\'' +
                ", weight=" + weight +
                ", reps=" + reps +
                ", Date=" + date +
                '}';
    }
}
