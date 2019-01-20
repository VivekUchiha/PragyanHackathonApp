package app.hackathon.pragyan.Payment;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PaymentView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_view);

        final PaymentPresenter pres = new PaymentPresenter(this);

        RadioButton radioCop = findViewById(R.id.radiocop);
        RadioButton radioOnline = findViewById(R.id.radioonline);

        radioCop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pres.payMode(0);
            }
        });
    }
}
