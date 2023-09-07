package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car getBySeriesAndModel(Long series, String model) {
        Car car = sessionFactory.getCurrentSession().createQuery("FROM cars c where c.series = :series and c.model = :model", Car.class)
                .setParameter("series", series)
                .setParameter("model", model)
                .getResultList().get(0);
        return car;
    }
}
