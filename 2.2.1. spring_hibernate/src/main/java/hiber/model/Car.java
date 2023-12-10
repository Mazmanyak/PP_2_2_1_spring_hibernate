package hiber.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
}
