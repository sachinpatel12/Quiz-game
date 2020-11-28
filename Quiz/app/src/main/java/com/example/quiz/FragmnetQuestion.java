package com.example.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import static com.example.quiz.Quiz.currentq;

class FragmnetQuestion extends Fragment {
    public int j;
    private View rootView;
    private Question question;
    SharedPreferenceUtil s1;
    FragmnetQuestion f;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_que, container, false);
        TextView questiontv = rootView.findViewById(R.id.q1);
        s1=new SharedPreferenceUtil(getActivity());


        TextView ans1 = rootView.findViewById(R.id.ans1);
        TextView ans2 = rootView.findViewById(R.id.ans2);
        TextView ans3 = rootView.findViewById(R.id.ans3);
        TextView ans4 = rootView.findViewById(R.id.ans4);
        questiontv.setText(question.getQuestion());
        ans1.setText(question.getAnswer().get(0));
        ans2.setText(question.getAnswer().get(1));
        ans3.setText(question.getAnswer().get(2));
        ans4.setText(question.getAnswer().get(3));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerselected(view);
            }
        };
        ans1.setOnClickListener(listener);
        ans2.setOnClickListener(listener);
        ans3.setOnClickListener(listener);
        ans4.setOnClickListener(listener);
        return rootView;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void onAnswerselected(View view) {
        switch (view.getId()) {
            case R.id.ans1:
                checkAnswer(1);
                break;
            case R.id.ans2:
                checkAnswer(2);
                break;
            case R.id.ans3:
                checkAnswer(3);
                break;
            case R.id.ans4:
                checkAnswer(4);
                break;
        }
    }

    private void checkAnswer(int i) {
        if (i == question.getCorrectAns()) {
            showCorrectAnswerUI();
        } else {
            showIncorrectAnswerUI();
        }

    }

    private void showCorrectAnswerUI() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Correct Answer");
        final Quiz activity = (Quiz) getActivity();
        activity.score += 1;
        activity.currentq=+1;

        builder.setMessage("Your Score is " + activity.score);
//        if(activity.score>activity.highscore)
//        {
//            int j=activity.score;
//            s.saveno("highscore",j);
//        }
        if(activity.score>activity.hs)
        {
            int i= activity.score;
            s1.saveno("high",i);


        }



        builder.setPositiveButton("Next Question", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Quiz.viewPager.setCurrentItem(Quiz.viewPager.getCurrentItem() + 1);

            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                getActivity().finish();


            }
        });
        builder.show();


    }


    private void showIncorrectAnswerUI() {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Incorrect Answer");
        Quiz activity = (Quiz) getActivity();
        builder.setMessage("Your Score is  " + activity.score);


        if(activity.score>activity.hs)
        {
           int i= activity.score;
            s1.saveno("high",i);

        }

        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().finish();

            }
        });
        builder.show();

    }
    //350 kg/m3
    //ans*1000

    //ans*1000/den
    public void dustrsize(double waste)
    {

        double vol=(waste*1000)/350;

    }
}
