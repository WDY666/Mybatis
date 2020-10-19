package com.dao;

import com.pojo.City;
import com.pojo.CityCategory;
import com.pojo.StuClass;
import com.pojo.Student;

import java.util.List;

/**
 * @Author WDY
 * @Date 2020-09-20 14:29
 * @Description TODO
 */
public interface StudentDao {
    /**
     * 增加学生
     * @param student
     */
    public void addStudent(Student student);

    /**
     * 批量增加学生
     * @param students
     */
    public void batchAddStudent(List<Student> students);
    /**
     * 删除学生
     * @param id
     */
    public void delStudentById(Integer id);

    /**
     * 修改学生
     * @param student
     */
    public void updateStudentById(Student student);

    /**
     * 查找一个学生
     * @param id
     * @return
     */
    public Student findById(Integer id);

    /**
     * 查找所有学生
     * @return
     */
    public List<Student> finAll();

    /**
     * 通过多条件更新
     * @param student
     */
    public void updateByConditions(Student student);

    /**
     * 通过多条件查询
     * @param student
     * @return
     */
    public List<Student> findByConditions(Student student);

    /**
     * 删除多个学生
     * @param list
     */
    public void batchDelStudents(List<Integer> list);

    /**
     * 查询某个学生所选的科目
     * @param id
     */
    public Student mulitFind(Integer id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    public List<Student> findByLikeName(String name);

    /**
     * 多对多
     * @param sid
     * @return
     */
    public List<Student> manyToMany(Integer sid);

    /**
     * 查询课程
     * @param id
     * @return
     */
    public StuClass findClass(Integer id);

    /**
     * 查询各省级联关系
     * @param id
     * @return
     */
    public City findCategoryLevelFirst(Integer id);

    /**
     * 查询各省级联关系Stream处理
     * @param id
     * @return
     */
    public List<CityCategory> findAllCategory(Integer id);

}
