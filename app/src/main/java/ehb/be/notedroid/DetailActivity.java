package ehb.be.notedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

import ehb.be.notedroid.Model.Note;

public class DetailActivity extends AppCompatActivity {
    private TextView tvDetailsTitel, tvDetailsContent, tvDetailsDatum ;
    private Note geselecteerdeNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailsDatum = findViewById(R.id.tv_Details_Datum);
        tvDetailsTitel = findViewById(R.id.tv_Details_Titel);
        tvDetailsContent = findViewById(R.id.tv_Details_Content);

        geselecteerdeNote = (Note) getIntent().getSerializableExtra("note");
        tvDetailsTitel.setText(geselecteerdeNote.getTitle());
        tvDetailsContent.setText(geselecteerdeNote.getNoteContent());
        tvDetailsDatum.setText(geselecteerdeNote.getDatum().toString());




    }
}
