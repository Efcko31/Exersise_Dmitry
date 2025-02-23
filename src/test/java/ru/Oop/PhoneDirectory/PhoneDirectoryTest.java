package ru.Oop.PhoneDirectory;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.Oop.PhoneDirectory.PhoneDirectory.*;

public class PhoneDirectoryTest {


    public static List<Person> phoneDirectory = new ArrayList<>(List.of(
            nikolayIvanov, petrPetrov, ilyaIlyiyov, aleksandrAleksandrov,
            nikolayVasiliev, artemArtemov, olegOlegov, alekseyAlekseev,
            maksimMaksimov, denisDenisov));


    //1)найти всех людей проживающих в городе n, и вернуть их номер телефона и фио
    @Test
    void findEveryoneWhoLivesInTheCityTest() {
        assertEquals(List.of(
                        "Николай Иванов Васильевич т.8-111-111-11-11",
                        "Александр Алекснадров Александрович т.8-444-444-44-44",
                        "Олег Олегов  т.8-777-777-77-77"),
                findEveryoneWhoLivesInTheCityAndReturnTheirPhoneNumberAndFullName("Москва", phoneDirectory));
        assertEquals(List.of(
                        "Петр Петров Петрович т.8-222-222-22-22",
                        "Илья Ильёв Ильич т.8-333-333-33-33",
                        "Алексей Алексеев  т.8-888-888-88-88"),
                findEveryoneWhoLivesInTheCityAndReturnTheirPhoneNumberAndFullName("Санкт-Петербург", phoneDirectory));
    }

    public List<String> findEveryoneWhoLivesInTheCityAndReturnTheirPhoneNumberAndFullName(
            String cityN, List<Person> phoneDirectory) {
        return phoneDirectory.stream().
                filter(p -> p.getCityOfResidence().equals(cityN)).
                map(s -> String.format("%s %s %s т.%s",
                        s.getFirstName(), s.getLastName(),
                        s.getPatronymic(), s.getPhoneNumber())).
                collect(Collectors.toList());
    }

    //2)найти людей без отчества, и вернуть место их проживания, фио, номер телефона
    @Test
    void findPeopleWithoutPatronymicTest() {
        assertEquals(List.of(
                        "Москва, улица Новохохловская, д.12, Олег, Олегов, т.8-777-777-77-77",
                        "Санкт-Петербург, улица Гринькова, д.33, кв.76, Алексей, Алексеев, т.8-888-888-88-88",
                        "Белгород, улица Победы, д.1, кв.1, Денис, Денисов, т.8-000-000-00-00"),
                findPeopleWithoutPatronymicAndReturnTheirPlaceOfResidenceFullNameAndPhoneNumber(phoneDirectory));
    }

    public List<String> findPeopleWithoutPatronymicAndReturnTheirPlaceOfResidenceFullNameAndPhoneNumber(
            List<Person> phoneDirectory) {
        return phoneDirectory.stream().
                filter(p -> p.getPatronymic().isEmpty()).
                map(s -> String.format("%s, %s, %s, %s, т.%s",
                        s.getCityOfResidence(), s.getAddress(), s.getFirstName(),
                        s.getLastName(), s.getPhoneNumber())).
                collect(Collectors.toList());
    }

    //3)найти людей с профессией x, и вернуть информацию о них отсротирваную по городу
    @Test
    void findPeopleWithCertainProfessionTest() {
        assertEquals(List.of(
                        "Иван Иванов Иванович, Екатеринбург, улица Красноказарменная, д.33, кв.44, Разработчик, т.8-555-555-55-55",
                        "Петр Петров Петрович, Санкт-Петербург, улица Громова, д.6, кв.12, Разработчик, т.8-222-222-22-22",
                        "Илья Ильёв Ильич, Санкт-Петербург, улица Громова, д.12, кв.55, Разработчик, т.8-333-333-33-33"),
                findPeopleWithProfessionXAndReturnTheirInformationSortedByCity("Разработчик", phoneDirectory));
        assertEquals(List.of(
                        "Денис Денисов , Белгород, улица Победы, д.1, кв.1, Таксист, т.8-000-000-00-00",
                        "Алексей Алексеев , Санкт-Петербург, улица Гринькова, д.33, кв.76, Таксист, т.8-888-888-88-88"),
                findPeopleWithProfessionXAndReturnTheirInformationSortedByCity("Таксист", phoneDirectory));
    }

    public List<String> findPeopleWithProfessionXAndReturnTheirInformationSortedByCity(
            String profession, List<Person> phoneDirectory) {
        return phoneDirectory.stream().
                filter(p -> p.getTypeofActivity().equals(profession)).
                sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.
                        compare(o1.getCityOfResidence(), o2.getCityOfResidence())).
                map(s -> String.format("%s %s %s, %s, %s, %s, т.%s",
                        s.getFirstName(), s.getLastName(), s.getPatronymic(),
                        s.getCityOfResidence(), s.getAddress(), s.getTypeofActivity(), s.getPhoneNumber())).
                collect(Collectors.toList());

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
        List<Person> listPeopleWithProfessionN = phoneDirectory.stream().
                filter(s -> s.getTypeofActivity().equals(profession)).
                limit(n).toList();

        listPeopleWithProfessionN.forEach(p -> System.out.printf("%s %s %s, %s\n",
                p.getLastName(), p.getFirstName(), p.getPatronymic(), p.getTypeofActivity()));

        return listPeopleWithProfessionN;

    }

    //5)осуществить прозвон всех людей с профессией x, с уточненим актуальности информации
    @Test
    void callAllPeopleWithProfessionXAndClarifyInformationTest() {
        assertEquals(List.of(nikolayIvanov, aleksandrAleksandrov, artemArtemov, olegOlegov),
                callAllPeopleWithProfessionXAndClarifyInformation("Слесарь", phoneDirectory));
        assertEquals(List.of(alekseyAlekseev, denisDenisov),
                callAllPeopleWithProfessionXAndClarifyInformation("Таксист", phoneDirectory));
        assertEquals(List.of(petrPetrov, ilyaIlyiyov, nikolayVasiliev),
                callAllPeopleWithProfessionXAndClarifyInformation("Разработчик", phoneDirectory));
    }

    public List<Person> callAllPeopleWithProfessionXAndClarifyInformation(String profession, List<Person> phoneDirectory) {
        List<Person> subscribersToWhomCallWasMade = phoneDirectory.stream().
                filter(p -> p.getTypeofActivity().equals(profession)).
                toList();
        subscribersToWhomCallWasMade.forEach(PhoneDirectory::makeCall);
        System.out.println("-------------------------");
        return subscribersToWhomCallWasMade;
    }
}
