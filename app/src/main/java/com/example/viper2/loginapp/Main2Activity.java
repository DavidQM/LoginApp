package com.example.viper2.loginapp;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    TextView tUsuario,tCorreo;
    Button bCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tUsuario = (TextView) findViewById(R.id.tUsuario);
        tCorreo = (TextView) findViewById(R.id.tCorreo);
        bCerrar = (Button) findViewById(R.id.bCerrar);

        Bundle bundle= getIntent().getExtras();

        tUsuario.setText(bundle.getString("name"));
        tCorreo.setText(bundle.getString("ID"));
        /*
        if (AccessToken.getCurrentAccessToken() == null){
            goMainActivity();
        }
        */
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goMainActivity();
    }

    private void goMainActivity() {
        Intent intent = new Intent (Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
