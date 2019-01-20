package app.hackathon.pragyan.Login;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;
import app.hackathon.pragyan.Register.RegisterView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        final LoginPresenter loginPresenter = new LoginPresenter(this);

        final EditText userIdEdit = findViewById(R.id.userIdEdit);
        final EditText passEdit = findViewById(R.id.passwordEdit);
        Button loginButton = findViewById(R.id.loginButton);
        Button regButton = findViewById(R.id.regButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.checkCredentials(userIdEdit.getText().toString() , passEdit.getText().toString());
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , RegisterView.class ));
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
