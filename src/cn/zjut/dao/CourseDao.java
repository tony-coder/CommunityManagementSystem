package cn.zjut.dao;

import cn.zjut.bean.ClubCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseDao implements BaseDao {

    /**
     * 根据课程名字进行模糊查询
     *
     * @param name
     * @return
     */
    public ArrayList<ClubCourse> findCourseByNamefuzzy(String name) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where course.name like ? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return courses;
    }

    /**
     * 根据课程号进行查询
     *
     * @param id
     * @return
     */
    public ArrayList<ClubCourse> getCourseByID(String id) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where course.id = ? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    /**
     * 根据教师名字进行查询
     *
     * @param teacher
     * @return
     */
    public ArrayList<ClubCourse> getCourseByTeacher(String teacher) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where teacher =? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, teacher);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    /**
     * 根据学期进行查询
     *
     * @param term
     * @return
     */
    public ArrayList<ClubCourse> getCourseByTerm(String term) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where term = ? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    public ArrayList<ClubCourse> getCourseByTermName(String term, String name) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where term = ? and course.name =? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            pstmt.setString(2, name);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    public ArrayList<ClubCourse> getCourseByTermId(String term, String id) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where term = ? and course.id =? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            pstmt.setString(2, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    public ArrayList<ClubCourse> getCourseByTermTeacher(String term, String teacher) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where term = ? and teacher =? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            pstmt.setString(2, teacher);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    public ArrayList<ClubCourse> getCourseByClub(String clubId) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where club_id = ? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, clubId);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    public ArrayList<ClubCourse> getCourseByTermClub(String term, String clubId) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where term = ? club_id = ? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            pstmt.setString(2, clubId);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    public ArrayList<ClubCourse> getCourse(String id, String name, String teacher, String term, String clubId) {
        String sql = "select course.id,course.name,teacher,term,club.name from course,club where course.id = ? and course.name = ? and teacher = ? and term = ? and club_id= ? and course.club_id=club.id";
        ArrayList<ClubCourse> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, teacher);
            pstmt.setString(4, term);
            pstmt.setString(5, clubId);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCourse course = new ClubCourse();
                    course.setId(rst.getString("course.id"));
                    course.setName(rst.getString("course.name"));
                    course.setTeacher(rst.getString("teacher"));
                    course.setTerm(rst.getString("term"));
                    course.setClubName(rst.getString("club.name"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    /**
     * 插入课程
     *
     * @param id
     * @param name
     * @param teacher
     * @param term
     * @return
     */
    public boolean insertCourse(String id, String name, String teacher, String term, String clubId) {
        String sql1 = "insert into course value(?,?,?,?,?)";
        String sql2 = "insert into clubscourses(club_id, course_id) value(?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             PreparedStatement pstmt2=conn.prepareStatement(sql2)) {
            pstmt1.setString(1, id);
            pstmt1.setString(2, name);
            pstmt1.setString(3, teacher);
            pstmt1.setString(4, term);
            pstmt1.setString(5, clubId);
            pstmt1.executeUpdate();

            pstmt2.setString(1, clubId);
            pstmt2.setString(2, id);
            pstmt2.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除课程
     *
     * @param id
     * @return
     */
    public boolean deleteCourse(String id) {
//        String sql1 = "delete from clubscourses where course_id = ?";
        String sql1 = "delete from studentscourses where cour_id= ?";
        String sql2 = "delete from course where id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             PreparedStatement pstmt2 = conn.prepareStatement(sql2);) {
            pstmt1.setString(1, id);
            pstmt1.executeUpdate();

            pstmt2.setString(1, id);
            pstmt2.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCourse(String id, String name, String teacher, String term, String clubId) {
        String sql = "update course set name =?,teacher =?,term =? ,club_id=? where id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, teacher);
            pstmt.setString(3, term);
            pstmt.setString(4, clubId);
            pstmt.setString(5, id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
