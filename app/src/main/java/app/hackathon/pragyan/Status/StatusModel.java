package app.hackathon.pragyan.Status;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StatusModel {
    Context context;
    RequestQueue queue;
    Model model;

    StatusModel(Context context, Model model) {
        this.context = context;
        this.model = model;
        //loginPresenter = new LoginPresenter(context);
        queue = Volley.newRequestQueue(context);
    }

    void checkStatus(final String userId, final String userToken) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://192.168.43.199:3000/api/user/status",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (obj.getInt("status_code") == 200) {
                                if(obj.getJSONArray("message").length()==0) model.addCart();
                                else if(obj.getJSONArray("message").getJSONObject(0).getInt("Collected") == 0)   model.pending();
                                else model.getFeedBack(obj.getJSONArray("message"));
                            } else {
                                toastPrinter(context, obj.getJSONObject("message").getString("Message"), 2);
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
                params.put("user_token", userToken);
                return params;
            }
        };
        queue.add(stringRequest);
    }

    void toastPrinter(Context context, String string, int mode) {
        switch (mode) {
            case 0:
                DynamicToast.makeSuccess(context, string, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                DynamicToast.makeWarning(context, string, Toast.LENGTH_SHORT).show();
                break;
            default:
                DynamicToast.makeError(context, string, Toast.LENGTH_SHORT).show();
        }

    }

    public interface Model {
        void addCart();
        void getFeedBack(JSONArray array);
        void pending();
    }

}
