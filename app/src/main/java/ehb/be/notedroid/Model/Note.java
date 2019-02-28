package ehb.be.notedroid.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Note implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String Title, noteContent;
    private Date Datum;

    public Note() {
    }

    public Note(String title, String noteContent, Date datum) {
        Title = title;
        this.noteContent = noteContent;
        Datum = datum;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Note{" +
                "Title='" + Title + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", Datum=" + Datum +
                '}';
    }
}
