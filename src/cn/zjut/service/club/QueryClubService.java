package cn.zjut.service.club;

import cn.zjut.bean.Club;
import cn.zjut.dao.ClubDao;

import java.util.ArrayList;

public class QueryClubService {
    private static ClubDao clubDao = new ClubDao();

    public static ArrayList<Club> queryAllClub() {
        return clubDao.findClubByNamefuzzy("");
    }

    public static ArrayList<Club> queryClubByName(String name) {
        return clubDao.findClubByNamefuzzy(name);
    }

    public static ArrayList<Club> queryClubById(String id) {
        ArrayList<Club> clubs = new ArrayList<>();
        clubs = clubDao.getClubBuId(id);

        if (clubs.size() == 0) {
            return null;
        }
        return clubs;
    }

    public static ArrayList<Club> queryClub(String id, String name) {
        ArrayList<Club> clubs = new ArrayList<>();
        clubs = clubDao.getClubBuId(id);

        if (clubs.size() == 0) {
            return null;
        }
        return clubs;
    }
}
