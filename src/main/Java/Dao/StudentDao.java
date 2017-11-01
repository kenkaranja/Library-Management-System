package Dao;

import Entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class StudentDao extends CustomDao<Student> {

    public StudentDao(EntityManager em) {
        super(em);
    }

    @SuppressWarnings("unchecked")
    public boolean login(Student student) {
        try {
            List<Student> studentList = em.createNamedQuery("Slogin").setParameter("username", student.getRegNo()).setParameter("password", student.getPassword()).getResultList();
            return studentList.size() > 0;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean add(Student student) {
        return this.addCustom(student);
    }

    @SuppressWarnings("unchecked")
    public Student viewById(Student student) {
        try {
            List<Student> studentList = em.createNamedQuery("viewById").setParameter("regNo", student.getRegNo()).getResultList();
            return studentList.size() > 0 ? studentList.get(0) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Student> viewAll() {
        try {
            return em.createNamedQuery("viewAll").getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }
}
