package com.esgi.virtualclassroom.modules.classrooms;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esgi.virtualclassroom.R;
import com.esgi.virtualclassroom.data.models.Classroom;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassroomsRecyclerViewAdapter extends RecyclerView.Adapter<ClassroomsRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Classroom> classrooms;
    private Listener listener;

    ClassroomsRecyclerViewAdapter(ArrayList<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ClassroomsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_classroom_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassroomsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bind(classrooms.get(position));
    }

    @Override
    public int getItemCount() {
        return classrooms.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.classroom_title_text_view) TextView titleTextView;
        @BindView(R.id.classroom_description_text_view) TextView descriptionTextView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(final Classroom classroom) {
            titleTextView.setText(classroom.getTitle());
            descriptionTextView.setText(classroom.getDescription());
            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onClassroomClick(classroom);
                }
            });
        }
    }

    public interface Listener {
        void onClassroomClick(Classroom classroom);
    }
}