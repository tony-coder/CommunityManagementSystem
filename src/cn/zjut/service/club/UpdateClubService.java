package cn.zjut.service.club;

import cn.zjut.dao.ClubDao;

public class UpdateClubService {
    public static boolean updateclub(String id, String name, String description) {
        ClubDao clubDao = new ClubDao();
        return clubDao.updateClub(id, name, description);
    }
}
