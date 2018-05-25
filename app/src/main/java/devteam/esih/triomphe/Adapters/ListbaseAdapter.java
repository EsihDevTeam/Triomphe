package devteam.esih.triomphe.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import devteam.esih.triomphe.Models.Evenements;
import devteam.esih.triomphe.R;

/**
 * Created by Rp on 3/16/2016.
 */
public class ListbaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<Evenements> beans;


    public ListbaseAdapter(Context context, ArrayList<Evenements> beans) {
        this.context = context;
        this.beans = beans;
    }

    @Override
    public int getCount() {
        return beans.size() ;
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null){

            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Regular.ttf");
            viewHolder = new ViewHolder();

            convertView = layoutInflater.inflate(R.layout.listview,null);


            viewHolder.image= (ImageView)convertView.findViewById(R.id.image);
            viewHolder.title= (TextView)convertView.findViewById(R.id.title);
            viewHolder.desc= (TextView)convertView.findViewById(R.id.desc);
            viewHolder.date= (TextView)convertView.findViewById(R.id.date);


            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();

        }


        Evenements beans = (Evenements)getItem(position);

        //viewHolder.image.setImageResource(beans.getEv_img());
        viewHolder.title.setText(beans.getEv_title());
        viewHolder.desc.setText(beans.getEv_detail());
        viewHolder.date.setText(beans.getEv_date());

        return convertView;
    }



    private class ViewHolder{
        ImageView image;
        TextView title;
        TextView desc;
        TextView date;

    }





}
