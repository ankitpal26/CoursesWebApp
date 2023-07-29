package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

//    List<Course> list;

    public CourseServiceImpl(){

//        list = new ArrayList<>();
//        list.add(new Course(125,"Java Core Course","this course contains java basics"));
//        list.add(new Course(2424,"Spring Boot Course","Creating rest api using spring boot"));
    }

    @Override
    public List<Course> getCourse() {

        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//        Course c = null;
//        for (Course course:list)
//        {
//            if(course.getId()==courseId)
//            {
//                c=course;
//                break;
//            }
//        }
        return courseDao.getReferenceById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

//        list.forEach(e -> {
//            if(e.getId()== course.getId()) {
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
        courseDao.save(course);

        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
//        list = this.list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
       Course entity = courseDao.getReferenceById(parseLong);
       courseDao.delete(entity);
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
