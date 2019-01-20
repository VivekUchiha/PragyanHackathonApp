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

        final RadioGroup RG = findViewById(R.id.rg1);
        Button button = findViewById(R.id.slotButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String slot = String.valueOf(RG.getCheckedRadioButtonId());
                    String slot_id = String.valueOf(slot.charAt(4));
                    slotModel.savePref(slot_id);
            }
            });
        }

    @Override
    public void savedPrefs() {
        startActivity(new Intent(getApplicationContext() , PaymentView.class));
    }
}

