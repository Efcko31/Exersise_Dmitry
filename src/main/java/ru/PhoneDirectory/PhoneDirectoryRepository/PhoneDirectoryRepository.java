package ru.PhoneDirectory.PhoneDirectoryRepository;

import ru.PhoneDirectory.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneDirectoryRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/my_first_database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Bkmz1205!F";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addPerson(Person person) throws SQLException {
        String sql = "INCERT INTO person (phone_number, first_name, last_name, patronymic, " +
                "city_of_residence, address, type_of_activity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, person.getPhoneNumber());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getLastName());
            stmt.setString(4, person.getPatronymic());
            stmt.setString(5, person.getCityOfResidence());
            stmt.setString(6, person.getAddress());
            stmt.setString(7, person.getTypeofActivity());

            stmt.executeUpdate();
        }
    }

//    public Person findByPhoneNumber(String phoneNumber) throws SQLException {
//        String sql = "SELECT * "
//    }
}
