package app.hackathon.pragyan.Payment;

import android.content.Context;
import android.content.SharedPreferences;

public class PaymentModel {
    Context context;
    PaymentModel(Context context){
        this.context = context;
    }
    void savePayModePref(int i){
        SharedPreferences pref = context.getSharedPreferences("hack",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("payment_mode",String.valueOf(i));
        editor.apply();
    }
    public interface Trigger{
        void prefSaved();
    }
}
