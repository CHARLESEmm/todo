package com.exemple.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class addNotes extends AppCompatActivity {

    private EditText noteEditText;
    private ImageView addNoteButton;
    private ListView notesListView;

    private TextView notesCountTextView;

    private int notesCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        addNoteButton = findViewById(R.id.buttonAdd);
        noteEditText = findViewById(R.id.texAdd);
        notesListView = findViewById(R.id.NotesList);
        notesCountTextView = findViewById(R.id.message2);

        List<String> notesList = new ArrayList<>();
        ArrayAdapter<String> notesArrayAdapter = new ArrayAdapter<>(this
                ,android.R.layout.simple_list_item_1, notesList);
        notesListView.setAdapter(notesArrayAdapter);
        notesCountTextView.setText("Vous avez " + notesCount + " rappels");
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(noteEditText.getText().toString().matches("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(addNotes.this);
                    builder.setTitle( "Pas de rappel")
                            .setMessage( "Veuillez écrire un rappel " )
                            .setPositiveButton("OK", new
                                    DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    })
                            .create()
                            .show();
                }
                else{
                    noteEditText.setTextColor(Color.BLACK);
                    notesList.add(noteEditText.getText().toString());
                    notesArrayAdapter.notifyDataSetChanged();
                    noteEditText.setText("");
                    notesCount++;
                }
                notesCountTextView.setText(notesCount + " rappel(s) enregistré(s)");
            }
        });
    }
}
