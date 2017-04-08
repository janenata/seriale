package com.izanat.Service;

import com.izanat.Dao.StudentDao;
import com.izanat.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Nathalie on 08.04.2017.
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }
}
