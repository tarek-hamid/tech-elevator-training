package com.techelevator;

public class GradeManager {

    int[] grades;

    public GradeManager(int[] gradesArray) {
        grades = gradesArray;
    }

    public double averageGrade(){
        int total = 0;
        for (int value : grades){
            total += value;
        }
        return total/grades.length;
    }
}
