package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        Car car1 = new Car("Car1", 111);
        Car car2 = new Car("Car2", 222);
        Car car3 = new Car("Car3", 333);
        Car car4 = new Car("Car4", 444);

        User user5 = new User("User5", "Lastname5", "user5@mail.ru");
        User user6 = new User("User6", "Lastname6", "user6@mail.ru");
        User user7 = new User("User7", "Lastname7", "user7@mail.ru");
        User user8 = new User("User8", "Lastname8", "user8@mail.ru");

        user5.setCar(car1);
        user6.setCar(car2);
        user7.setCar(car3);
        user8.setCar(car4);

        userService.add(user5);
        userService.add(user6);
        userService.add(user7);
        userService.add(user8);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("user = " + user);
        }

        User user = userService.getUserByCar("Car2", 222);
        System.out.println("userByCar = " + user);

        context.close();
    }
}
