package app.hackathon.pragyan.PlaceOrder;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class PlaceOrderModel {
    String user_id , user_token , slot_id , pay_mode ;
    Context context;
    RequestQueue queue ;
    Trigger trigger;
    int count =0;
    PlaceOrderModel(Context context , Trigger trigger) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
        this.trigger = trigger;
    }

    void sendOrder(){
        SharedPreferences prefs = context.getSharedPreferences("hack", Context.MODE_PRIVATE);
        user_id = prefs.getString("userId","");
        user_token = prefs.getString("token","");
        slot_id = prefs.getString("slot_id" , "");
        pay_mode = prefs.getString("pay_mode" , "");
        String a[] = new String[4];
        a[0] = String.valueOf(prefs.getInt("1",0));
        a[1] = String.valueOf(prefs.getInt("2",0));
        a[2] = String.valueOf(prefs.getInt("3",0));
        a[3] = String.valueOf(prefs.getInt("4",0));

        for(int i0=1 ; i0 <= 4 ;i0++){
            Log.e("hit" , a[i0 - 1]);
            postReq(user_id , user_token , slot_id , pay_mode , String.valueOf(i0) , a[i0-1]);
        }

    }
    void postReq(final String user_id, final String user_token, final String slot_id, final String pay_mode, final String stock_id, final String a){
        StringRequest request = new StringRequest(Request.Method.POST,
                "http://192.168.43.199:3000/api/user/order",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Hit", "Order Placed");
                         count++;
                         if(count == 4)
                             trigger.orderPlaced();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> Params = new HashMap<>();
                Params.put("user_id",user_id);
                Params.put("user_token",user_token);
                Params.put("stock_id",stock_id);
                Params.put("slot_id",slot_id);
                Params.put("quantity",a);
                Params.put("payment_mode",pay_mode);
                return Params;

            }
        };
        queue.add(request);
    }
    public interface Trigger {
        void orderPlaced();
    }
}
