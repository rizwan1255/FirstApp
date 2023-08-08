package com.example.oflinedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText password, name;
    Button button;
    MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);


        database = new MyDatabase(MainActivity.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = name.getText().toString();
                String b = password.getText().toString();

                database.saveData(database, a, b);
            }
        });
    }
}