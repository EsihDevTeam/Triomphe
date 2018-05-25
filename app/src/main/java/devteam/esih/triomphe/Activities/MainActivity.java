package devteam.esih.triomphe.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import devteam.esih.triomphe.Adapters.EventsAdapter;
import devteam.esih.triomphe.Models.Evenements;
import devteam.esih.triomphe.R;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Evenements> events;

    private RecyclerView recyclerView;
    private EventsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        events = new ArrayList<>();
        mAdapter = new EventsAdapter(MainActivity.this,events);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    public void populateList(){



    }
}
