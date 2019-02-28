package ehb.be.notedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import ehb.be.notedroid.Model.Note;
import ehb.be.notedroid.Model.NoteDatabase;

public class AddNoteActivity extends AppCompatActivity {

    private EditText etTitle,etContent;
    private Button btnSave;

    private View.OnClickListener btnSaveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Note nNote = new Note(etTitle.getText().toString(),etContent.getText().toString(),new Date());
            NoteDatabase.getInstance(getApplicationContext()).getNoteDAO().insertNote(nNote);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.et_save_title);
        etContent = findViewById(R.id.et_save_content);
        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(btnSaveListener);



    }
}
