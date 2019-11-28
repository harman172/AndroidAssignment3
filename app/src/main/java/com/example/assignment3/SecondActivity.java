package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvCandidate1 = findViewById(R.id.candidate1);
        TextView tvCandidate2 = findViewById(R.id.candidate2);
        TextView tvCandidate3 = findViewById(R.id.candidate3);

        int votesOfCand1 = 0, votesOfCand2 = 0, votesOfCand3 = 0;

        for (Voter voter: Voter.voters ) {

            if (voter.candidateName.equals("candidate 1"))
                votesOfCand1 += 1;
            else if (voter.candidateName.equals("candidate 2"))
                votesOfCand2 += 1;
            else if (voter.candidateName.equals("candidate 3"))
                votesOfCand3 += 1;

        }

        tvCandidate1.setText(String.valueOf(votesOfCand1));
        tvCandidate2.setText(String.valueOf(votesOfCand2));
        tvCandidate3.setText(String.valueOf(votesOfCand3));


    }
}
