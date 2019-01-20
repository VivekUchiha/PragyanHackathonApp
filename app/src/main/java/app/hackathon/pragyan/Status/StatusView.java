package app.hackathon.pragyan.Status;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;

import android.content.SharedPreferences;
import android.os.Bundle;


public class StatusView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_view);

        final StatusPresenter statusPresenter = new StatusPresenter(this);

        SharedPreferences settings = getSharedPreferences("hack", MODE_PRIVATE);

        // Reading from SharedPreferences
        String userId = settings.getString("userId", "");
        String token = settings.getString("token", "");
        statusPresenter.checkData(userId, token);
    }
}
