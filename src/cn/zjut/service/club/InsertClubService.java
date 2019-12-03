package cn.zjut.service.club;

import cn.zjut.dao.ClubDao;

public class InsertClubService {
    public static boolean insertClub(String id, String name, String descrip) {
        ClubDao clubDao = new ClubDao();
        return clubDao.insertClub(id, name, descrip);
    }
}
