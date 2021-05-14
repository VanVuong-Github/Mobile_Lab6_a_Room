package com.example.lab6_a_room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {
    @Query("select * from student")
    List<Student> getAll();

    @Insert
    void insert(Student student);

    @Query("delete from student where student_name = :name")
    void deleteStudentByName(String name);
}
