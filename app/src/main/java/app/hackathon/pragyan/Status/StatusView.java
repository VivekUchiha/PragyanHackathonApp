package app.hackathon.pragyan.Status;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.Feedback.FeedbackView;
import app.hackathon.pragyan.OrderView.OrderView;
import app.hackathon.pragyan.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class StatusView extends AppCompatActivity {

    final ListView listView = (ListView)findViewById(R.id.listvie);

    Intent intent = new Intent(this, OrderView.class);//todo change class name
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_view);

        Button orderbutton = (Button)findViewById(R.id.button2);


        orderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);

            }
        });
    }
}
