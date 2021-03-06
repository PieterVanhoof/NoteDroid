package ehb.be.notedroid.recyclerUtils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    public interface ClickListener{
        void onClick(View view, int position);
    }

    private ClickListener clickListener;
    private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context, ClickListener clickListener){
        this.clickListener =clickListener;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener()); {
        }
    }
    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View rij = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (rij != null && motionEvent.getAction() == MotionEvent.ACTION_UP){
            clickListener.onClick(rij,recyclerView.getChildAdapterPosition(rij));
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
