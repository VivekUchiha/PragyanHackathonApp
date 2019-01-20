package app.hackathon.pragyan.Slot;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.Payment.PaymentView;
import app.hackathon.pragyan.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SlotView extends AppCompatActivity implements SlotModel.Trigger {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_view);

        final SlotModel slotModel = new SlotModel(getApplicationContext() ,this);

        final RadioGroup RG = findViewById(R.id.rg);
        Button button = findViewById(R.id.slotButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String slot_id;
                    switch (RG.getCheckedRadioButtonId()) {
                        case R.id.radio1:
                            slot_id = "1";
                            break;
                        case R.id.radio2:
                            slot_id = "2";
                            break;
                        case R.id.radio3:
                            slot_id = "3";
                            break;
                        case R.id.radio4:
                            slot_id = "4";
                            break;
                        case R.id.radio5:
                            slot_id = "5";
                            break;
                            default: slot_id = "1";
                    }
                slotModel.savePref(slot_id);
            }
            });
        }

    @Override
    public void savedPrefs() {
        startActivity(new Intent(getApplicationContext() , PaymentView.class));
    }
}

