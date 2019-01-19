package app.hackathon.pragyan.OrderView;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderView extends AppCompatActivity {

    Integer i1=0,i2=0,i3=0,i4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        final TextView t1 = (TextView)findViewById(R.id.item1);
        final TextView t2 = (TextView)findViewById(R.id.item2);
        final TextView t3 = (TextView)findViewById(R.id.item3);
        final TextView t4 = (TextView)findViewById(R.id.item4);

        Button order = (Button)findViewById(R.id.order);

        Button bp1 = (Button)findViewById(R.id.item1plus);
        Button bp2 = (Button)findViewById(R.id.item2plus);
        Button bp3 = (Button)findViewById(R.id.item3plus);
        Button bp4 = (Button)findViewById(R.id.item4plus);
        Button bm1 = (Button)findViewById(R.id.item1minus);
        Button bm2 = (Button)findViewById(R.id.item2minus);
        Button bm3 = (Button)findViewById(R.id.item3minus);
        Button bm4 = (Button)findViewById(R.id.item4minus);
        bp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i1++;
                t1.setText(Integer.toString(i1));

            }
        });
        bp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i2++;
                t2.setText(Integer.toString(i2));

            }
        });
        bp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i3++;
                t3.setText(Integer.toString(i3));

            }
        });
        bp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i4++;
                t4.setText(Integer.toString(i4));

            }
        });
        bm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i1!=0)
                i1--;
                t1.setText(Integer.toString(i1));

            }
        });
        bm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i2!=0)
                i2--;
                t2.setText(Integer.toString(i2));

            }
        });
        bm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i3!=0)
                i3--;
                t3.setText(Integer.toString(i3));

            }
        });
        bm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i4!=0)
                i4--;
                t4.setText(Integer.toString(i4));

            }
        });


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo send order to server
            }
        });


    }



}
