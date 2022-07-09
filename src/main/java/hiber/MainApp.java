package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User urka = new User("Yuri", "Gumelevskii", "gum@mail.ru");
      User deniska = new User("Denis", "Muzika", "muz@mail.ru");
      User karinka = new User("Karina", "Gumelevskaia", "gumina@mail.ru");
      User marinka = new User("Marina", "Randomnaia", "rand@mail.ru");

      Car urka_car = new Car("bike", 1);
      Car den_car = new Car("lamborghini", 2);
      Car karina_car = new Car("Taksi", 3);
      Car marina_car = new Car("Samokat", 4);

      userService.add(urka.setCar(urka_car).setUser(urka));
      userService.add(deniska.setCar(den_car).setUser(deniska));
      userService.add(karinka.setCar(karina_car).setUser(karinka));
      userService.add(marinka.setCar(marina_car).setUser(marinka));

      for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getCar());
      }
      System.out.println();

      System.out.println("Получим юзера, указав машину: " + userService.getUserByCar("bike", 1));

      context.close();

   }
}

