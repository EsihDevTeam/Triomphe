package devteam.esih.triomphe.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    SharedPreferences mUser;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mUser = getBaseContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        user = Backendless.UserService.CurrentUser();
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        events = new ArrayList<>();
        mAdapter = new EventsAdapter(MainActivity.this, events);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        populateList();
    }

    public void populateList(){
        if(DataQuery.getEvents()){
            events.addAll(DataQuery.events);
            mAdapter.notifyDataSetChanged();
        }
    }
}
