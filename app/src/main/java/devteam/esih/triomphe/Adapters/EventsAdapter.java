package devteam.esih.triomphe.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import devteam.esih.triomphe.Activities.DetailActivity;
import devteam.esih.triomphe.Activities.MainActivity;
import devteam.esih.triomphe.Models.Evenements;
import devteam.esih.triomphe.R;
import devteam.esih.triomphe.Utils.ImageUtils;

/**
 * Created by Rp on 6/14/2016.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
Context context;

    boolean showingFirst = true;

    private ArrayList<Evenements> evenements;


    ImageView NormalImageView;
    Bitmap ImageBit;
    float ImageRadius = 40.0f;




    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ev_image;
        TextView ev_title;
        TextView ev_detail;
        TextView ev_room;
        TextView ev_time;
        TextView ev_price;

        public MyViewHolder(View view) {
            super(view);
            ev_image = (ImageView) view.findViewById(R.id.ev_image);
            ev_title = (TextView) view.findViewById(R.id.ev_title);
            ev_detail = (TextView) view.findViewById(R.id.ev_detail);
            ev_time = (TextView) view.findViewById(R.id.ev_time);
            ev_price = (TextView) view.findViewById(R.id.ev_price);
            ev_room = (TextView) view.findViewById(R.id.ev_room);
        }

    }


    public EventsAdapter(Context m, List<Evenements> eList) {
        this.evenements = new ArrayList<>();
        this.evenements.addAll(eList);
        this.context = m;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_view, parent, false);

        return new MyViewHolder(itemView);

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Evenements ev = evenements.get(position);
        holder.ev_title.setText(ev.getEv_title());
        holder.ev_detail.setText(ev.getEv_title());
        //ImageUtils.displayImageFromUrl(context, ev.getEv_img(), holder.ev_image, null);
        holder.ev_detail.setText(ev.getEv_detail());
        holder.ev_room.setText(ev.getEv_room());
        holder.ev_price.setText(ev.getEv_price());
        holder.ev_time.setText(ev.getEv_date());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, DetailActivity.class);
                it.putExtra("event", ev);
                context.startActivity(it);
            }
        });


    }

    @Override
    public int getItemCount() {
        return evenements.size();
    }






}


