package ua.com.alevel.entity;

import java.util.Date;

public class Owner {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDay;
    private String carId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public static Builder newOwner() {
        return new Owner().new Builder();
    }

    public class Builder {

        private Builder() { }

        public Builder setId(String id) {
            Owner.this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            Owner.this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            Owner.this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            Owner.this.email = email;
            return this;
        }

        public Builder setBirthDay(Date birthDay) {
            Owner.this.birthDay = birthDay;
            return this;
        }

        public Builder setCarId(String carId) {
            Owner.this.carId = carId;
            return this;
        }

        public Owner build() {
            return Owner.this;
        }
    }
}
