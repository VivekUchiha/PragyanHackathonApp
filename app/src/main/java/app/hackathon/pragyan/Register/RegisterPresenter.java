package app.hackathon.pragyan.Register;

import android.content.Context;
import android.content.Intent;

import app.hackathon.pragyan.Login.LoginView;

public class RegisterPresenter implements RegisterModel.Trigger {
    Context context;
    RegisterModel registerModel;
    RegisterPresenter(Context context){
        this.context = context;
        registerModel = new RegisterModel(context , this);
    }

    void sendCreateReq(String userName, String email, String password, String uId, String shopId){
        registerModel.tryRegister(userName , email , password , uId , shopId);
    }

    @Override
    public void CreationSuccessful() {
        context.startActivity(new Intent(context , LoginView.class));
    }

    @Override
    public void ReportError(String string) {
        registerModel.toastPrinter(context , string , 2);
    }
}
