import com.solvd.transfercompany.TransferCompany;
import com.solvd.transfercompany.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.*;
import java.util.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int chooseAction = 0;
        Customer person = new Customer();
//        person.fillInfo(in, person);
        TransferCompany company = new TransferCompany();
        while (chooseAction != 6) {
            logger.info(person.getFirstName() + " " + person.getLastName() + ", добрый день!" + " Вас приветствует трансферная компания!\nВыберите действие:\n1 - Заказать трансфер для людей.\n2 - Заказать перевозку груза.\n3 - Посмотреть информацию трансферной компании.\n4 - Выход из программы.");
            chooseAction = Integer.parseInt(in.nextLine());
            switch (chooseAction) {
                case 1 -> company.addPassengerOrder(in);
                case 2 -> company.addFreighterOrder(in);
                case 3 -> logger.info(company);
                case 4 -> {
                    String text = Files.readString(Paths.get("D:\\Dev\\Solvd\\homework-solvd\\src\\main\\java\\text.txt"));
                    List<String> words = new ArrayList<>();
                    for (String s : text.split(" ")) {
                        words.add(s.replaceAll("[^a-zA-Z]", "").toLowerCase());
                    }
                    Map<String, Long> frequency = countDuplicates(words);
                    Files.write(Paths.get("D:\\Dev\\Solvd\\homework-solvd\\src\\main\\java\\countWords.txt"), frequency.toString().getBytes());
                }
                case 5 -> {
                    DoubleToIntFunction doubleToInt = a -> (int)a;
                    IntFunction funcInt = a -> a / 2;
                    logger.info("Entry double value: ");
                    double value = Double.parseDouble(in.nextLine());
                    int result = doubleToInt.applyAsInt(value);
                    logger.info("Convert to int: " + result);
                    logger.info("Entered value in half:" + funcInt.apply(result));
                }
                default -> logger.info("Такого варианта нет.");
            }
        }
    }

    public static Map<String, Long> countDuplicates(List<String> inputList) {
        Map<String, Long> map = new HashMap<>();
        for (String v : inputList) {
            map.merge(v, 1L, Long::sum);
        }
        return map;
    }

    @FunctionalInterface
    public interface Upperable<T> {
        String upper(T t);
    }
    @FunctionalInterface
    public interface IClassName<T> {
        String getNameClass(T t);
    }
    @FunctionalInterface
    public interface IString<T> {
        String getToString(T t);
    }
}