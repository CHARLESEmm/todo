package com.exemple.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView question;

    private Button startButton;

    private EditText nom;

    private TextView message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.questionText);
        nom = findViewById(R.id.editTextNom);
        message = findViewById(R.id.textViewMessage);
        startButton =findViewById(R.id.buttonStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nom.getText().toString().matches("")){
                    message.setVisibility(View.VISIBLE);
                    message.setTextColor(Color.RED);
                    message.setText("Trop pressé verifier si le champ n'est pas vide ! ");
                }
                else{
                    startActivity(new Intent(MainActivity.this, addNotes.class));

                }

            }

        });

    }
}