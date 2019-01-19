package app.hackathon.pragyan.Register;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

public class RegisterModel {
    Context context;
    Trigger trigger;
    RequestQueue queue;

    RegisterModel(Context context , Trigger trigger){
        this.context = context;
        this.trigger = trigger;
        queue = Volley.newRequestQueue(context);
    }

    public void tryRegister(final String userName, final String email, final String password, final String uId, final String shopId,final String num) {
        StringRequest request = new StringRequest(Request.Method.POST,
                "http://192.168.43.199:3000/api/user/register",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("api","API = "+ response);
                        try {
                            JSONObject object = new JSONObject(response);
                            if(object.getInt("status_code")==200){
                                trigger.CreationSuccessful();
                            }
                            else
                                trigger.ReportError(object.getString("message"));
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                trigger.ReportError(new String(error.networkResponse.data));
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_name",userName);
                params.put("email",email);
                params.put("password",password);
                params.put("user_id",uId);
                params.put("shop_id",shopId);
                params.put("contact_number",num);
                return params;
            }
        };
        queue.add(request);
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

    public interface Trigger{
        void CreationSuccessful();
        void ReportError(String string);
    }
}

