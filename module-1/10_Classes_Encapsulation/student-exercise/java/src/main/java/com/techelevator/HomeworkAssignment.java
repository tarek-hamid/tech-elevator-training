package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks){
        this.possibleMarks = possibleMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getLetterGrade() {
        int result = (earnedMarks * 100)/possibleMarks;
        if (result > 89){
            letterGrade = "A";
        } else if (result > 79) {
            letterGrade = "B";
        } else if (result > 69) {
            letterGrade = "C";
        } else if (result > 59) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }


    public String getSubmitterName() {
        return submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

     public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

}
