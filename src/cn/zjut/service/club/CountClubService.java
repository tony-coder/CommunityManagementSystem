package cn.zjut.service.club;

import cn.zjut.bean.ClubCount;
import cn.zjut.dao.ClubDao;

import java.util.ArrayList;

public class CountClubService {
    private static ClubDao clubDao = new ClubDao();

    public static ArrayList<ClubCount> getAllClubStatistic() {
        return clubDao.getClubStatistic();
    }

    public static ArrayList<ClubCount> getClubStatisticByTerm(String term) {
        return clubDao.getClubStatisticByTerm(term);
    }

    public static ArrayList<String> getClubStatisticLabels(ArrayList<ClubCount> clubCounts) {
        ArrayList<String> labels = new ArrayList<>();
        for (ClubCount count : clubCounts) {
            if (count.getStatistic() == 0)
                continue;
            labels.add(count.getClub_name());
        }
        return labels;
    }

    public static ArrayList<Integer> getClubStatisticValue(ArrayList<ClubCount> clubCounts) {
        ArrayList<Integer> values = new ArrayList<>();
        for (ClubCount count : clubCounts) {
            if (count.getStatistic() == 0)
                continue;
            values.add(count.getStatistic());
        }
        return values;
    }
}
