package ehb.be.notedroid.Model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert
    void insertNote(Note jNote);

    @Delete
    void deleteNote(Note jNote);

    @Query("SELECT * FROM Note")
    List<Note> selectAllNote();


    @Query("SELECT * FROM Note WHere id = :id")
    Note selectNoteByID(long id);
}
