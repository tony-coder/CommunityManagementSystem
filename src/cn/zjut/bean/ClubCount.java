package cn.zjut.bean;

/**
 * 社团信息统计
 */
public class ClubCount {
    private String club_id;     //社团号
    private String club_name;   //社团名称
    private int statistic;      //统计信息

    public ClubCount() {
    }

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public int getStatistic() {
        return statistic;
    }

    public void setStatistic(int statistic) {
        this.statistic = statistic;
    }
}
