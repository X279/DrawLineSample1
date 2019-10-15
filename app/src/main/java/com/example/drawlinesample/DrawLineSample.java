package com.example.drawlinesample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DrawLineSample extends Activity {
    Button erase;
    Spinner spinner;
    Spinner erasespinner;
    Spinner penspinner;
    Button pen;
    Button clear;
    TestView testView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pen = findViewById(R.id.pen);
        clear = findViewById(R.id.clear);
        erase = findViewById(R.id.erase);
        testView = findViewById(R.id.paintview);
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("eraseTag","切换为橡皮擦");
                testView.setMode(1);
            }
        });
        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testView.setMode(0);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testView.clearPaint();
            }
        });
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(DrawLineSample.this,color,Toast.LENGTH_SHORT).show();
                switch (color)
                {
                    case "笔为黑色":
                        testView.setPenColor(Color.BLACK);
                        break;
                    case "笔为蓝色":
                        testView.setPenColor(Color.BLUE);
                        break;
                    case "笔为红色":
                        testView.setPenColor(Color.RED);
                        break;
                    case "笔为绿色":
                        testView.setPenColor(Color.GREEN);
                        break;
                    case "笔为黄色":
                        testView.setPenColor(Color.YELLOW);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        erasespinner = findViewById(R.id.erasespinner);
        penspinner = findViewById(R.id.penspinner);
        erasespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String widthString = parent.getItemAtPosition(position).toString();
                Toast.makeText(DrawLineSample.this,widthString,Toast.LENGTH_SHORT).show();
                switch (widthString)
                {
                    case "小橡皮擦":
                        testView.setEraseWidth(20);
                        break;
                    case "中等橡皮擦":
                        testView.setEraseWidth(30);
                        break;
                    case "大橡皮擦":
                        testView.setEraseWidth(40);
                        break;
                    case "巨大橡皮擦":
                        testView.setEraseWidth(50);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        penspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String width = parent.getItemAtPosition(position).toString();
                Toast.makeText(DrawLineSample.this,width,Toast.LENGTH_SHORT).show();
                switch (width)
                {
                    case "极细笔":
                        testView.setPenWidth(3);
                        break;
                    case "普通笔":
                        testView.setPenWidth(12);
                        break;
                    case "粗笔":
                        testView.setPenWidth(16);
                        break;
                    case "涂鸦笔":
                        testView.setPenWidth(20);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
