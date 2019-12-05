package Adopter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.client2.R;
import java.util.List;
import Model.Tracks;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrackAdopter extends RecyclerView.Adapter<TrackAdopter.MyViewHolder> {
    private List<Tracks> history;

    public TrackAdopter(List<Tracks> history) {
        this.history = history;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup view, int viewType) {
        TextView v = (TextView) LayoutInflater.from(view.getContext()).inflate(R.layout.list_tracker, view, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        Tracks track = history.get(i);

        holder.distance.setText((int) track.getDistance());
        holder.start_time.setText(track.getStart_time());
        holder.end_time.setText(track.getEnd_time());
        holder.pace.setText((int) track.getPace());
        holder.calories.setText(track.getCalories_burned());
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView distance;
        TextView start_time;
        TextView end_time;
        TextView pace;
        TextView calories;

        public MyViewHolder(View view) {
            super(view);
            distance = (TextView) view.findViewById(R.id.track_distance);
            start_time = (TextView) view.findViewById(R.id.track_start_time);
            end_time = (TextView) view.findViewById(R.id.track_end_time);
            pace = (TextView) view.findViewById(R.id.track_pace);
            calories = (TextView) view.findViewById(R.id.track_calories);

        }
    }
}
