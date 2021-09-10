package ua.com.alevel.dto;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class OwnerResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDay;
    private int age;
    private String carId;

    public OwnerResponseDto(Owner owner) {
        this.id = owner.getId();
        this.firstName = owner.getFirstName();
        this.lastName = owner.getLastName();
        this.email = owner.getEmail();
        this.birthDay = owner.getBirthDay();
        this.age = generateAge(owner);
        this.carId = owner.getCarId();
    }

    private int generateAge(final Owner owner) {
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(owner.getBirthDay().getTime());
        LocalDate today = LocalDate.now();
        LocalDate ownerBirthDay = LocalDate.of(
                birthDay.get(Calendar.YEAR + 1),
                birthDay.get(Calendar.MONTH + 1),
                birthDay.get(Calendar.DAY_OF_MONTH + 1));
        Period period = Period.between(ownerBirthDay, today);
        return period.getYears();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public int getAge() {
        return age;
    }

    public String getCarId() { return carId; }
}
