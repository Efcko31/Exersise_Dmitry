package ru.PhoneDirectory;

import ru.PhoneDirectory.DTO.FullNamePhoneNumb;
import ru.PhoneDirectory.DTO.FullNamePhoneNumbAddress;
import ru.PhoneDirectory.Mapper.FullNamePhoneNumbAddressMapper;
import ru.PhoneDirectory.Mapper.FullNamePhoneNumbMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneDirectory {
    //1)найти всех людей проживающих в городе n, и вернуть их номер телефона и фио

    public static List<FullNamePhoneNumb> findEveryoneWhoLivesInTheCityX(
            String cityN, List<Person> phoneDirectory) {
        return phoneDirectory.stream()
                .filter(p -> p.getCityOfResidence().equals(cityN))
                .map(FullNamePhoneNumbMapper.INSTANCE::toFullNamePhoneNumb)
                .collect(Collectors.toList());
    }

    //2)найти людей без отчества, и вернуть место их проживания, фио, номер телефона

    public static List<FullNamePhoneNumbAddress> findPeopleWithoutPatronymic(
            List<Person> phoneDirectory) {
        return phoneDirectory.stream()
                .filter(p -> p.getPatronymic().isEmpty())
                .map(FullNamePhoneNumbAddressMapper.INSTANCE::toFullNamePhoneNumbAddress)
                .collect(Collectors.toList());
    }

    //3)найти людей с профессией x, и вернуть информацию о них отсротирваную по городу

    public static List<Person> findPeopleWithProfessionXAndSortByCity(
            String profession, List<Person> phoneDirectory) {
        return phoneDirectory.stream()
                .filter(p -> p.getTypeofActivity().equals(profession))
                .sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER
                        .compare(o1.getCityOfResidence(), o2.getCityOfResidence()))
                .collect(Collectors.toList());

    }

    //4)найти n людей с определенной профессией

    public static List<Person> findNPeopleWithTheSpecifiedProfession(String profession, int n, List<Person> phoneDirectory) {
        List<Person> listPeopleWithProfessionN = phoneDirectory.stream()
                .filter(s -> s.getTypeofActivity().equals(profession))
                .limit(n)
                .toList();

        listPeopleWithProfessionN.forEach(p -> System.out.printf("%s %s %s, %s\n",
                p.getLastName(), p.getFirstName(), p.getPatronymic(), p.getTypeofActivity()));

        return listPeopleWithProfessionN;

    }

    //5)осуществить прозвон всех людей с профессией x, с уточненим актуальности информации

    public static List<Person> callAllPeopleWithProfessionX(String profession, List<Person> phoneDirectory) {
        List<Person> subscribersToWhomCallWasMade = phoneDirectory.stream()
                .filter(p -> p.getTypeofActivity().equals(profession))
                .toList();
        subscribersToWhomCallWasMade.forEach(PersonsForPhoneDirectory::makeCall);
        System.out.println("-------------------------");
        return subscribersToWhomCallWasMade;
    }
}
