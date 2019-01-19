package app.hackathon.pragyan.Slot;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SlotView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_view);

        final RadioGroup RG = findViewById(R.id.rg);

        Button button = findViewById(R.id.slotbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (RG.getCheckedRadioButtonId()){
                    case R.id.radio1:
                        break;
                        //todo send slot choice and go to payments
                    case R.id.radio2:
                        break;

                    case R.id.radio3:
                        break;

                    case R.id.radio4:
                        break;

                    case R.id.radio5:
                        break;
                }
            }
        });



    }
}
