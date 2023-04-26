package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.Date;
import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();
    private final HashMap<String, Course> courses = new HashMap<>();

    public void registerStudent(Student student,String id, String name, String email, Date birthDate)
    {
        //TODO Add new student to the students hashmap
        Student newStudent = new Student(id, name, email, birthDate);
        this.students.put(newStudent.getId(), newStudent);

    }

    public Student findStudent( String studentId ) {
        //TODO Find the student from the Hashmap with the student id
        if (this.students.containsKey(studentId)) {
            return this.students.get(studentId);

        }
        return null;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if not enroll student to the course
        Student getStudent = this.students.get(studentId);
        Course getCourse =  this.courses.get(course);
        getStudent.enrollToCourse(getCourse);

    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        System.out.println( "Student Details:" );
        for ( String key : students.keySet() )
        {
            Student student = students.get( key );
            System.out.println( student );
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses
        return this.enrolledCourses(student);

    }

    public Course findEnrolledCourse( Student student, String courseId ) {
        //TODO return the course enrolled by the student from the course Id
        if (this.courses.containsKey(courseId)) {
            return this.courses.get(courseId);
        }
        return null;
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
