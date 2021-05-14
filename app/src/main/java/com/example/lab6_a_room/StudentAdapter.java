package com.example.lab6_a_room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.students = students;
    }

    @NonNull
    @Override
    public com.example.lab6_a_room.StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new StudentViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.lab6_a_room.StudentAdapter.StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.tvName.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private com.example.lab6_a_room.StudentAdapter adapter;
        public StudentViewHolder(@NonNull View itemView, com.example.lab6_a_room.StudentAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
