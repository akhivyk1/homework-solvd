import com.solvd.transfercompany.TransferCompany;
import com.solvd.transfercompany.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int chooseAction = 0;
        Customer person = new Customer();
        person.fillInfo(in, person);
        TransferCompany company = new TransferCompany();
        while (chooseAction != 4) {
            logger.info(person.getFirstName() + " " + person.getLastName() + ", добрый день!" + " Вас приветствует трансферная компания!\nВыберите действие:\n1 - Заказать трансфер для людей.\n2 - Заказать перевозку груза.\n3 - Посмотреть информацию трансферной компании.\n4 - Выход из программы.");
            chooseAction = Integer.parseInt(in.nextLine());
            switch (chooseAction) {
                case 1 -> company.addPassengerOrder(in);
                case 2 -> company.addFreighterOrder(in);
                case 3 -> System.out.println(company);
                default -> logger.info("Такого варианта нет.");
            }
        }
    }
}