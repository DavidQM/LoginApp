package com.example.viper2.loginapp;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    TextView tUsuario,tCorreo,tUid;
    Button bCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tUsuario = (TextView) findViewById(R.id.tUsuario);
        tCorreo = (TextView) findViewById(R.id.tCorreo);
        tUid = (TextView) findViewById(R.id.tUid);
        bCerrar = (Button) findViewById(R.id.bCerrar);

        /*
        //DAtos del perfl de facebook
        Bundle bundle= getIntent().getExtras();
        tUsuario.setText(bundle.getString("name"));
        tCorreo.setText(bundle.getString("ID"));
        */

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        tUsuario.setText(user.getDisplayName());
        tCorreo.setText(user.getEmail());
        tUid.setText(user.getUid());//nombre qye da firebse a la identificacion

        /*
        if (AccessToken.getCurrentAccessToken() == null){
            goMainActivity();
        }
        */
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();
        goMainActivity();
    }

    private void goMainActivity() {
        Intent intent = new Intent (Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
