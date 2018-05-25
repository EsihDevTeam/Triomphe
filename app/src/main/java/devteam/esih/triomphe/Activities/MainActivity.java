package devteam.esih.triomphe.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.ArrayList;

import devteam.esih.triomphe.Adapters.EventsAdapter;
import devteam.esih.triomphe.Models.Evenements;
import devteam.esih.triomphe.R;
import devteam.esih.triomphe.Utils.DataQuery;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Evenements> events;

    private RecyclerView recyclerView;
    private EventsAdapter mAdapter;
    BackendlessUser user;
    Toolbar toolbar;
    ImageView ivProfil;
    SharedPreferences mUser;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mUser = getBaseContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        user = Backendless.UserService.CurrentUser();
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        ivProfil = (ImageView) findViewById(R.id.ivProfil);
        events = new ArrayList<>();
        mAdapter = new EventsAdapter(MainActivity.this, DataQuery.events);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        ivProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(it);
            }
        });





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                populateList();
            }
        }, 1000);
    }

    public void populateList(){
        if(DataQuery.getEvents()){

        }
        events.addAll(DataQuery.events);
        mAdapter.notifyDataSetChanged();

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
