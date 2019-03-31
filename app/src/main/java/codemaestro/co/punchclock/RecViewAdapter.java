package codemaestro.co.punchclock;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import codemaestro.co.punchclock.Model.TimeEntry;


public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.CustomViewHolder> {

    private LayoutInflater inflater;
    private List<TimeEntry> timeEntries;
    private Context context;

    public RecViewAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
//        this.timeEntries = new ArrayList<>();
    }

    // Passes the list of categories we received from the Observer
    public void setTimeEntries(final List<TimeEntry> timeEntries) {
        this.timeEntries = timeEntries;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public RecViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recycler_view_row, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewAdapter.CustomViewHolder viewHolder, int i) {
//        TimeEntry timeEntry = timeEntries.get(i);
//        viewHolder.textViewTimeCommitted.setText(""+timeEntry.getTimeCommitted());
//        viewHolder.textViewStartTime.setText(timeEntry.getStartTime());
//        viewHolder.textViewEndTime.setText(timeEntry.getEndTime());
//        viewHolder.textViewDate.setText(timeEntry.getDateOfEntry());
    }

    @Override
    public int getItemCount() {
//        return timeEntries.size();
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTimeCommitted, textViewStartTime, textViewEndTime, textViewDate;

        CustomViewHolder(View itemView) {
            super(itemView);
            textViewTimeCommitted = itemView.findViewById(R.id.textViewTimeCommitted);
            textViewStartTime = itemView.findViewById(R.id.textViewStartTime);
            textViewEndTime = itemView.findViewById(R.id.textViewEndTime);
            textViewDate = itemView.findViewById(R.id.textViewDate);
        }
    }
}
