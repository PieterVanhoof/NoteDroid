package ehb.be.notedroid.recyclerUtils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ehb.be.notedroid.Model.Note;
import ehb.be.notedroid.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.noteViewHolder> {

    public class noteViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvTitel, tvContent, tvDate;

        public noteViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTitel = itemView.findViewById(R.id.tv_titel);
            tvDate = itemView.findViewById(R.id.tv_Date);

        }
    }
        private ArrayList<Note> items;

        public NoteAdapter(ArrayList<Note> items) {
            this.items = items;


    }

    @NonNull
    @Override
    public noteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View cardRijView = LayoutInflater.from(context).inflate(R.layout.note_cell,viewGroup,false);
        return new noteViewHolder(cardRijView);
    }

    @Override
    public void onBindViewHolder(@NonNull noteViewHolder noteViewHolder, int i) {
            Note noteInRow = items.get(i);

            noteViewHolder.tvTitel.setText(noteInRow.getTitle());
            noteViewHolder.tvContent.setText(noteInRow.getNoteContent());
            noteViewHolder.tvDate.setText(noteInRow.getDatum().toString());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
