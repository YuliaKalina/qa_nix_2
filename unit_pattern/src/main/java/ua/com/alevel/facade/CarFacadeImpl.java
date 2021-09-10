package ua.com.alevel.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.CarRequestDto;
import ua.com.alevel.dto.CarResponseDto;
import ua.com.alevel.entity.Car;
import ua.com.alevel.service.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarFacadeImpl implements CarFacade {

    private final CarService carService;

    public CarFacadeImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void create(CarRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(CarRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        carService.delete(id);
    }

    @Override
    public CarResponseDto findById(String id) {
        return new CarResponseDto(carService.findById(id));
    }

    @Override
    public List<CarResponseDto> findAll() {
        return carService.findAll().stream().map(CarResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(CarRequestDto dto, String id) {
        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setColor("black");
        if (id == null) {
            carService.create(car);
        } else {
            car.setId(id);
            carService.update(car);
        }
    }
}
