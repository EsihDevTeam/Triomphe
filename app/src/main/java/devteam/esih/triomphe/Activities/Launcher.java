package devteam.esih.triomphe.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.backendless.Backendless;

import devteam.esih.triomphe.R;
import devteam.esih.triomphe.Utils.Defaults;

public class Launcher extends AppCompatActivity {


    int time = 4000;
    public String userToken;
    public Intent start;
    public boolean valid;
    SharedPreferences mUser;
    SharedPreferences.Editor editor;
    String mail;
    String password;
    SharedPreferences registered;
    boolean register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                start = new Intent(Launcher.this, SignIn.class);
                startActivity(start);
                //overridePendingTransition(R.anim.right, R.anim.left);
                finish();
            }
        }, time);
    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
