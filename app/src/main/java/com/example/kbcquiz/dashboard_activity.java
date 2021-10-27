package com.example.kbcquiz;

import static com.example.kbcquiz.MainActivity.listOfQ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class dashboard_activity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    long duration = 20;
    TextView timer,exit;

    List<ModelClass> allQuestionsList;
    ModelClass modelClass;
    int index = 0;
    TextView card_questions, optiona, optionb, optionc, optiond;
    CardView cardOA, cardOB, cardOC, cardOD;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        duration = TimeUnit.MILLISECONDS.toMillis(20000);

        countDownTimer = new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                String sDuration=String.format(Locale.ENGLISH,"%02d : %02d",TimeUnit.MILLISECONDS.toMinutes(l),TimeUnit.MILLISECONDS.toSeconds(l),
                        TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(l)));
                timer.setText(sDuration);
                //timerValue=timerValue-1;

            }

            @Override
            public void onFinish() {
                timer.setVisibility(View.VISIBLE);
                //Correct(cardOA);
                index++;
                modelClass  = listOfQ.get(index);
                setAllData();
                resetColor();
                enableButton();
            }
        }.start();


        allQuestionsList = listOfQ;
        Collections.shuffle(allQuestionsList);
        modelClass = listOfQ.get(index);

        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));

        linearLayout.setClickable(false);

        setAllData();
    }

    private void setAllData() {
        card_questions.setText(modelClass.getQuestion());
        optiona.setText(modelClass.getoA());
        optionb.setText(modelClass.getoB());
        optionc.setText(modelClass.getoC());
        optiond.setText(modelClass.getoD());

        duration=20;
        countDownTimer.start();
    }


    private void Hooks() {
        exit=findViewById(R.id.exit);

        card_questions = findViewById(R.id.card_question);
        optiona = findViewById(R.id.optiona);
        optionb = findViewById(R.id.optionb);
        optionc = findViewById(R.id.optionc);
        optiond = findViewById(R.id.optiond);

        cardOA = findViewById(R.id.cardOA);
        cardOB = findViewById(R.id.cardOB);
        cardOC = findViewById(R.id.cardOC);
        cardOD = findViewById(R.id.cardOD);

        linearLayout = findViewById(R.id.next);

        timer=findViewById(R.id.timer);
    }

    public void Correct(CardView cardView) {

        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    index++;
                    modelClass = listOfQ.get(index);
                    setAllData();
                    resetColor();
                    enableButton();
            }
        });

    }

    public void Wrong(CardView cardOA) {

        cardOA.setBackgroundColor(getResources().getColor(R.color.red));

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < listOfQ.size() - 1) {
                    index++;
                    modelClass = listOfQ.get(index);
                    setAllData();
                    resetColor();
                    enableButton();
                }

                else {
                    gameOver();
                }
            }
        });

    }

    private void gameOver() {
        Intent intent = new Intent(getApplicationContext(), gameWon.class);
        startActivity(intent);
    }

    public void enableButton() {
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }

    public void disableButton() {
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }

    public void resetColor() {
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void optionAClick(View view) {
        disableButton();
        linearLayout.setClickable(true);
        if (modelClass.getoA().equals(modelClass.getAns())) {
            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < listOfQ.size() - 1) {
                Correct(cardOA);
            }
            else{
                    gameOver();
                }
            } else {
                Wrong(cardOA);
            }
        }

    public void optionBClick(View view) {
        disableButton();
        linearLayout.setClickable(true);
        if (modelClass.getoB().equals(modelClass.getAns())) {
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < listOfQ.size() - 1) {
                Correct(cardOB);
            } else {
                gameOver();
            }
        } else {
            Wrong(cardOB);
        }
    }

    public void optionCClick(View view) {
        disableButton();
        linearLayout.setClickable(true);
        if (modelClass.getoC().equals(modelClass.getAns())) {
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < listOfQ.size() - 1) {
                Correct(cardOC);
            } else {
                gameOver();
            }
        } else {
            Wrong(cardOC);
        }
    }

    public void optionDClick(View view) {
        disableButton();
        linearLayout.setClickable(true);
        if (modelClass.getoD().equals(modelClass.getAns())) {
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < listOfQ.size() - 1) {
                Correct(cardOD);
            } else {
                gameOver();
            }
        } else {
            Wrong(cardOD);
        }
    }
}