import com.solvd.transfercompany.TransferCompany;
import com.solvd.transfercompany.people.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int chooseAction = 0;
        Customer person = new Customer();
        person.fillInfo(in, person);
        TransferCompany company = new TransferCompany();
        company.fillDrivers();
        company.fillLogistician();
        company.fillTrucks();
        company.fillMinivans();
        while (chooseAction != 3) {
            System.out.println(person.getFirstName() + " " + person.getLastName() + ", добрый день!" + " Вас приветствует трансферная компания!\nВыберите действие:\n1 - Заказать трансфер для людей.\n2 - Заказать перевозку груза.\n3 - Посмотреть информацию трансферной компании.\n4 - Выход из программы.");
            chooseAction = Integer.parseInt(in.nextLine());
            switch (chooseAction) {
                case 1:
                    company.addPassengerOrder(in);
                    break;
                case 2:
                    company.addFreighterOrder(in);
                    break;
                case 3:
                    System.out.println(company);
                case 4:
                default:
                    System.out.println("Такого варианта нет.");
            }
        }
    }
}