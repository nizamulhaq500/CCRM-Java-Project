package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course findCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }
}