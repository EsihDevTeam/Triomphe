package devteam.esih.triomphe.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import devteam.esih.triomphe.R;

public class SignIn extends AppCompatActivity {



    private TextView signup;
    private TextView signin;
    private TextView account;
    private TextView fb;
    private EditText email;
    private EditText password;
    private String pass;
    private String mail;
    Intent it;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        initViews();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it = new Intent(SignIn.this, SignUp.class);
                startActivity(it);
            }
        });
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


    public void initViews(){
        signup = (TextView)findViewById(R.id.signup);
        signin = (TextView)findViewById(R.id.signin);
        fb = (TextView)findViewById(R.id.fb);
        account = (TextView)findViewById(R.id.account);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
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
