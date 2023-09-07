package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {


   private final UserDao userDao;

   private final CarDao carDao;

   public UserServiceImp(UserDao userDao, CarDao carDao) {
      this.userDao = userDao;
      this.carDao = carDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User getByCarSeriesAndModel(Long series, String model) {
      Car car = carDao.getBySeriesAndModel(series, model);
      List<User> users = userDao.listUsers();

      return users.stream().filter(el -> el.getCar().getSeries().compareTo(car.getSeries())==0 ).collect(Collectors.toList()).get(0);
   }

}
