package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText etName, etID;
    Button btnVote;
    Spinner spinner;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etID = findViewById(R.id.et_id);
        btnVote = findViewById(R.id.btnVote);
        spinner = findViewById(R.id.spinner);
        toggleButton = findViewById(R.id.toggle);

        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean voted = false;


                if (validations()){

                    if (!Voter.voters.isEmpty()){
                        voted = alreadyVoted();
                    }

                    if (!voted){

                        Voter voter = new Voter();
                        voter.name = etName.getText().toString();
                        voter.ID = etID.getText().toString();

                        if (toggleButton.isChecked()){
                            voter.candidateName = spinner.getSelectedItem().toString();
                            Voter.voters.add(voter);

                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);

                        } else{
                            voter.candidateName = "Refused";
                            Voter.voters.add(voter);

                            Toast.makeText(MainActivity.this, "Successfully voted.", Toast.LENGTH_SHORT).show();
                        }




                    } else{
                        Toast.makeText(MainActivity.this, "Already Voted.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }


    private boolean validations(){

        if (!etName.getText().toString().isEmpty() && !etID.getText().toString().isEmpty()){

            if (spinner.getSelectedItemPosition() > 0){
                return true;
            }
            else {
                Toast.makeText(this, "Please select a candidate", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        else {
            Toast.makeText(this, "All fields are required.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean alreadyVoted(){
        for (Voter voter: Voter.voters) {
            if (voter.ID.equals(etID.getText().toString())){
                return true;
            }
        }
        return false;
    }
}
