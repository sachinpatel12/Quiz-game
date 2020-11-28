package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
    SharedPreferenceUtil s;
    private boolean isMusicOn;
    public ArrayList<Question> questionArrayList;
    public static ViewPager viewPager;
    public int hs;
    public int score = 0;
    public static int currentq=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setTitle("Quiz");
        s = new SharedPreferenceUtil(this);
        isMusicOn = s.getboolean("k");

        questionArrayList = new ArrayList<>();
        initializequestions();
        hs = s.getno("high");
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyCustomAdapter(getSupportFragmentManager(), questionArrayList));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                if(position!=currentq){
//                    viewPager.setCurrentItem(currentq);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initializequestions() {
        Question questions = new Question();
        questions.setQuestion(" The Paithan (Jayakwadi) Hydro-electric project, completed with the help of Japan, is on the river.");
        ArrayList<String> Answer = new ArrayList<>();
        Answer.add("Ganga");
        Answer.add("Cauvery");
        Answer.add("Godavari");
        Answer.add("Narmada");
        questions.setAnswer(Answer);
        questions.setCorrectAns(3);
        questionArrayList.add(questions);

        Question questions1 = new Question();
        ArrayList<String> Answer1 = new ArrayList<>();
        questions1.setQuestion("The percentage of irrigated land in India is about.");
        Answer1.add("45");
        Answer1.add("35");
        Answer1.add("23");
        Answer1.add("34");
        questions1.setAnswer(Answer1);
        questions1.setCorrectAns(2);

        questionArrayList.add(questions1);

        Question questions2 = new Question();
        ArrayList<String> Answer2 = new ArrayList<>();
        questions2.setQuestion("The southernmost point of peninsular India, that is, Kanyakumari, is");
        Answer2.add("north of Tropic of Cancer");
        Answer2.add("south of the Equator");
        Answer2.add("south of the Capricorn");
        Answer2.add("north of the Equator");
        questions2.setAnswer(Answer2);
        questions2.setCorrectAns(4);

        questionArrayList.add(questions2);
        ArrayList<String> Answer3 = new ArrayList<>();
        Question questions3 = new Question();
        questions3.setQuestion("The pass located at the southern end of the Nilgiri Hills in south India is called");
        Answer3.add("the Palghat gap");
        Answer3.add("the Bhorghat pass");
        Answer3.add("the Thalgat pass");
        Answer3.add("the Bolan pass");
        questions3.setAnswer(Answer3);
        questions3.setCorrectAns(1);

        questionArrayList.add(questions3);

        Question questions4 = new Question();
        ArrayList<String> Answer4 = new ArrayList<>();
        questions4.setQuestion("The principal copper deposits of India lie in which of the following places?");
        Answer4.add("Hazaribag and Singbhum of Bihar");
        Answer4.add("Khetri and Daribo areas of Rajasthan");
        Answer4.add("Anantapur in Andhra Pradesh");
        Answer4.add(" Siwaliks in Uttar Pradesh and in Karnataka");
        questions4.setAnswer(Answer4);
        questions4.setCorrectAns(1);

        questionArrayList.add(questions4);

        Question questions5 = new Question();
        ArrayList<String> Answer5 = new ArrayList<>();
        questions5.setQuestion("The Yarlung Zangbo River, in India, is known as");
        Answer5.add("ganga");
        Answer5.add("indus");
        Answer5.add("Brahmaputra");
        Answer5.add("mahanadi");
        questions5.setAnswer(Answer5);
        questions5.setCorrectAns(3);

        questionArrayList.add(questions5);
        Question questions6 = new Question();
        ArrayList<String> Answer6 = new ArrayList<>();
        questions6.setQuestion("The Salal Project is on the river");
        Answer6.add("Chenab");
        Answer6.add("mahanadi");
        Answer6.add("tapi");
        Answer6.add("narmada");
        questions6.setAnswer(Answer6);
        questions6.setCorrectAns(4);

        questionArrayList.add(questions6);
        Question questions7 = new Question();
        ArrayList<String> Answer7 = new ArrayList<>();
        questions7.setQuestion(" The only zone in the country that produces gold is also rich in iron is");
        Answer7.add("North-eastern zone");
        Answer7.add("North-western zone");
        Answer7.add("Southern zone");
        Answer7.add("NOTA");
        questions7.setAnswer(Answer7);
        questions7.setCorrectAns(3);

        questionArrayList.add(questions7);
        Question questions8 = new Question();
        ArrayList<String> Answer8 = new ArrayList<>();
        questions8.setQuestion("2+2=?");
        Answer8.add("north of Tropic of Cancer");
        Answer8.add("3");
        Answer8.add("south of the Capricorn");
        Answer8.add("4");
        questions8.setAnswer(Answer8);
        questions8.setCorrectAns(4);

        questionArrayList.add(questions8);
        Question questions9 = new Question();
        ArrayList<String> Answer9 = new ArrayList<>();
        questions9.setQuestion("6+92");
        Answer9.add("north of Tropic of Cancer");
        Answer9.add("98");
        Answer9.add("south of the Capricorn");
        Answer9.add("north of the Equato");
        questions9.setAnswer(Answer9);
        questions9.setCorrectAns(2);

        questionArrayList.add(questions9);
    }

    public void onBackPressed() {

        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (isMusicOn) {
            MainActivity.mediaPlayer.start();
        } else {
            MainActivity.mediaPlayer.pause();
        }
        // mediaPlayer.start();
    }
}
