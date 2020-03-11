package com.example.reportcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> coursesOne = new ArrayList<>();
        coursesOne.add("Maths");
        coursesOne.add("Ojective-C");
        coursesOne.add("Android Developement");
        coursesOne.add("Data Structures");
        coursesOne.add("Artificial Intelligence");

        ArrayList<Integer> gradesOne = new ArrayList<>();
        gradesOne.add(16);
        gradesOne.add(9);
        gradesOne.add(20);
        gradesOne.add(18);
        gradesOne.add(16);

        ArrayList<Integer> attendancesOne = new ArrayList<>();
        attendancesOne.add(190);
        attendancesOne.add(170);
        attendancesOne.add(200);
        attendancesOne.add(180);
        attendancesOne.add(140);

        String nameStudentOne = "Sebastian PQ";

        ReportCard studentOne =
                new ReportCard(nameStudentOne, coursesOne, gradesOne, attendancesOne);

        String commentForStudentOne = "You can!";
        studentOne.setCommentAboutStudent(commentForStudentOne);

        Log.i("MainActivity", studentOne.toString());

    }
}
