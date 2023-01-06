import com.solvd.transfercompany.TransferCompany;
import com.solvd.transfercompany.people.Customer;
import com.solvd.transfercompany.people.Logistician;
import com.solvd.transfercompany.people.PeopleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws PeopleException, NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Scanner in = new Scanner(System.in);
        int chooseAction = 0;
        Customer person = new Customer();
//        person.fillInfo(in, person);
        person.setFirstName("Паша");
        person.setLastName("РЕГИНОВ");
        person.setCash(121);
        TransferCompany company = new TransferCompany();
        while (chooseAction != 7) {
            logger.info(person.getFirstName() + " " + person.getLastName() + ", добрый день!" + " Вас приветствует трансферная компания!\nВыберите действие:\n1 - Заказать трансфер для людей.\n2 - Заказать перевозку груза.\n3 - Посмотреть информацию трансферной компании.\n4 - Выход из программы.");
            chooseAction = Integer.parseInt(in.nextLine());
            switch (chooseAction) {
                case 1 -> company.addPassengerOrder(in);
                case 2 -> company.addFreighterOrder(in);
                case 3 -> logger.info(company);
                case 4 -> {
                    Upperable<Object> str = a -> a.toString().toUpperCase();
                    logger.info(str.upper(person.getFirstName()));
                    Belowable<Object> down = a -> a.toString().toLowerCase();
                    logger.info(down.below(person.getLastName()));
                    ISqrt<Object> math = a -> Math.sqrt((Double) a);
                    logger.info(math.sqrt(person.getCash()));
                }
                case 5 -> {
                    // sorted by salary
                    company.getAllLogisticans().stream()
                            .sorted(Comparator.comparing(Logistician::getSalary))
                            .collect(Collectors.toList())
                            .forEach(logger::info);
                    // average salary
                    logger.info(company.getAllLogisticans().stream()
                            .mapToDouble(Logistician::getSalary)
                            .summaryStatistics()
                            .getAverage());
                    // Logistician salary > 500, lastname != 'Ш'
                    company.getAllLogisticans().stream()
                            .filter(a -> (a.getLastName().charAt(0) != 'Ш'))
                            .filter(a -> (a.getSalary() > 500))
                            .collect(Collectors.toList())
                            .forEach(logger::info);
                    // isAllCategory
                    logger.info(company.getAllDrivers().stream()
                            .allMatch(driver -> driver.getDrivingCategory() == 'E'));
                    // max first name
                    logger.info(company.getAllDrivers().stream()
                            .mapToInt((value) -> {
                                return value.getFirstName().length();
                            })
                            .summaryStatistics()
                            .getMax());
                }
                case 6 -> {
                    Customer c = new Customer();
                    Class<? extends Customer> obj = c.getClass();
                    logger.info("ClassName - " + obj.getName());
                    Constructor<? extends Customer> constructor = obj.getConstructor();
                    logger.info("Construstors - " + constructor.getName());
                    Method[] methods = obj.getMethods();
                    for (Method method : methods)
                        logger.info(method.getName());
                    logger.info("\n\n\n");
                    Field[] fields = obj.getDeclaredFields();
                    for (Field f : fields)
                        logger.info(f.getName());
                    logger.info("\n\n\n");
                    Method method1 = obj.getMethod("setPhoneNumber", String.class);
                    method1.invoke(c, "+375296156857");
                    logger.info(c.getPhoneNumber());
                }
                default -> logger.info("Такого варианта нет.");
            }
        }
    }

    @FunctionalInterface
    public interface Upperable<T> {
        String upper(T t);
    }

    @FunctionalInterface
    public interface Belowable<T> {
        String below(T t);
    }

    @FunctionalInterface
    public interface ISqrt<T> {
        double sqrt(T t);
    }
}