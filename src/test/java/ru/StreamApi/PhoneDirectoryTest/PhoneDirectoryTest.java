package ru.StreamApi.PhoneDirectoryTest;


import org.junit.jupiter.api.Test;
import ru.PhoneDirectory.Person;
import ru.PhoneDirectory.PhoneDirectory;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.PhoneDirectory.PhoneDirectory.*;

public class PhoneDirectoryTest {


    //1)найти всех людей проживающих в городе n, и вернуть их номер телефона и фио
    @Test
    void findEveryoneWhoLivesInTheCityTest() {
        assertEquals("+7-111-111-11-11",
                findEveryoneWhoLivesInTheCityX("Москва",phoneDirectory).getFirst().getPhoneNumber());
        assertEquals("+7-777-777-77-77",
                findEveryoneWhoLivesInTheCityX("Москва",phoneDirectory).getLast().getPhoneNumber());
        assertEquals("+7-222-222-22-22",
                findEveryoneWhoLivesInTheCityX("Санкт-Петербург",phoneDirectory).getFirst().getPhoneNumber());
        assertEquals("+7-888-888-88-88",
                findEveryoneWhoLivesInTheCityX("Санкт-Петербург",phoneDirectory).getLast().getPhoneNumber());

//        assertEquals(List.of(
//                        new Person("Николай", "Иванов", "Васильевич", "+7-111-111-11-11"),
//                        new Person("Александр", "Алекснадров", "Александрович", "+7-444-444-44-44"),
//                        new Person("Олег ", "Олегов", "", "+7-777-777-77-77")),
//                findEveryoneWhoLivesInTheCityX("Москва", phoneDirectory));
//        assertEquals(List.of(
//                        new Person("Петр", "Петров", "Петрович", "+7-222-222-22-22"),
//                        new Person("Илья", "Ильёв", "Ильич", "+7-333-333-33-33"),
//                        new Person("Алексей", "Алексеев", "", "+7-888-888-88-88")),
//                findEveryoneWhoLivesInTheCityX("Санкт-Петербург", phoneDirectory));
    }

    public List<Person> findEveryoneWhoLivesInTheCityX(
            String cityN, List<Person> phoneDirectory) {
        return phoneDirectory.stream()
                .filter(p -> p.getCityOfResidence().equals(cityN))
                .map(s -> new Person(s.getFirstName(), s.getLastName(), s.getPatronymic(), s.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    //2)найти людей без отчества, и вернуть место их проживания, фио, номер телефона
    @Test
    void findPeopleWithoutPatronymicTest() {
        var person = findPeopleWithoutPatronymic(phoneDirectory);
        assertEquals(3, person.size());
        assertEquals("Москва", person.getFirst().getCityOfResidence());
//        assertEquals(List.of(
//                        new Person("Москва", "улица Новохохловская, д.12",
//                                "Олег", "Олегов", "+7-777-777-77-77"),
//                        new Person("Санкт-Петербург", " улица Гринькова, д.33, кв.76",
//                                "Алексей", "Алексеев", "+7-888-888-88-88"),
//                        new Person("Белгород", "улица Победы, д.1, кв.1",
//                                "Денис", "Денисов", "+7-000-000-00-00")),
//                person);

    }

    public List<Person> findPeopleWithoutPatronymic(
            List<Person> phoneDirectory) {
        return phoneDirectory.stream()
                .filter(p -> p.getPatronymic().isEmpty())
                .map(s -> new Person(s.getCityOfResidence(), s.getAddress(), s.getFirstName(),
                        s.getLastName(), s.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    //3)найти людей с профессией x, и вернуть информацию о них отсротирваную по городу
    @Test
    void findPeopleWithCertainProfessionTest() {
        assertEquals(List.of(
                        ivanovIvan, petrPetrov, ilyaIlyiyov),
                findPeopleWithProfessionXAndSortByCity("Разработчик", phoneDirectory));
        assertEquals(List.of(
                        denisDenisov, alekseyAlekseev),
                findPeopleWithProfessionXAndSortByCity("Таксист", phoneDirectory));
    }

    public List<Person> findPeopleWithProfessionXAndSortByCity(
            String profession, List<Person> phoneDirectory) {
        return phoneDirectory.stream()
                .filter(p -> p.getTypeofActivity().equals(profession))
                .sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER
                        .compare(o1.getCityOfResidence(), o2.getCityOfResidence()))
                .collect(Collectors.toList());

    }

    //4)найти n людей с определенной профессией
    @Test
    void findNPeopleWithTheSpecifiedProfessionTest() {
        assertEquals(List.of(alekseyAlekseev), findNPeopleWithTheSpecifiedProfession(
                "Таксист", 1, phoneDirectory));
        assertEquals(List.of(nikolayIvanov, aleksandrAleksandrov), findNPeopleWithTheSpecifiedProfession(
                "Слесарь", 2, phoneDirectory));
        assertEquals(List.of(), findNPeopleWithTheSpecifiedProfession(
                "Слесарь", 0, phoneDirectory));
    }

    public List<Person> findNPeopleWithTheSpecifiedProfession(String profession, int n, List<Person> phoneDirectory) {
        List<Person> listPeopleWithProfessionN = phoneDirectory.stream()
                .filter(s -> s.getTypeofActivity().equals(profession))
                .limit(n)
                .toList();

        listPeopleWithProfessionN.forEach(p -> System.out.printf("%s %s %s, %s\n",
                p.getLastName(), p.getFirstName(), p.getPatronymic(), p.getTypeofActivity()));

        return listPeopleWithProfessionN;

    }

    //5)осуществить прозвон всех людей с профессией x, с уточненим актуальности информации
    @Test
    void callAllPeopleWithProfessionXAndClarifyInformationTest() {
        assertEquals(List.of(nikolayIvanov, aleksandrAleksandrov, artemArtemov, olegOlegov),
                callAllPeopleWithProfessionX("Слесарь", phoneDirectory));
        assertEquals(List.of(alekseyAlekseev, denisDenisov),
                callAllPeopleWithProfessionX("Таксист", phoneDirectory));
        assertEquals(List.of(petrPetrov, ilyaIlyiyov, ivanovIvan),
                callAllPeopleWithProfessionX("Разработчик", phoneDirectory));
    }

    public List<Person> callAllPeopleWithProfessionX(String profession, List<Person> phoneDirectory) {
        List<Person> subscribersToWhomCallWasMade = phoneDirectory.stream()
                .filter(p -> p.getTypeofActivity().equals(profession))
                .toList();
        subscribersToWhomCallWasMade.forEach(PhoneDirectory::makeCall);
        System.out.println("-------------------------");
        return subscribersToWhomCallWasMade;
    }
}
