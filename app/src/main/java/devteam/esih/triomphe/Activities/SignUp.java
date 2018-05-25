package devteam.esih.triomphe.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.io.IOException;

import devteam.esih.triomphe.R;
import devteam.esih.triomphe.Utils.DataQuery;
import devteam.esih.triomphe.Utils.Defaults;

public class SignUp extends AppCompatActivity {



    private TextView signup;
    private TextView signin;
    private TextView fb;
    private TextView account;
    private EditText email;
    private EditText password;
    private EditText password2;
    private EditText user;
    private EditText tel;
    private EditText l_name;
    private EditText f_name;
    public static boolean r;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );
        initViews();
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.getText().toString().equals(password2.getText().toString())){//Passwords match
                    if(!TextUtils.isEmpty(l_name.getText().toString()) && !TextUtils.isEmpty(f_name.getText().toString()) ){
                        if(!TextUtils.isEmpty(email.getText().toString()) && email.getText().toString().contains("@")){
                                    progressBar.setVisibility(View.VISIBLE);
                                    if(registerUser(f_name.getText().toString(),
                                            l_name.getText().toString(), email.getText().toString(),
                                            password.getText().toString(),
                                            tel.getText().toString(), user.getText().toString())){
                                        Intent it = new Intent(SignUp.this, SignIn.class);
                                        startActivity(it);
                                    }
                                    progressBar.setVisibility(View.GONE);
                        }else {
                            Toast.makeText(SignUp.this, R.string.email_request, Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUp.this, R.string.name_requis, Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(SignUp.this, R.string.pass_same, Toast.LENGTH_SHORT).show();
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(SignUp.this, SignIn.class);
                startActivity(it);
            }
        });
    }

    public void initViews(){
        signup = (TextView)findViewById(R.id.signup);
        signin = (TextView)findViewById(R.id.signin);
        fb = (TextView)findViewById(R.id.fb);
        account = (TextView)findViewById(R.id.account);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        password2 = (EditText)findViewById(R.id.password2);
        user = (EditText)findViewById(R.id.user);
        l_name = (EditText)findViewById(R.id.l_name);
        f_name = (EditText)findViewById(R.id.f_name);
        tel = (EditText)findViewById(R.id.tel);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }


    public boolean registerUser(String f_name, String l_name, String email, String password, String tel, String username){

        BackendlessUser user = new BackendlessUser();
        user.setEmail(email);
        user.setPassword(password);
        user.setProperty("f_name", f_name);
        user.setProperty("l_name", l_name);
        user.setProperty("phone", tel);
        user.setProperty("username", username);

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Log.d("DEBUG", response.toString());
                Toast.makeText(SignUp.this, R.string.registration, Toast.LENGTH_SHORT).show();
                r = true;
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(SignUp.this, "Erreur", Toast.LENGTH_SHORT).show();
                Log.d("DEBUG", fault.getMessage().toString());
                r = false;
            }
        });

        return r;
    }

    public Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }
        return false;
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
