package app.hackathon.pragyan.Login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import app.hackathon.pragyan.Status.StatusView;

public class LoginPresenter implements LoginModel.Model {
    Context context;
    LoginModel loginModel;

    LoginPresenter(Context context) {
        this.context = context;
        this.loginModel = new LoginModel(context , this);
    }

    public void checkCredentials(String userId, String password) {
        if (userId.matches("") || password.matches("")) {
            loginModel.toastPrinter(context, "UserId/Password cannot be blank" ,1);
        } else {
            loginModel.tryLogin(userId, password);

        }
    }

    @Override
    public void loginSuccess() {
        Log.e("Hit","hit");
        loginModel.toastPrinter(context, "Login Successful" ,0);
        context.startActivity(new Intent(context , StatusView.class));
    }


}
