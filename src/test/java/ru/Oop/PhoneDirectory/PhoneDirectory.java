package ru.Oop.PhoneDirectory;

public class PhoneDirectory {

    public static Person nikolayIvanov = new Person(
            "8-111-111-11-11",
            "Николай",
            "Иванов",
            "Васильевич",
            "Москва",
            "улица Ромашковая, д.12",
            "Слесарь");

    public static Person petrPetrov = new Person(
            "8-222-222-22-22",
            "Петр",
            "Петров",
            "Петрович",
            "Санкт-Петербург",
            "улица Громова, д.6, кв.12",
            "Разработчик");

    public static Person ilyaIlyiyov = new Person(
            "8-333-333-33-33",
            "Илья",
            "Ильёв",
            "Ильич",
            "Санкт-Петербург",
            "улица Громова, д.12, кв.55",
            "Разработчик");

    public static Person aleksandrAleksandrov = new Person(
            "8-444-444-44-44",
            "Александр",
            "Алекснадров",
            "Александрович",
            "Москва",
            "улица Ромашковая, д.12",
            "Слесарь");

    public static Person nikolayVasiliev = new Person(
            "8-555-555-55-55",
            "Иван",
            "Иванов",
            "Иванович",
            "Екатеринбург",
            "улица Красноказарменная, д.33, кв.44",
            "Разработчик");

    public static Person artemArtemov = new Person(
            "8-666-666-66-66",
            "Артем",
            "Артемов",
            "Артемович",
            "Екатеринбург",
            "улица Красноказарменная, д.12, кв.12",
            "Слесарь");

    public static Person olegOlegov = new Person(
            "8-777-777-77-77",
            "Олег",
            "Олегов",
            "",
            "Москва",
            "улица Новохохловская, д.12",
            "Слесарь");

    public static Person alekseyAlekseev = new Person(
            "8-888-888-88-88",
            "Алексей",
            "Алексеев",
            "",
            "Санкт-Петербург",
            "улица Гринькова, д.33, кв.76",
            "Таксист");

    public static Person maksimMaksimov = new Person(
            "8-999-999-99-99",
            "Максим",
            "Максимов",
            "Максимович",
            "Белгород",
            "улица Королева, д.55, кв.22",
            "Стоматолог");

    public static Person denisDenisov = new Person(
            "8-000-000-00-00",
            "Денис",
            "Денисов",
            "",
            "Белгород",
            "улица Победы, д.1, кв.1",
            "Таксист");

    public static void makeCall(Person person) {
        System.out.printf("Начат вызов. %s т.%s%n", person.getFirstName(), person.getPhoneNumber());

    }
}
