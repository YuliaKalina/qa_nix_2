package ua.com.alevel.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.com.alevel.dao.OwnerDao;
import ua.com.alevel.entity.Owner;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

//    private final UserDao userDao = DaoFactory.getInstance().getUserDao();
    private final OwnerDao ownerDao;
//    @Autowired
//    @Qualifier("CsvUserDao")
//    private UserDao userDao;

    public OwnerServiceImpl(@Qualifier("JsonOwnerDao") OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    @Override
    public void create(Owner owner) {
        if (!ownerDao.existByEmail(owner.getEmail())) {
            ownerDao.create(owner);
        }
    }

    @Override
    public void update(Owner owner) {
        ownerDao.update(owner);
    }

    @Override
    public void delete(String id) {
        ownerDao.delete(id);
    }

    @Override
    public Owner findById(String id) {
        return ownerDao.findById(id);
    }

    @Override
    public List<Owner> findAll() {
        return ownerDao.findAll();
    }
}
