package com.sked.androidbasics;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sked.androidbasics.core.Circle;
import com.sked.androidbasics.core.Human;
import com.sked.androidbasics.core.Men;
import com.sked.androidbasics.core.Rectangle;
import com.sked.androidbasics.core.ShapeUtils;
import com.sked.androidbasics.core.Women;


public class JavaBasicsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_basics);

       //abstractClassTestOne();

       abstractClassTestTwo();
    }

    private void abstractClassTestTwo() {
        Human human= new Men();
        human.show();
        Human oneMoreHuman= new Women();
        oneMoreHuman.show();
    }

    private void abstractClassTestOne() {
        Rectangle rectangle = new Rectangle(20.4f, 32.8f);
        float rectProperty = ShapeUtils.shapeProperty(rectangle);

        System.out.println("rectProperty :" + rectProperty);

        Circle circle = new Circle(24f);
        float circleProperty = ShapeUtils.shapeProperty(circle);

        System.out.println("circleProperty" + circleProperty);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_java_basics, menu);
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
