package com.example.todolist;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> toDos = new ArrayList<>();
    ArrayList<String> completed = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toDos.add("test1");
        toDos.add("test2");
        completed.add("test3");
        completed.add("test4");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,toDos);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,completed);

        Button btn = findViewById(R.id.btn_mybutton);
        EditText editText = findViewById(R.id.inp_name);
        ListView listViewToDo = findViewById(R.id.listTodo);
        ListView listViewComplete = findViewById(R.id.listComplete);
        TextView textView = findViewById(R.id.txt_box);
        TextView completedTasks = findViewById(R.id.txt_box2);
        textView.setText("Todo List: \n");
        completedTasks.setText("Completed Tasks: \n");

        btn.setOnClickListener(view ->{
          toDos.add(editText.getText().toString());
          listViewToDo.setAdapter(adapter);
        });



        listViewToDo.setAdapter(adapter);
        listViewComplete.setAdapter(adapter2);
    }


}