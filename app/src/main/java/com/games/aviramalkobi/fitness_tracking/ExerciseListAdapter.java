package com.games.aviramalkobi.fitness_tracking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.ArrayList;

/**
 * Created by AviramAlkobi on 10/01/2016.
 */


public class ExerciseListAdapter extends BaseAdapter {

    // object like struct
    static class ViewHolder {
        CheckBox ExerciseName;
        Button Info;
        Boolean signFlag ;
    }

    private ArrayList<Exercise> arrayList;
    private LayoutInflater layoutInflater;

    public ExerciseListAdapter(Context aContext, ArrayList<Exercise> listData) {
        this.arrayList = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public ArrayList<Exercise> getArrayList(){
        return this.arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int location) {
        return arrayList.get(location);
    }

    @Override
    public long getItemId(int location) {
        return location;
    }


    // implement from BaseAdapter
    public View getView(int location, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row, null);
            holder = new ViewHolder();
            holder.ExerciseName = (CheckBox) convertView.findViewById(R.id.exerciseName);
            holder.Info = (Button) convertView.findViewById(R.id.InfoButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.ExerciseName.setText(arrayList.get(location).getName());
       /* holder.time.setText(arrayList.get(location).getTime());
        holder.temperature.setText(arrayList.get(location).getTemperature());
        holder.info.setText(arrayList.get(location).getInfo());
        //Loading image from below url into imageView

          Picasso.with(layoutInflater.getContext())
                  .load(arrayList.get(location).get_iconUrl())
                  .into(holder.image);*/

        return convertView;
    }

}
