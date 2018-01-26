package com.example.jonjon.wordplayversion4;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "WordPlay4Choice";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_ChoiceA= "choiceA"; //option a
    private static final String KEY_ChoiceB= "choiceB"; //option b
    private static final String KEY_ChoiceC= "choiceC"; //option c
    private static final String KEY_ChoiceD= "choiceD"; //option d
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_ChoiceA +" TEXT, "
                +KEY_ChoiceB +" TEXT, "+KEY_ChoiceC+" TEXT, " + KEY_ChoiceD + " Text)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("Which defintion of the following word","A", "B", "C", "D", "C");
        this.addQuestion(q1);
        Question q2=new Question("Which defintion of the following word2","A", "B", "C","D", "C");
        this.addQuestion(q2);
        Question q3=new Question("Which defintion of the following word3","A", "B", "C","D", "C");
        this.addQuestion(q3);
        Question q4=new Question("Which defintion of the following word4","A", "B", "C","D", "C");
        this.addQuestion(q4);
        Question q5=new Question("Which defintion of the following word5","A", "B", "C","D", "C");
        this.addQuestion(q5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_ChoiceA, quest.getChoiceA());
        values.put(KEY_ChoiceB, quest.getChoiceB());
        values.put(KEY_ChoiceC, quest.getChoiceC());
        values.put(KEY_ChoiceD, quest.getChoiceD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setChoiceA(cursor.getString(3));
                quest.setChoiceB(cursor.getString(4));
                quest.setChoiceC(cursor.getString(5));
                quest.setChoiceD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}