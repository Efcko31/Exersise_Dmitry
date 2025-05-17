package ru.PhoneDirectory.PhoneDirectoryRepository;

import ru.PhoneDirectory.Person;

import java.sql.SQLException;
import java.util.List;

import static ru.PhoneDirectory.PhoneDirectoryRepository.PersonsForPhoneDirectory.phoneDirectory;

public class PDMain {
    public static void main(String[] args) {
//        PhoneDirectoryRepository repository = new PhoneDirectoryRepository();
//        phoneDirectory.forEach(p -> {
//            try {
//                repository.addPerson(p);
//                System.out.println(p.getFirstName() + p.getLastName() + " - добывлен в БД");
//            } catch (SQLException e) {
//                System.out.println("Ошибка: " + e.getMessage());;
//            }
//        });

        PhoneDirectoryRepository repository = new PhoneDirectoryRepository();
        try {
            List<Person> whoLiveInBelgorod = repository.findEveryoneWhoLivesInTheCityXUsingSQL("Москва");

            if (whoLiveInBelgorod.isEmpty()) {
                System.out.println("В этом городе никто не живёт 😢");
            } else {
                System.out.println("Найдены жители:");
                for (Person p : whoLiveInBelgorod) {
                    System.out.printf("%s %s: %s\n",
                            p.getFirstName(), p.getLastName(), p.getPhoneNumber());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
