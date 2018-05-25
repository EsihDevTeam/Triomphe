package devteam.esih.triomphe.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;

import devteam.esih.triomphe.R;
import devteam.esih.triomphe.Utils.DataQuery;
import devteam.esih.triomphe.Utils.Defaults;

public class SignIn extends AppCompatActivity {

    SharedPreferences mUser;
    SharedPreferences.Editor editor;

    private TextView signup;
    private TextView signin;
    private TextView account;
    private TextView fb;
    private EditText email;
    private EditText password;
    private ProgressBar progressBar;
    private String pass;
    private String mail;
    private TextView connect;
    Intent it;
    DataQueryBuilder c_query;
    String query;
    ArrayList<BackendlessUser> backendUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );

        initViews();
        mUser = getBaseContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        backendUsers = new ArrayList<>();


        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Backendless.UserService.login(email.getText().toString(), password.getText().toString(), new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(SignIn.this, R.string.connection_succes, Toast.LENGTH_SHORT).show();
                        Log.d("DEBUG", response.toString());
                        it = new Intent(SignIn.this, MainActivity.class);
                        it.putExtra("userInfo", response);
                        if(DataQuery.getEvents()){
                            //Toast.makeText(SignIn.this, "Data", Toast.LENGTH_SHORT).show();
                        }else{
                            //Toast.makeText(SignIn.this, "No data", Toast.LENGTH_SHORT).show();
                        }
                        startActivity(it);
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        int debug = Log.d("DEBUG", fault.toString());
                        it = new Intent(SignIn.this, SignIn.class);
                    }
                }, true);
                progressBar.setVisibility(View.GONE);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it = new Intent(SignIn.this, SignUp.class);
                startActivity(it);
            }
        });
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 2;
    }


    public void signin() {
        if (mail != "" && pass != "") {
            Backendless.UserService.login(mail, pass, new AsyncCallback<BackendlessUser>() {
                @Override
                public void handleResponse(BackendlessUser response) {
                    //Toast.makeText(Splash.this, "Log in succesfull", Toast.LENGTH_SHORT).show();
                    Log.d("DEBUG", response.toString());
                    //it = new Intent(Splash.this, MainActivity.class);
                    //it.putExtra("userInfo", response);
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    int debug = Log.d("DEBUG", fault.toString());
                    it = new Intent(SignIn.this, SignIn.class);
                }
            }, true);
        }
    }

    public  void logIn(final String email, final String password){
        Backendless.UserService.login(email, password, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Toast.makeText(SignIn.this, "Log in succesfull", Toast.LENGTH_SHORT).show();
                Log.d("DEBUG", response.toString());
                editor = mUser.edit();
                editor.putString("Email", email);
                editor.putString("Pass", password);
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("userInfo", response);
                startActivity(i);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.toString());
                if(Integer.parseInt(fault.getCode()) == 3003){
                    //password.setError(getString(R.string.id_error));
                }else if(Integer.parseInt(fault.getCode()) == 3000){
                    //password.setError(getString(R.string.disable_account));

                }else{
                    //mPasswordView.setError(getString(R.string.login_error));
                }

            }
        }, true);


    }


    public void initViews(){
        signup = (TextView)findViewById(R.id.signup);
        signin = (TextView)findViewById(R.id.signin);
        connect = (TextView) findViewById(R.id.buttonsignin);
        fb = (TextView)findViewById(R.id.fb);
        account = (TextView)findViewById(R.id.account);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
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
