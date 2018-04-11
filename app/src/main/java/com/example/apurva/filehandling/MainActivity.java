package com.example.apurva.filehandling;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button save,read;
    public  static  String filename="jadu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.btn_save);
        read=findViewById(R.id.btn_read);
        e1=findViewById(R.id.et_file1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String data= e1.getText().toString();

               try {

                   FileOutputStream fout=openFileOutput(filename, Context.MODE_APPEND);
                   byte[]b=data.getBytes();
                   fout.write(b);

                   Toast.makeText(MainActivity.this, "Data saves", Toast.LENGTH_SHORT).show();
                   e1.setText("");

               }catch (Exception ex){

               }

            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    FileInputStream fin=openFileInput(filename);
                    int data=0;
                    String msg="";
                    while ((data=fin.read())!=-1){

                       msg+=Character.toString((char)data);
                    }
                    e1.setText(msg);

                }catch (Exception ex){

                }

            }
        });
    }
}
