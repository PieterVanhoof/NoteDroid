package ehb.be.notedroid.Model;

import android.widget.Adapter;

import java.util.ArrayList;
import java.util.Date;

public class NoteDAO {
    private static final NoteDAO ourInstance = new NoteDAO();
    private ArrayList<Note> noteList = new ArrayList<>();

    public static NoteDAO getInstance() {
        return ourInstance;
    }

    private NoteDAO() {
        noteList.add(new Note("Reminder", "denk aan solicitaties",new Date()));
        noteList.add(new Note("OP LANES","fizz & Yorrick", new Date()));

    }
    public ArrayList<Note> getNoteLijst(){ return noteList; }

    public void addNote (Note newNote) { noteList.add(newNote);

    }
}
