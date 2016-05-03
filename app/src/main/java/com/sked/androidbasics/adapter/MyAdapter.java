package com.sked.androidbasics.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sked.androidbasics.model.Person;
import com.sked.androidbasics.R;

import java.util.List;

/**
 * Created by manish on 10/2/2015.
 */
public class MyAdapter extends ArrayAdapter<Person> {
    public MyAdapter(Context context, int resource, List<Person> objects) {
        super(context, 0, objects);
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = ((LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.list_item, null);
        TextView name = (TextView) convertView.findViewById(R.id.text1);
        TextView age = (TextView) convertView.findViewById(R.id.text2);
        TextView number= (TextView) convertView.findViewById(R.id.text3);

        Person person = getItem(position);
        name.setText(person.getName());
        age.setText(person.getAge()+"");
        number.setText(person.getNumber());
        return convertView;
    }
}
