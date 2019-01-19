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

        final RegisterPresenter presenter = new RegisterPresenter(this);

        final EditText username = findViewById(R.id.username);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        final EditText uid = findViewById(R.id.uid);
        final EditText shopid = findViewById(R.id.shopid);

        Button register = findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sendCreateReq(username.getText().toString() , email.getText().toString() , password.getText().toString() , uid.getText().toString() , shopid.getText().toString());
            }
        });

    }
}
