package ua.com.alevel.config;

import ua.com.alevel.dao.*;
import ua.com.alevel.util.ResourceUtil;

import java.util.Map;

public class DaoFactory {

    private static DaoFactory instance;
    private OwnerDao ownerDao;
    private CarDao carDao;
    private DaoType daoType;

    private DaoFactory() { }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public OwnerDao getOwnerDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV : {
                if (ownerDao == null) {
                    ownerDao = new CsvOwnerDao();
                }
            } break;
            case JSON : {
                if (ownerDao == null) {
                    ownerDao = new JsonOwnerDao();
                }
            } break;
        }
        return ownerDao;
    }

    public OwnerDao getCarDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV : {
                if (carDao == null) {
                    carDao = null;
                }
            } break;
            case JSON : {
                if (carDao == null) {
                    carDao = new JsonCarDao();
                }
            } break;
        }
        return ownerDao;
    }
}
