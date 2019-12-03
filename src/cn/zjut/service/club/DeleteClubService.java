package cn.zjut.service.club;

import cn.zjut.dao.ClubDao;

public class DeleteClubService {
    public static boolean deleteClub(String id) {
        ClubDao clubDao = new ClubDao();
        return clubDao.deleteClub(id);
    }
}
