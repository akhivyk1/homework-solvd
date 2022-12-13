import com.solvd.transfercompany.TransferCompany;
import com.solvd.transfercompany.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int chooseAction = 0;
        Customer person = new Customer();
//        person.fillInfo(in, person);
        TransferCompany company = new TransferCompany();
        while (chooseAction != 5) {
            logger.info(person.getFirstName() + " " + person.getLastName() + ", добрый день!" + " Вас приветствует трансферная компания!\nВыберите действие:\n1 - Заказать трансфер для людей.\n2 - Заказать перевозку груза.\n3 - Посмотреть информацию трансферной компании.\n4 - Выход из программы.");
            chooseAction = Integer.parseInt(in.nextLine());
            switch (chooseAction) {
                case 1 -> company.addPassengerOrder(in);
                case 2 -> company.addFreighterOrder(in);
                case 3 -> System.out.println(company);
                case 4 -> {
                    String text = Files.readString(Paths.get("D:\\Dev\\Solvd\\homework-solvd\\src\\main\\java\\text.txt"));
                    List<String> words = new ArrayList<>();
                    for (String s : text.split(" ")) {
                        words.add(s.replaceAll("[^a-zA-Z]", "").toLowerCase());
                    }
                    Map<String, Long> frequency = countDuplicates(words);
                    System.out.println(frequency);
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
}