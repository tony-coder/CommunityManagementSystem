package cn.zjut.dao;

import cn.zjut.bean.Club;
import cn.zjut.bean.StuCourse;
import cn.zjut.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDao implements BaseDao {
    public Student queryStuPwd(String id) {
        String sql = "select * from student where id= ?";
        Student student = new Student();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    student.setId(rst.getString("id"));
                    student.setName(rst.getString("name"));
                    student.setSex(rst.getString("sex"));
                    student.setPassword(rst.getString("password"));
                    conn.close();
                    return student;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * 更新学生密码
     *
     * @param id
     * @param password
     * @return
     */
    public boolean updateStuPwd(String id, String password) {
        String sql = "update student set password =? where id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, password);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Student> getAllStudents() {
        String sql = "select * from student";
        ArrayList<Student> students = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Student student = new Student();
                    student.setId(rst.getString("id"));
                    student.setName(rst.getString("name"));
                    student.setSex(rst.getString("sex"));
                    student.setPassword(rst.getString("password"));

                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return students;
    }

    /**
     * 根据学号搜索学生
     *
     * @param id
     * @return
     */
    public ArrayList<Student> getStudentById(String id) {
        String sql = "select * from student where id= ?";
        ArrayList<Student> students = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Student student = new Student();
                    student.setId(rst.getString("id"));
                    student.setName(rst.getString("name"));
                    student.setSex(rst.getString("sex"));
                    student.setPassword(rst.getString("password"));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return students;
    }

    /**
     * 根据名字搜索学生
     *
     * @param name
     * @return
     */
    public ArrayList<Student> getStudentByName(String name) {
        String sql = "select * from student where name= ?";
        ArrayList<Student> students = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Student student = new Student();
                    student.setId(rst.getString("id"));
                    student.setName(rst.getString("name"));
                    student.setSex(rst.getString("sex"));
                    student.setPassword(rst.getString("password"));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return students;
    }


    /**
     * 根据学号姓名搜素学生
     */
    public ArrayList<Student> getStudent(String id, String name) {
        String sql = "select * from student where id =? and name= ?";
        ArrayList<Student> students = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Student student = new Student();
                    student.setId(rst.getString("id"));
                    student.setName(rst.getString("name"));
                    student.setSex(rst.getString("sex"));
                    student.setPassword(rst.getString("password"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return students;
    }

    /**
     * 插入学生
     */
    public boolean insertStudent(String id, String name, String sex, String password) {
        String sql = "insert into student value(?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, sex);
            pstmt.setString(4, password);

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据学号删除学生
     */
    public boolean deleteStudent(String id) {
        String sql1 = "delete from studentsclubs where stu_id =?";
        String sql2 = "delete from studentscourses where stu_id= ?";
        String sql3 = "delete from student where id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             PreparedStatement pstmt2 = conn.prepareStatement(sql2);
             PreparedStatement pstmt3 = conn.prepareStatement(sql3)) {
            pstmt1.setString(1, id);
            pstmt1.executeUpdate();

            pstmt2.setString(1, id);
            pstmt2.executeUpdate();

            pstmt3.setString(1, id);
            pstmt3.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新学生信息
     */
    public boolean updateStudent(String id, String name, String sex) {
        String sql = "update student set name= ? ,sex= ? where id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, sex);
            pstmt.setString(3, id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 插入学生课程
     *
     * @param stuId
     * @param courseId
     * @return
     */
    public boolean insertStuCourse(String stuId, String courseId) {
        String sql1 = "insert into studentscourses(stu_id,cour_id) values(?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {
            pstmt1.setString(1, stuId);
            pstmt1.setString(2, courseId);
            pstmt1.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 插入学生社团
     *
     * @param stuId
     * @param clubId
     * @return
     */
    public boolean insertStuClub(String stuId, String clubId, String term) {
        //学生选课时默认加入该课对应的社团
//        String sql1="insert into studentsclubs(stu_id, club_id, term) select stu_id,club_id"
        String sql1 = "insert into studentsclubs(stu_id, club_id, term) values (?,?,?)";
        String sql2 = "insert into studentsclubs values (?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {

            pstmt1.setString(1, stuId);
            pstmt1.setString(2, clubId);
            pstmt1.setString(3, term);
            pstmt1.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取课程所属社团
     *
     * @param courseId
     * @return
     */
    public ArrayList<Club> getCourseClub(String courseId) {
        String sql = "select * from course,club where course.id =? and course.club_id=club.id";
        ArrayList<Club> clubs = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseId);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Club club = new Club();
                    club.setId(rst.getString("club.id"));
                    club.setName(rst.getString("club.name"));
                    club.setDescription(rst.getString("club.description"));
                    clubs.add(club);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return clubs;
    }

    /**
     * 获取学生所属社团
     *
     * @param stuId
     * @return
     */
    public ArrayList<Club> getStuClub(String stuId) {
        String sql = "select * from studentsclubs,club where studentsclubs.stu_id = ? and studentsclubs.club_id=club.id";
        ArrayList<Club> clubs = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, stuId);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Club club = new Club();
                    club.setId(rst.getString("id"));
                    club.setName(rst.getString("name"));
                    club.setDescription(rst.getString("description"));
                    clubs.add(club);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return clubs;
    }

    /**
     * 获取学生此学期所属社团
     *
     * @param stuId
     * @param term
     * @return
     */
    public ArrayList<Club> getStuClubThisTerm(String stuId, String term) {
        String sql = "select * from studentsclubs,club where studentsclubs.stu_id = ? and studentsclubs.club_id=club.id and studentsclubs.term=?";
        ArrayList<Club> clubs = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, stuId);
            pstmt.setString(2, term);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Club club = new Club();
                    club.setId(rst.getString("id"));
                    club.setName(rst.getString("name"));
                    club.setDescription(rst.getString("description"));
                    clubs.add(club);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return clubs;
    }

    /**
     * 获取所有学生选课情况
     *
     * @return
     */
    public ArrayList<StuCourse> getAllStuCourses() {
        String sql = "select * from studentscourses,student,course where student.id=studentscourses.stu_id and course.id=studentscourses.cour_id";
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    StuCourse stuCourse = new StuCourse();
                    stuCourse.setStu_id(rst.getString("stu_id"));
                    stuCourse.setStu_name(rst.getString("student.name"));
                    stuCourse.setCourse_id(rst.getString("course.id"));
                    stuCourse.setCourse_name(rst.getString("course.name"));
                    stuCourse.setTerm(rst.getString("term"));
                    stuCourses.add(stuCourse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return stuCourses;
    }

    /**
     * 删除学生选课信息
     *
     * @param studentId
     * @param courseId
     * @return
     */
    public boolean deleteStuCourse(String studentId, String courseId, String term) {
        //String sql1 = "delete from studentsclubs where stu_id = ? and club_id in (select club_id from studentscourses,course where studentscourses.cour_id = ? and studentscourses.cour_id=course.id) ";
        String sql1 = "delete from studentscourses where stu_id =? and cour_id =?";
        String sql2 = "select studentscourses.cour_id from studentscourses,clubscourses where clubscourses.course_id = ? and studentscourses.stu_id = ? and studentscourses.cour_id=clubscourses.club_id";
        String sql3 = "delete from studentsclubs where stu_id=? and term= ? and club_id in (select club_id from course where course.id =?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             PreparedStatement pstmt2 = conn.prepareStatement(sql2);
             PreparedStatement pstmt3 = conn.prepareStatement(sql3)) {
            pstmt1.setString(1, studentId);
            pstmt1.setString(2, courseId);
            pstmt1.executeUpdate();

            pstmt2.setString(1, courseId);
            pstmt2.setString(2, studentId);
            try (ResultSet rse = pstmt2.executeQuery()) {
                if (!rse.next()) {
                    pstmt3.setString(1, studentId);
                    pstmt3.setString(2, term);
                    pstmt3.setString(3, courseId);
                    pstmt3.executeUpdate();
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<StuCourse> queryStuCourse(String term, String stuName) {
        String sql = "select * from studentscourses,student,course where student.name = ? and course.term = ? and student.id=studentscourses.stu_id and course.id=studentscourses.cour_id";
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, stuName);
            pstmt.setString(2, term);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    StuCourse stuCourse = new StuCourse();
                    stuCourse.setStu_id(rst.getString("stu_id"));
                    stuCourse.setStu_name(rst.getString("student.name"));
                    stuCourse.setCourse_id(rst.getString("course.id"));
                    stuCourse.setCourse_name(rst.getString("course.name"));
                    stuCourse.setTerm(rst.getString("term"));
                    stuCourses.add(stuCourse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return stuCourses;
    }

    public ArrayList<StuCourse> queryStuCourseByTerm(String term) {
        String sql = "select * from studentscourses,student,course where course.term = ? and student.id=studentscourses.stu_id and course.id=studentscourses.cour_id";
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    StuCourse stuCourse = new StuCourse();
                    stuCourse.setStu_id(rst.getString("stu_id"));
                    stuCourse.setStu_name(rst.getString("student.name"));
                    stuCourse.setCourse_id(rst.getString("course.id"));
                    stuCourse.setCourse_name(rst.getString("course.name"));
                    stuCourse.setTerm(rst.getString("term"));
                    stuCourses.add(stuCourse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return stuCourses;
    }

    public ArrayList<StuCourse> queryStuCourseByName(String name) {
        String sql = "select * from studentscourses,student,course where student.name = ? and student.id=studentscourses.stu_id and course.id=studentscourses.cour_id";
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    StuCourse stuCourse = new StuCourse();
                    stuCourse.setStu_id(rst.getString("stu_id"));
                    stuCourse.setStu_name(rst.getString("student.name"));
                    stuCourse.setCourse_id(rst.getString("course.id"));
                    stuCourse.setCourse_name(rst.getString("course.name"));
                    stuCourse.setTerm(rst.getString("term"));
                    stuCourses.add(stuCourse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return stuCourses;
    }

    /**
     * 获取指定学生在某一社团里的已选课程
     */
    public ArrayList<StuCourse> getAllSelectedCourseInClub(String stuId, String clubId, String term) {
        String sql = "select * from studentscourses,student,course,club where studentscourses.stu_id = ? and club.id = ? and studentscourses.stu_id=student.id and studentscourses.cour_id=course.id and course.club_id=club.id and course.term= ?";
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, stuId);
            pstmt.setString(2, clubId);
            pstmt.setString(3, term);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    StuCourse stuCourse = new StuCourse();
                    stuCourse.setStu_id(rst.getString("stu_id"));
                    stuCourse.setStu_name(rst.getString("student.name"));
                    stuCourse.setCourse_id(rst.getString("course.id"));
                    stuCourse.setCourse_name(rst.getString("course.name"));
                    stuCourse.setTerm(rst.getString("term"));
                    stuCourses.add(stuCourse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return stuCourses;
    }

    /**
     * 获取指定学生在某一社团里的未选课程
     */
    public ArrayList<StuCourse> getUnselectedCourseInClub(String stuId, String clubId, String term) {
        //String sql = "select * from studentscourses,student,course,club where studentscourses.stu_id=student.id and studentscourses.cour_id=course.id and course.club_id =club.id and course.id in (select clubscourses.course_id from clubscourses where clubscourses.club_id = ? and clubscourses.course_id not in (select cour_id from studentscourses where stu_id = ?))";
        String sql = "select * from clubscourses,course,club where course.term= ? and clubscourses.course_id=course.id and clubscourses.club_id=club.id and course.id in (select clubscourses.course_id from clubscourses where clubscourses.club_id = ? and clubscourses.course_id not in (select cour_id from studentscourses where stu_id = ?))";
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            pstmt.setString(2, clubId);
            pstmt.setString(3, stuId);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    StuCourse stuCourse = new StuCourse();
                    stuCourse.setCourse_id(rst.getString("course.id"));
                    stuCourse.setCourse_name(rst.getString("course.name"));
                    stuCourse.setTerm(rst.getString("term"));
                    stuCourses.add(stuCourse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return stuCourses;
    }
}
