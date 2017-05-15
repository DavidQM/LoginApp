package com.example.viper2.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.login_button);

        callbackManager= CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
              //logeo exitoso
                goMainActivity2();
            }

            @Override
            public void onCancel() {
            //cuando se cancele
                Toast.makeText(getApplicationContext(),"Loggin Cancelado",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
            //cuando suceda un error
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode,data);

    }

    private void goMainActivity2(){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}