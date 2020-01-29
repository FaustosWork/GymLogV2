package edu.csumb.jofausto.gymlogv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import edu.csumb.jofausto.gymlogv2.DB.AppDatabase;
import edu.csumb.jofausto.gymlogv2.DB.GymLogDAO;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mainDisplay;
    EditText exercise;
    EditText weight;
    EditText reps;

    Button submit;

    GymLogDAO mGymLogDAO;

    List<GymLog> mGymLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainDisplay = findViewById(R.id.mainGymLogDisplay);
        exercise = findViewById(R.id.mainExerciseEditText);
        weight = findViewById(R.id.mainWeightEditText);
        reps = findViewById(R.id.mainRepsEditText);

        submit = findViewById(R.id.mainSubmitButton);

        mGymLogDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getGymLogDAO();

        refreshDisplay();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDatabase();
                refreshDisplay();

            }
        });
    }

    private void addToDatabase(){
        String exerciseString = exercise.getText().toString();
        int weightInt = Integer.parseInt(weight.getText().toString());
        int repsInt = Integer.parseInt(reps.getText().toString());

        mGymLogDAO.insert(new GymLog(exerciseString,weightInt,repsInt));
    }

    private void refreshDisplay(){
        mGymLogs = mGymLogDAO.getAllGymLogs();

        if(! mGymLogs.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();

            for(GymLog gymLog : mGymLogs){
                stringBuilder.append(gymLog.toString());
            }

            mainDisplay.setText(stringBuilder.toString());
        }else{
            mainDisplay.setText("GO TO THE GYM FOOL!");
        }
    }


}
