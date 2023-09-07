package hiber.dao;

import hiber.model.Car;

public interface CarDao {
    Car getBySeriesAndModel(Long series, String model);
}
