package ua.com.alevel.facade;

import ua.com.alevel.dto.CarRequestDto;
import ua.com.alevel.dto.CarResponseDto;
import ua.com.alevel.dto.OwnerRequestDto;
import ua.com.alevel.dto.OwnerResponseDto;

import java.util.List;

public interface CarFacade {
    void create(CarRequestDto dto);
    void update(CarRequestDto dto, String id);
    void delete(String id);
    CarResponseDto findById(String id);
    List<CarResponseDto> findAll();
}
