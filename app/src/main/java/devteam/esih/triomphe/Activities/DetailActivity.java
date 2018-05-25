package devteam.esih.triomphe.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import devteam.esih.triomphe.Models.Evenements;
import devteam.esih.triomphe.R;

public class DetailActivity extends AppCompatActivity {

    private TextView ev_title;
    private TextView ev_price;
    private TextView ev_room;
    private TextView ev_fullDetail;
    private TextView signet;
    private TextView inscription;
    ImageView ivBack;
    Evenements ev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        initViews();
        try{
            ev = (Evenements) getIntent().getSerializableExtra("event");
            ev_title.setText(ev.getEv_title());
            ev_price.setText(ev.getEv_price());
            ev_room.setText(ev.getEv_room());
            ev_fullDetail.setText(ev.getEv_fullDetail());
        }catch (Exception e){

        }

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


    public void initViews(){
        ev_title = (TextView) findViewById(R.id.ev_title);
        ev_price = (TextView) findViewById(R.id.ev_price);
        ev_room = (TextView) findViewById(R.id.ev_room);
        ev_fullDetail = (TextView) findViewById(R.id.ev_fullDetail);
        signet = (TextView) findViewById(R.id.signet);
        inscription = (TextView) findViewById(R.id.inscrire);
        ivBack = (ImageView) findViewById(R.id.ivBack);
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
