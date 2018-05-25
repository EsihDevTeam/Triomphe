package devteam.esih.triomphe.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.ArrayList;

import devteam.esih.triomphe.Adapters.ListbaseAdapter;
import devteam.esih.triomphe.Models.Evenements;
import devteam.esih.triomphe.R;
import devteam.esih.triomphe.Utils.DataQuery;

public class ProfilActivity extends AppCompatActivity {


    private ArrayList<Evenements> beans;
    private ListbaseAdapter listbaseAdapter;
    private ListView listView;
    private Toolbar toolbar;
    private ImageView ivBack;
    private TextView logout;
    BackendlessUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        user = Backendless.UserService.CurrentUser();
        listView = (ListView)findViewById(R.id.listview);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        logout = (TextView) findViewById(R.id.logout);
        beans = new ArrayList<>();
        listbaseAdapter = new ListbaseAdapter(ProfilActivity.this, DataQuery.events);
        listView.setAdapter(listbaseAdapter);
        listbaseAdapter.notifyDataSetChanged();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ProfilActivity.this, SignIn.class);
                startActivity(it);
            }
        });
    }


    @Override
    public void onBackPressed() {
       super.onBackPressed();
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
