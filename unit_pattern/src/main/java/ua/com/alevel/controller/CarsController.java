package ua.com.alevel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.CarRequestDto;
import ua.com.alevel.dto.CarResponseDto;
import ua.com.alevel.dto.ResponseContainer;
import ua.com.alevel.facade.CarFacade;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    private final CarFacade carFacade;

    public CarsController(CarFacade carFacade) {
        this.carFacade = carFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody CarRequestDto dto) {
        carFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody CarRequestDto dto, @PathVariable String id) {
        carFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        carFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<CarResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(carFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<CarResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(carFacade.findAll()));
    }
}
