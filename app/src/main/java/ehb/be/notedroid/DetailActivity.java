package ehb.be.notedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class DetailActivity extends AppCompatActivity {
    private TextView tvDetailsTitel, tvDetailsContent, tvDetailsDatum ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailsDatum = findViewById(R.id.tv_Details_Datum);
        tvDetailsTitel = findViewById(R.id.tv_Details_Titel);
        tvDetailsContent = findViewById(R.id.tv_Details_Content);

    }
}
