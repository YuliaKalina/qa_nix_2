package ua.com.alevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
public class Planets implements Planet {
    private String name;
    private BigDecimal mass;
    private BigDecimal diameter;

    @Generated
    public Planets (String name, double mass, double diameter) {
        this.name = name;
        this.mass = BigDecimal.valueOf(mass);
        this.diameter = BigDecimal.valueOf(diameter);
    }

    @Override
    public BigDecimal getVelocity() {
        BigDecimal radius = diameter.divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
        MathContext target = new MathContext(5);
        return Physics.GRAVITATION.multiply(mass.divide(radius.pow(2), target));
    }

}
