package com.sked.androidbasics;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.sked.androidbasics.adapter.MyAdapter;
import com.sked.androidbasics.model.Person;

import java.util.ArrayList;
import java.util.List;


public class Name extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        //String[] contacts= new String[]{"john","diva","sandy","oliver","felicity","sayra","tom"};

        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("9934921399", "John", 25);
        persons.add(person1);

        Person person2 = new Person("Diva");
        person2.setAge(16);
        person2.setNumber("9934287455");

        persons.add(person2);

        Person person3 = new Person();
        person3.setName("Michel");
        person3.setAge(16);
        person3.setNumber("9934287455");

        persons.add(person3);


        MyAdapter adapter = new MyAdapter(this, R.layout.list_item, persons);
        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_name, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
