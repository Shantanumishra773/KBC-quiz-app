package com.example.kbcquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;

    public static ArrayList<ModelClass> listOfQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listOfQ=new ArrayList<>();
        listOfQ.add(new ModelClass("Which one is the first search engine in internet","Google","Archie","Altavista","WAIS","Archie"));
        listOfQ.add(new ModelClass("Number of bit used by the IPv6 address","32 bit","64 bit","128 bit","256 bit","128 bit"));
        listOfQ.add(new ModelClass(" Which one is the first web browser invented in 1990"," Internet Explorer","Mosaic","Mozilla","Nexus","Nexus"));
        listOfQ.add(new ModelClass("Which of the following programming language is used to create programs like applets?","COBOL","C Language","Java","BASIC","Java"));
        listOfQ.add(new ModelClass("First computer virus is known as","Rabbit","Creeper Virus","Elk Cloner","SCA Virus","Creeper Virus"));
        listOfQ.add(new ModelClass("Which one is the first fully supported 64-bit operating system","Windows Vista","Mac","Linux","Windows XP","Linux"));
        listOfQ.add(new ModelClass("Computer Hard Disk was first introduced in 1956 by","Dell","Apple","Microsoft","IBM","IBM"));
        listOfQ.add(new ModelClass("Which of the following is not a web browser","MOSAIC","WWW","Facebook","Netscape navigator","Facebook"));
        listOfQ.add(new ModelClass(" In computer world, Trojan refer to","Virus","Malware","Worm","Spyware","Malware"));
        listOfQ.add(new ModelClass(" Which one of the followings is a programming language","HTTP","HTML","HPML","FTP","HTML"));

        Button btn=findViewById(R.id.start);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent intent=new Intent(MainActivity.this,dashboard_activity.class);
                        startActivity(intent);
            }
        });
    }
}