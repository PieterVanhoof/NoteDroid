package ehb.be.notedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import ehb.be.notedroid.Model.Note;
import ehb.be.notedroid.Model.NoteDAO;
import ehb.be.notedroid.recyclerUtils.NoteAdapter;
import ehb.be.notedroid.recyclerUtils.RecyclerTouchListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNotes;
    private NoteAdapter adapter;
    private RecyclerTouchListener.ClickListener clickListener = new RecyclerTouchListener.ClickListener() {
        @Override
        public void onClick(View view, int position) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNotes = findViewById(R.id.rv_notes);
        adapter = new NoteAdapter(NoteDAO.getInstance().getNoteLijst());
        rvNotes.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvNotes.setLayoutManager(layoutManager);

        rvNotes.addOnItemTouchListener(new RecyclerTouchListener(this, clickListener));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
