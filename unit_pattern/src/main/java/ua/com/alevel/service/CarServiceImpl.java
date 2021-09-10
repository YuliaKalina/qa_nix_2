package ua.com.alevel.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CarDao;
import ua.com.alevel.entity.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

//    private final UserDao userDao = DaoFactory.getInstance().getUserDao();
    private final CarDao carDao;
//    @Autowired
//    @Qualifier("CsvUserDao")
//    private UserDao userDao;

    public CarServiceImpl(@Qualifier("JsonCarDao") CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public void create(Car car) {
        if (!carDao.existByBrand(car.getBrand())) {
            carDao.create(car);
        }
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Override
    public void delete(String id) {
        carDao.delete(id);
    }

    @Override
    public Car findById(String id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }
}
