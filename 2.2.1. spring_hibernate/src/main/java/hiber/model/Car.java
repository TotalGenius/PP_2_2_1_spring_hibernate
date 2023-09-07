package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "cars")
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "series")
    private Long series;
    @Column(name = "model")
    private String model;


    public Car() {

    }

    public Car(Long series, String model) {
        this.series = series;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }
}
