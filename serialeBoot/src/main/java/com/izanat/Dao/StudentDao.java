package com.izanat.Dao;

import com.izanat.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nathalie on 08.04.2017.
 */
@Repository
public class StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Mary", "Science"));
                put(2, new Student(2, "Marty", "IT"));
                put(3, new Student(3, "Lola", "nothing"));

            }
        };
    }
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }
}
