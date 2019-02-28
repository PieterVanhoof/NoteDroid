package ehb.be.notedroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import ehb.be.notedroid.Model.Note;
import ehb.be.notedroid.Model.NoteDatabase;
import ehb.be.notedroid.recyclerUtils.NoteAdapter;
import ehb.be.notedroid.recyclerUtils.RecyclerTouchListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNotes;
    private NoteAdapter adapter;
    private Button btnDelete;
    private RecyclerTouchListener.ClickListener clickListener = new RecyclerTouchListener.ClickListener() {
        @Override
        public void onClick(View view, int position) {

            long id = adapter.getItemId(position);
            Note n = NoteDatabase.getInstance(getApplicationContext()).getNoteDAO().selectNoteByID(id);

            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("note" ,  n);
            startActivity(intent);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //welke container
        rvNotes = findViewById(R.id.rv_notes);
        //welke data uit DAO
        adapter = new NoteAdapter((ArrayList<Note>) NoteDatabase.getInstance(getApplicationContext()).getNoteDAO().selectAllNote(), getApplicationContext());
        //Adapter, hoe moet alles opgevuld worden
        rvNotes.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvNotes.setLayoutManager(layoutManager);

        rvNotes.addOnItemTouchListener(new RecyclerTouchListener(this, clickListener));
    }

    public void newClicked(View v){
        Intent intent = new Intent(getApplicationContext(),AddNoteActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.btn_save :
                Intent intent = new Intent(getApplicationContext(),AddNoteActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
