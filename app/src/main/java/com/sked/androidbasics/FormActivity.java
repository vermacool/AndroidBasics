package com.sked.androidbasics;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.sked.androidbasics.database.DataBase;
import com.sked.androidbasics.database.Table;

import java.io.File;
import java.util.UUID;


public class FormActivity extends Activity implements View.OnClickListener {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1234;
    EditText name;
    EditText mobile;
    EditText email;
    EditText address;

    ImageView img;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        name = (EditText) findViewById(R.id.name);

        mobile = (EditText) findViewById(R.id.mobileNo);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        Button preview = (Button) findViewById(R.id.preview);


        preview.setOnClickListener(this);

        img = (ImageView) findViewById(R.id.photo);
        img.setOnClickListener(this);
        //setImage(img);

    }

    private void insertData() {
        DataBase db = new DataBase(this);
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        //  sqLiteDatabase.execSQL("insert into user(user_name,email,address,mobile) values ('Manish','manish@gmail.com','Siwan','9934921399')");
        ContentValues contentValues = new ContentValues();
        /*contentValues.put(Table.User.USER_NAME, "Mishra");
        contentValues.put(Table.User.EMAIL, "Mishra@gmail.com");
        contentValues.put(Table.User.ADDRESS, "Gopalganj");
        contentValues.put(Table.User.MOBILE, "9643692279");*/

        contentValues.put(Table.User.USER_NAME, name.getText().toString());
        contentValues.put(Table.User.EMAIL, email.getText().toString());
        contentValues.put(Table.User.ADDRESS, address.getText().toString());
        contentValues.put(Table.User.MOBILE, mobile.getText().toString());

        sqLiteDatabase.insert(Table.User.TABLE_NAME, null, contentValues);
    }
    private void updateData() {
        DataBase db = new DataBase(this);
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        //sqLiteDatabase.execSQL("update user set user_name = 'Manish' where _id = 1");
        sqLiteDatabase.update(Table.User.TABLE_NAME, contentValues, Table.User._ID + " = ?", new String[]{"1"});
    }
 private void delete() {
     DataBase db = new DataBase(this);
     SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
     //sqLiteDatabase.execSQL("delete from user where _id = 1");
     sqLiteDatabase.delete(Table.User.TABLE_NAME, Table.User._ID + " = ?", new String[]{"1"});
 }
        //Cursor cursor = sqLiteDatabase.rawQuery("select * from user", null);
    private void select(){
        DataBase db = new DataBase(this);
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Table.User.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int indexOfName = cursor.getColumnIndex(Table.User.USER_NAME);
            String name = cursor.getString(indexOfName);

            int indexOfEmail = cursor.getColumnIndex(Table.User.TABLE_NAME);
            String email = cursor.getString(indexOfEmail);

        }


    }

    //Setting image bitmap from the external storage
    private void setImage(String imageName) {
        String path = Environment.getExternalStorageDirectory() + "/" + imageName;
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        if (bitmap != null) {
            img.setImageBitmap(bitmap);
        }
    }



    private void startCamera() {

        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Uri fileUri = getOutputMediaFileUri(); // create a file to save the image

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

        // start the image capture Intent
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    private Uri getOutputMediaFileUri() {
        //Creating a random name for the image file
        imageName = UUID.randomUUID() + ".jpeg";
        File imageFile = new File(Environment.getExternalStorageDirectory() + "/" + imageName);//Creating the file insatance
        Uri fileUri = Uri.fromFile(imageFile);//Creating Uri instance from file
        return fileUri;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            insertData();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            setImage(imageName);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.preview:
                /*    Context context = getApplicationContext();
                    CharSequence text = "Name :" + name.getText() + "\n" +
                            "Mobile :" + mobile.getText() + "\n" +
                            "EMAIL :" + email.getText() + "\n" +
                            "Address :" + address.getText();
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    */
                Intent i = new Intent(getBaseContext(), Form2.class);
                i.putExtra("name", name.getText());
                i.putExtra("mobile", mobile.getText());
                i.putExtra("email", email.getText());
                i.putExtra("address", address.getText());
                i.putExtra("imageName", imageName);
                startActivity(i);
                break;


            case R.id.photo:
                startCamera();
                // Intent intent = new Intent(getBaseContext())


        }
    }
}
