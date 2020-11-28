package com.example.quiz;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

class MyCustomAdapter extends FragmentStatePagerAdapter {
    private final ArrayList<Question> questionArrayList;

    public MyCustomAdapter(FragmentManager fm, ArrayList<Question> questionArrayList) {
        super(fm);
        this.questionArrayList = questionArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        FragmnetQuestion fragmnetQuestion = new FragmnetQuestion();
        fragmnetQuestion.setQuestion(questionArrayList.get(position));
        return fragmnetQuestion;
    }

    @Override
    public int getCount() {
        return questionArrayList.size();
    }
}
