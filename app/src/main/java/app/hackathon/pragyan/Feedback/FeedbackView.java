package app.hackathon.pragyan.Feedback;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;
import app.hackathon.pragyan.Status.StatusView;

import android.content.Intent;
import android.graphics.Color;
import android.media.Rating;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.lang.reflect.Array;
import java.util.List;

public class FeedbackView extends AppCompatActivity {

    private TextSwitcher textSwitcher;
    private Button nextButton;
    private int stringIndex = 0;
    private String[] row = {"1", "2", "3","4"};
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final Intent intent = new Intent(this, StatusView.class);

        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox checkBox3= (CheckBox) findViewById(R.id.checkBox3);

        textSwitcher = findViewById(R.id.textswit);
        nextButton = findViewById(R.id.button);
        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stars = ratingBar.getNumStars();

                int com[] = {0,0,0};

                if(checkBox1.isChecked()){
                    com[0]=1;
                }
                if(checkBox2.isChecked()){
                    com[1]=1;
                }

                if(checkBox3.isChecked()){
                    com[2]=1;
                }
                //todo api call to put stars and errors for item




                if (stringIndex == row.length - 1) {

                    startActivity(intent);

                } else {

                    textSwitcher.setText(row[++stringIndex]);
                }
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(FeedbackView.this);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(30);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }
        });

        textSwitcher.setText(row[stringIndex]);



    }
}
