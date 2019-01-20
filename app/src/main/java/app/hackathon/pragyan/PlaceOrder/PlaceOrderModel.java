package app.hackathon.pragyan.PlaceOrder;

import android.content.Context;
import android.content.SharedPreferences;

public class PlaceOrderModel {
    Context context;
    PlaceOrderModel(Context context) {
        this.context = context;

    }

    void sendOrder(){
        SharedPreferences prefs = context.getSharedPreferences("hack", Context.MODE_PRIVATE);
        String user_id = prefs.getString("user_id","");
        String user_token = prefs.getString("user_token","");
        String slot_id = prefs.getString("slot_id" , "");
        String pay_mode = prefs.getString("pay_mode" , "");
    }
    public interface Trigger {
        void orderPlaced();
    }
}
