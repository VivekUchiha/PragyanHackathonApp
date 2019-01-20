package app.hackathon.pragyan.PlaceOrder;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import app.hackathon.pragyan.R;

public class PlaceOrderView extends AppCompatActivity implements PlaceOrderModel.Trigger {
    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_view);

        status = findViewById(R.id.Status);

        PlaceOrderModel placeOrderModel = new PlaceOrderModel(getApplicationContext() , this);
        placeOrderModel.sendOrder();

    }

    @Override
    public void orderPlaced() {
        status.setText("OrderPlaced");
    }
}
