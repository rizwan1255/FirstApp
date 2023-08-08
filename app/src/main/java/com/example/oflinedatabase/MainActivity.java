package com.example.oflinedatabase;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    EditText password, name;
    Button button;
    MyDatabase database;
    UserDataAdapter adapter;
    ArrayList<UserModel> mylist=new ArrayList<>();
   // UserDataAdapter userDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        list=findViewById(R.id.list);
        database = new MyDatabase(MainActivity.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = name.getText().toString();
                String b = password.getText().toString();

                database.saveData(database, a, b);
                getDataFromDB();
            }

        });
    }
    private void getDataFromDB() {
        mylist.clear();
        MyDatabase DB = new MyDatabase(MainActivity.this);
        Cursor cr = DB.getData(DB);
        while (cr.moveToNext()) {

            UserModel userInfo = new UserModel();


            @SuppressLint("Range") String userName = cr.getString(cr.getColumnIndex(MyDatabase.USERNAME));
            @SuppressLint("Range") String password = cr.getString(cr.getColumnIndex(MyDatabase.PASSWORD));
//            String id = "" + cr.getInt(cr.getColumnIndex(MyDatabase.ID));

            userInfo.setName(userName);
            userInfo.setPassword(password);
           // userInfo.setId(id);


           // Log.e("Username is: ", "" + userName + " ID is==>" + id);

            mylist.add(userInfo);

        }

        if (mylist.size() == 0) {
            Toast.makeText(MainActivity.this, "Empty List", Toast.LENGTH_LONG).show();
        }

        adapter = new UserDataAdapter( mylist, MainActivity.this);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}