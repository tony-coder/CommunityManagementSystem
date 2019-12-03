package cn.zjut.dao;

import cn.zjut.bean.Club;
import cn.zjut.bean.ClubCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClubDao implements BaseDao {

    /**
     * 根据社团名字进行模糊查询
     *
     * @param name
     * @return
     */
    public ArrayList<Club> findClubByNamefuzzy(String name) {
        String sql = "select * from club where name like ?";
        ArrayList<Club> clubs = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
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
     * 根据社团名字搜索社团
     *
     * @return
     */
    public ArrayList<Club> getClubByName(String name) {
        String sql = "select * from club where name = ?";
        ArrayList<Club> clubs = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
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
     * 根据社团id搜索社团
     */
    public ArrayList<Club> getClubBuId(String id) {
        String sql = "select * from club where id = ?";
        ArrayList<Club> clubs = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
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
     * 根据社团名字和社团id搜索社团
     */
    public ArrayList<Club> getClub(String id, String name) {
        String sql = "select * from club where id = ? and name= ?";
        ArrayList<Club> clubs = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
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
     * 插入社团
     *
     * @param id
     * @param name
     * @param descrip
     * @return
     */
    public boolean insertClub(String id, String name, String descrip) {
        String sql = "insert into club  value(?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, descrip);

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除社团
     *
     * @param id
     * @return
     */
    public boolean deleteClub(String id) {
        String sql1 = "delete from clubscourses where club_id =?";  //删除社团对应的课程（这个表可能是多余的，考虑优化一下）
        String sql2 = "delete from studentsclubs where club_id =?"; //删除社团对应的学生
        String sql3 = "delete from course where club_id = ?";       //删除从属于该社团的课程
        String sql4 = "delete from club where id= ?";               //删除社团

        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             PreparedStatement pstmt2 = conn.prepareStatement(sql2);
             PreparedStatement pstmt3 = conn.prepareStatement(sql3);
             PreparedStatement pstmt4 = conn.prepareStatement(sql4)) {
            // 首先删除关联表clubscourses中与所要删除的club对应的课程，因为外键约束
            pstmt1.setString(1, id);
            pstmt1.executeUpdate();
            // 删除关联表studentsclubs中club对应的记录
            pstmt2.setString(1, id);
            pstmt2.executeUpdate();
            //删除外键关联的course表中的记录
            pstmt3.setString(1, id);
            pstmt3.executeUpdate();
            // 删除club
            pstmt4.setString(1, id);
            pstmt4.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新社团信息
     */
    public boolean updateClub(String id, String name, String description) {
        String sql = "update club set name = ? ,description = ? where id =?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setString(3, id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取所有社团的成员人数统计信息
     *
     * @return
     */
    public ArrayList<ClubCount> getClubStatistic() {
        String sql = "select club.id,club.name,count(stu_id) as statistic from club,studentsclubs where club.id=studentsclubs.club_id group by club.id";
        ArrayList<ClubCount> clubCounts = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCount clubCount = new ClubCount();
                    clubCount.setClub_id(rst.getString("club.id"));
                    clubCount.setClub_name(rst.getString("club.name"));
                    clubCount.setStatistic(rst.getInt("statistic"));
                    clubCounts.add(clubCount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return clubCounts;
    }

    /**
     * 获取某个学期所有社团的成员人数统计信息
     *
     * @param term
     * @return
     */
    public ArrayList<ClubCount> getClubStatisticByTerm(String term) {
        String sql = "select club.id,club.name,count(studentsclubs.stu_id) as statistic from club,studentsclubs,studentscourses,course where studentsclubs.stu_id=studentscourses.stu_id and studentscourses.cour_id=course.id and course.club_id=club.id and studentsclubs.term=course.term and studentsclubs.term= ? and club.id=studentsclubs.club_id group by club.id";
        ArrayList<ClubCount> clubCounts = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, term);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    ClubCount clubCount = new ClubCount();
                    clubCount.setClub_id(rst.getString("club.id"));
                    clubCount.setClub_name(rst.getString("club.name"));
                    clubCount.setStatistic(rst.getInt("statistic"));
                    clubCounts.add(clubCount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return clubCounts;
    }
}
