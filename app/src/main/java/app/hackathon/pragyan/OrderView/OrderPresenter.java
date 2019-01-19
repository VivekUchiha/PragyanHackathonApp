package app.hackathon.pragyan.OrderView;

import android.content.Context;
import android.content.Intent;

import app.hackathon.pragyan.Slot.SlotView;

public class OrderPresenter implements OrderModel.Trigger {
    Context context;
    OrderModel orderModel;
    OrderPresenter(Context context){
        this.context = context;
        orderModel = new OrderModel(context , this);
    }


    public void saveOrder(Integer i1 , Integer i2 , Integer i3 , Integer i4){
        orderModel.sendPrefs(i1, i2, i3, i4);
    }

    @Override
    public void orderReceived() {
        context.startActivity(new Intent(context , SlotView.class));
    }
}
