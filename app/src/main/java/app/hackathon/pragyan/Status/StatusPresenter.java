package app.hackathon.pragyan.Status;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;

import app.hackathon.pragyan.Feedback.FeedbackView;
import app.hackathon.pragyan.OrderView.OrderView;

import static android.content.Context.MODE_PRIVATE;

public class StatusPresenter implements StatusModel.Model {
    Context context;
    StatusModel statusModel;
    public static final String PREFS_NAME = "MyApp_Settings";

    StatusPresenter(Context context) {
        this.context = context;
        this.statusModel = new StatusModel(context, this);
    }

    public void checkData(String userId, String userToken) {
        if (userId.matches("") || userToken.matches("")) {
            Log.i("chekc", "checl");
            statusModel.toastPrinter(context, "UserId/Password cannot be blank", 1);
        } else {
            statusModel.checkStatus(userId, userToken);

        }
    }

    @Override
    public void addCart() {
        Log.i("Add to cart", "Add to cart da dei");
        context.startActivity(new Intent(context, OrderView.class));
    }

    @Override
    public void getFeedBack(JSONArray array) {
        Log.i("Give feedback", "Kudra punda");
        Intent i = new Intent(context, FeedbackView.class);
        i.putExtra("order_list", array.toString());
        context.startActivity(i);
    }

    @Override
    public void pending() {
        Log.i("Pending", "Still pendiiiiiiiiiiiiing");
    }
}
