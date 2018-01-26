package com.example.jonjon.wordplayversion4;

public class Question {
    private int ID;
    private String Questions;
    private String ChoiceA;
    private String ChoiceB;
    private String ChoiceC;
    private String ChoiceD;
    private String Answer;
    public Question()
    {
        ID=0;
        Questions="";
        ChoiceA="";
        ChoiceB="";
        ChoiceC="";
        ChoiceD="";
        Answer="";
    }
    public Question(String q, String c1, String c2, String c3, String c4,
                    String solution) {

        Questions = q;
        ChoiceA = c1;
        ChoiceB =  c2;
        ChoiceC =  c3;
        ChoiceD = c4;
        Answer = solution;
    }
    public int getID()
    {
        return ID;
    }
    public String getQUESTION() {
        return Questions;
    }
    public String getChoiceA() {
        return ChoiceA;
    }
    public String getChoiceB() {
        return ChoiceB;
    }
    public String getChoiceC() {return ChoiceC;}
    public String getChoiceD() {return ChoiceD;}
    public String getAnswer() {
        return Answer;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setQuestion(String q) {
        Questions = q;
    }
    public void setChoiceA(String c1) {
        ChoiceA = c1;
    }
    public void setChoiceB(String c2) {
        ChoiceB = c2;
    }
    public void setChoiceC(String c3) {
        ChoiceC = c3;
    }
    public void setChoiceD(String c4) {
        ChoiceD = c4;
    }
    public void setAnswer(String solution) {
        Answer = solution;
    }

}
