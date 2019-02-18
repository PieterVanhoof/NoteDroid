package ehb.be.notedroid.Model;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
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

    @Override
    public String toString() {
        return "Note{" +
                "Title='" + Title + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", Datum=" + Datum +
                '}';
    }
}
