package com.example.reportcard;

import java.util.ArrayList;

public class ReportCard {
    private String fullName;
    private String commentAboutStudent;
    private ArrayList<String> courses;
    private ArrayList<Integer> grades;
    private ArrayList<Integer> attendances;

    public ReportCard(String fullName, ArrayList<String> courses, ArrayList<Integer> grades, ArrayList<Integer> attendances) {
        this.fullName = fullName;
        this.courses = courses;
        this.grades = grades;
        this.attendances = attendances;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCommentAboutStudent() {
        return commentAboutStudent;
    }

    public void setCommentAboutStudent(String commentAboutStudent) {
        this.commentAboutStudent = commentAboutStudent;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public ArrayList<Integer> getAttendances() {
        return attendances;
    }

    public void setAttendances(ArrayList<Integer> attendances) {
        this.attendances = attendances;
    }

    public int getAverageGrades() {
        int cumulativeSum = 0;
        int averageGrades;

        for (int i = 0; i < this.grades.size(); i++) {
            cumulativeSum += this.grades.get(i);
        }

        averageGrades = cumulativeSum / this.grades.size();

        return averageGrades;
    }

    public String getStringOfOneCoursetWithGradeAndAttendance(int index) {
        ArrayList<String> courses = getCourses();
        ArrayList<Integer> grades = getGrades();
        ArrayList<Integer> attendances = getAttendances();

        String courseWithGradeAndAttendance = courses.get(index)
                + " \nwith grade: " + grades.get(index)
                + " \nwith an attendance of: " + attendances.get(index) + " days";

        return courseWithGradeAndAttendance;
    }

    public String getStringOfAllCoursesWithGradesAndAttendances() {
        String allCoursesWithGradesAndAttendances = "";

        for (int i = 0; i < this.courses.size(); i++) {
            allCoursesWithGradesAndAttendances
                    += (getStringOfOneCoursetWithGradeAndAttendance(i) + "\n");
        }

        return allCoursesWithGradesAndAttendances;
    }

    public String toString()
    {
        String fillReportCard = "Student: " + this.fullName + "\n" +
                "Resume of your subjects: " + "\n" + getStringOfAllCoursesWithGradesAndAttendances() +
                "Average of your grades: " + getAverageGrades() + "\n" +
                "Comment about the student: " + this.commentAboutStudent;

        return fillReportCard;
    }
}
