package app.hackathon.pragyan.Slot;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SlotModel {
    Context context;
    Trigger trigger;
    SlotModel(Context context , Trigger trigger){
        this.context = context;
        this.trigger = trigger;
    }

    public void savePref(String slot_id) {
        SharedPreferences prefs = context.getSharedPreferences("hack", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        Log.e("hit" , slot_id);
        edit.putString("slot_id", slot_id);
        edit.apply();
        trigger.savedPrefs();
    }

    public interface Trigger{
        void savedPrefs();
    }
}
