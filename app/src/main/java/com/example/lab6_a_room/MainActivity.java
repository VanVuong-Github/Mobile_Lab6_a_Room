package com.example.lab6_a_room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private StudentAdapter adapter;
    private List<Student> students = new ArrayList<Student>();

    private Button btnAdd;
    private Button btnRemove;
    private EditText txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_name_list);
        btnAdd = findViewById(R.id.btn_add);
        btnRemove = findViewById(R.id.btn_remove);
        txtName = findViewById(R.id.txt_name);

        StudentDatabase db = Room.databaseBuilder(getApplicationContext(),StudentDatabase.class,"studentdb")
                .allowMainThreadQueries()
                .build();
        StudentDAO dao = db.studentDAO();
        if(students.size() == 0){
            dao.insert(new Student("Lại Văn Vượng"));
            dao.insert(new Student("Hoàng Quốc Cường"));
            dao.insert(new Student("Phạm Minh Dũng"));
            dao.insert(new Student("Châu Hoàng Duy"));
            dao.insert(new Student("Trần Nhật Duy"));
            dao.insert(new Student("Nguyễn Đình Hảo"));
            dao.insert(new Student("Hà Khã Huê"));
            dao.insert(new Student("Nguyễn Hoàng Hữu"));
            dao.insert(new Student("Lê Nguyễn Quang Linh"));
            dao.insert(new Student("Nguyễn Công Minh"));
            students = dao.getAll();
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(txtName.getText());
                dao.insert(new Student(name));
                students = dao.getAll();
                adapter = new StudentAdapter(MainActivity.this, students);
                LinearLayoutManager linearLayout = new LinearLayoutManager(MainActivity.this);
                rv.setAdapter(adapter);
                rv.setLayoutManager(linearLayout);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(txtName.getText());
                dao.deleteStudentByName(name);
                students = dao.getAll();
                adapter = new StudentAdapter(MainActivity.this, students);
                LinearLayoutManager linearLayout = new LinearLayoutManager(MainActivity.this);
                rv.setAdapter(adapter);
                rv.setLayoutManager(linearLayout);
            }
        });

        adapter = new StudentAdapter(this, students);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(linearLayout);
    }
}