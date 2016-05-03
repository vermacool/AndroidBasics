package com.sked.androidbasics;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class StringOperationsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_operations);
        TextView textView = (TextView) findViewById(R.id.textView);

        String sentence =" I am Manish Kumar. ";
        System.out.println("Actual Sentence : "+sentence );
        String trimmedSentence = sentence.trim();
        System.out.println("Trimmed Sentence : "+trimmedSentence);
        int numberOfCharacters = trimmedSentence.length();
        System.out.println("Number of Characters in Trimmed Sentence : "+numberOfCharacters);
        String reverseSentence = "";
       for(int i=numberOfCharacters;i>0;i--){
           char c = trimmedSentence.charAt(i-1);
           reverseSentence =reverseSentence+c;
           //reverseSentence =reverseSentence.concat(String.valueOf(c));

       }
        //System.out.println("character in opposit sequence"+reverseSentence);

        String [] words  = trimmedSentence.split(" ");
       /* for(String word:words){
            reverseSentence=word+reverseSentence;
        }*/
        reverseSentence ="";
        for (int i = words.length;i>0;i--) {
            reverseSentence =  reverseSentence+" "+words[i-1];
        }
        System.out.println("reverse word sequence is"+reverseSentence);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_string_operations, menu);
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
