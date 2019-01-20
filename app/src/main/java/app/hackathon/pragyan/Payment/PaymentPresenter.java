package app.hackathon.pragyan.Payment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Objects;

import app.hackathon.pragyan.PlaceOrder.PlaceOrderView;

public class PaymentPresenter implements PaymentModel.Trigger {
    Context context;
    PaymentModel paymentModel;
    PaymentPresenter(Context context){
        this.context = context;
        paymentModel = new PaymentModel(context , this);
    }
    public void payMode(String i){
        paymentModel.savePayModePref(i);
    }

    @Override
    public void prefSaved() {
        SharedPreferences pref = context.getSharedPreferences("hack", Context.MODE_PRIVATE);
        Log.e("hit", pref.getString("payment_mode" , "2"));
        if(Objects.requireNonNull(pref.getString("payment_mode", "2")).matches("2")){
            context.startActivity(new Intent(context , PlaceOrderView.class));
        }
        else{
            //Google Pay API
        }
    }
}
