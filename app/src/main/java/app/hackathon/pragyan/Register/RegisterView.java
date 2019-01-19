package app.hackathon.pragyan.Register;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterView extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText uid = findViewById(R.id.uid);
        EditText shopid = findViewById(R.id.shopid);

        Button register = findViewById(R.id.registerbutton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo register in server
                //todo check if uid unique and toast if not

            }
        });

    }
}
