package app.hackathon.pragyan;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.Login.LoginView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this , LoginView.class);
        startActivity(intent);
        }
}
