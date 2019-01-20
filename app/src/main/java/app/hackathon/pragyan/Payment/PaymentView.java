package app.hackathon.pragyan.Payment;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PaymentView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_view);

        final PaymentPresenter pres = new PaymentPresenter(this);
        Button confirm = findViewById(R.id.confirmPayMode);
        final RadioGroup radioGroup = findViewById(R.id.rg1);

        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String pay;
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.payRadio1 : pay = "1";
                    break;
                    default: pay = "2";
                }
                Log.e("hit" , pay);
                pres.payMode(pay);
            }
        });
    }
}
