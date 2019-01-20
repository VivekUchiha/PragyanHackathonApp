package app.hackathon.pragyan.Payment;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PaymentModel {
    Trigger trigger;
    Context context;
    PaymentModel(Context context , Trigger trigger){
        this.context = context;
        this.trigger = trigger;
    }
    void savePayModePref(String i){
        SharedPreferences pref = context.getSharedPreferences("hack",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("payment_mode",i);
        Log.e("hit", i);
        editor.apply();

        trigger.prefSaved();
    }
    public interface Trigger{
        void prefSaved();
    }
}
