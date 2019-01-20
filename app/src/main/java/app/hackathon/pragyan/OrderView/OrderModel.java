package app.hackathon.pragyan.OrderView;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class OrderModel {
    Context context;
    Trigger trigger;
    OrderModel(Context context , Trigger trigger){
        this.context = context;
        this.trigger = trigger;
    }
    void sendPrefs(Integer i1 , Integer i2 , Integer i3 , Integer i4){
        SharedPreferences prefs = context.getSharedPreferences("hack" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("1",i1);
        editor.putInt("2",i2);
        editor.putInt("3",i3);
        editor.putInt("4",i4);
        editor.apply();

        Log.d("prefs",String.valueOf(prefs.getInt("1",0)));
        Log.d("prefs",String.valueOf(prefs.getInt("2",0)));
        Log.d("prefs",String.valueOf(prefs.getInt("3",0)));
        Log.d("prefs",String.valueOf(prefs.getInt("4",0)));

        trigger.orderReceived();
    }
    public interface Trigger{
        void orderReceived();
    }
}
