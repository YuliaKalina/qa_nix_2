package ua.com.alevel.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.OwnerRequestDto;
import ua.com.alevel.dto.OwnerResponseDto;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.service.CarService;
import ua.com.alevel.service.OwnerService;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerFacadeImpl implements OwnerFacade {

    private final OwnerService ownerService;
    private final CarService carService;

    public OwnerFacadeImpl(OwnerService ownerService, CarService carService) {
        this.ownerService = ownerService;
        this.carService = carService;
    }

    @Override
    public void create(OwnerRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(OwnerRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        carService.delete(ownerService.findById(id).getCarId());
        ownerService.delete(id);
    }

    @Override
    public OwnerResponseDto findById(String id) {
        return new OwnerResponseDto(ownerService.findById(id));
    }

    @Override
    public List<OwnerResponseDto> findAll() {
//        List<User> users = userService.findAll();
//        List<UserResponseDto> dtoList = new ArrayList<>();
//        for (User user : users) {
//            dtoList.add(new UserResponseDto(user));
//        }
//        return dtoList;
        return ownerService.findAll().stream().map(OwnerResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(OwnerRequestDto dto, String id) {
        Owner owner = new Owner();
        owner.setFirstName(dto.getFirstName());
        owner.setLastName(dto.getLastName());
        owner.setEmail(dto.getEmail());
        owner.setBirthDay(dto.getBirthDay());
        owner.setCarId(dto.getCarId());
        if (id == null) {
            ownerService.create(owner);
        } else {
            owner.setId(id);
            ownerService.update(owner);
        }
    }
}
//        User user = User.newUser()
//                .setFirstName(dto.getFirstName())
//                .setLastName(dto.getLastName())
//                .setEmail(dto.getEmail())
//                .setBirthDay(dto.getBirthDay())
//                .build();
