package com.alexia.callbutton.jsonparsers;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import com.alexia.callbutton.MainActivity;
import com.alexia.callbutton.fragments.QuestionnaireInstructionFragment;
import com.alexia.callbutton.fragments.QuestionnaireSurveyFragment;

public class UserScore extends QuestionnaireSurveyFragment {

    private static String url = "http://192.168.43.186:9090/api/tests/score/?phone=";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new PostScore().execute();

        ((MainActivity) getActivity()).openFragment(new QuestionnaireInstructionFragment());
    }

    @SuppressLint("StaticFieldLeak")
    private class PostScore extends AsyncTask<Void, Void, Void> {
        int idScore = 1;
        String userPhone = "0933797479";
        int score = pointSum;


        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String questionUrl = url + String.valueOf(userPhone) + "&score=" + String.valueOf(score) + "&survey=" + String.valueOf(idScore);

            sh.makeServiceCall1(questionUrl);
            return null;
        }
    }
}
