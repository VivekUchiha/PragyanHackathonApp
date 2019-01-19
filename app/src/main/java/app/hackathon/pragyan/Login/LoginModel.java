package app.hackathon.pragyan.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginModel{
    Context context;
    RequestQueue queue;
    Model model;

    LoginModel(Context context , Model model) {
        this.context = context;
        this.model = model;
        //loginPresenter = new LoginPresenter(context);
        queue = Volley.newRequestQueue(context);
    }

    void tryLogin(final String userId, final String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://192.168.43.199:3000/api/user/login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            Log.e("test", "API = " + response);
                            if (obj.getInt("status_code") == 200) {
                                model.loginSuccess();
                                writePref(obj.getJSONObject("message").getString("userId"), obj.getJSONObject("message").getString("UserToken"));
                            } else {
                                toastPrinter(context, obj.getJSONObject("message").getString("Message") , 2);
                            }
                            } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                // the POST parameters:
                params.put("user_id", userId);
                params.put("password", password);

                return params;
            }
        };
        queue.add(stringRequest);

    }

    public void toastPrinter(Context context, String string, int mode) {
        switch(mode){
            case 0 : DynamicToast.makeSuccess(context, string, Toast.LENGTH_SHORT).show();
                        break;
            case 1 : DynamicToast.makeWarning(context , string , Toast.LENGTH_SHORT).show();
                        break;
            default : DynamicToast.makeError(context , string , Toast.LENGTH_SHORT).show();
        }

    }


    private void writePref(String userId, String token) {
        SharedPreferences preferences = context.getSharedPreferences("hack", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userId", userId);
        editor.putString("token", token);
        Log.d("LoginTest", "Adding " + userId + " " + token + " to shared prefs");
        editor.apply();
    }

    public interface Model{
        void loginSuccess();
    }
}
