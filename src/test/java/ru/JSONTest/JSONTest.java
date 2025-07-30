package ru.JSONTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.JSONTest.Pojo.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTest {
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @Test
    void carpetJsonTest() throws IOException {
        File fileCarpet = new File("src/test/java/ru/JSONTest/resources/platinumCarpet.json");
        CarpetJson platinum = objectMapper.readValue(fileCarpet, CarpetJson.class);

        String carpetShapurJson = "{\n" +
                " \"brandName\" : \"Osta\",\n" +
                " \" collectionName\" : \"Shapur\",\n" +
                " \"composition\" : \"wool\",\n" +
                " \"density\" : \"720000\"\n" + "}";
        CarpetJson shapur = objectMapper.readValue(carpetShapurJson, CarpetJson.class);
    }

    @Test
    void pojoToJsonString() throws JsonProcessingException {
        Employee employee = new Employee("Mark", "Dipler", 27);

        String json = objectMapper.writeValueAsString(employee);
        System.out.println(json);
    }

    @Test
    void jsonStringToPojo() throws JsonProcessingException {
        String employeeJson = "{\n" +
                " \"firstName\" : \"Jalil\",\n" +
                " \"lastName\" : \"Jarjanazy\",\n" +
                " \"age\" : 30\n" + "}";

        Employee employee = objectMapper.readValue(employeeJson, Employee.class);
        assertEquals("Jalil", employee.getFirstName());
    }

    @Test
    void jsonFileToPojo() throws IOException {
        File file = new File("src/test/java/ru/JSONTest/resources/employee.json");

        Employee employee = objectMapper.readValue(file, Employee.class);

        assertEquals(44, employee.getAge());
        assertEquals("Homer", employee.getFirstName());
        assertEquals("Simpson", employee.getLastName());
    }

    @Test
    void byteArrayToPojo() throws IOException {
        String employeeJson = "{\n" +
                " \"firstName\" : \"Jalil\",\n" +
                " \"lastName\" : \"Jarjanazy\",\n" +
                " \"age\" : 30\n" + "}";
        Employee employee = objectMapper.readValue(employeeJson.getBytes(), Employee.class);
        assertEquals("Jalil", employee.getFirstName());
    }

    @Test
    void fileToListOfPojos() throws IOException {
        File file = new File("src/test/java/ru/JSONTest/resources/employeeList.json");
        List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<>() {
        });

        assertEquals("Marge", employeeList.getFirst().getFirstName());
        assertEquals(14, employeeList.getLast().getAge());
        assertEquals("Bart", employeeList.getLast().getFirstName());
    }

    @Test
    void failToMap() throws IOException {
        File file = new File("src/test/java/ru/JSONTest/resources/employee.json");
        Map<String, Object> employee = objectMapper.readValue(file, new TypeReference<>() {
        });

        assertEquals("Homer", employee.get("firstName"));
        assertEquals(44, employee.get("age"));
        assertEquals("Simpson", employee.get("lastName"));
    }

    @Test
    void fileToPojoWithUnknownProperties() throws IOException {
        File file = new File("src/test/java/ru/JSONTest/resources/employeeWithAnExtraField.json");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Employee employee = objectMapper.readValue(file, Employee.class);
        assertEquals("Left", employee.getFirstName());
        assertEquals("Rights", employee.getLastName());
        assertEquals(18, employee.getAge());
    }


    @Test
    void orderToJson() throws JsonProcessingException {
        OrderJson order = new OrderJson(1, LocalDate.of(1999, 1, 2));
        String json = objectMapper.writeValueAsString(order);
        System.out.println(json);
    }

    @Test
    void fileToOrder() throws IOException {
        File file = new File("src/test/java/ru/JSONTest/resources/order.json");
        OrderJson order = objectMapper.readValue(file, OrderJson.class);

        assertEquals(LocalDate.of(1999, 4, 30), order.getDate());
    }

    @Test
    void fileToCar() throws IOException {
        File file = new File("src/test/java/ru/JSONTest/resources/car.json");
        CarJson car = objectMapper.readValue(file, CarJson.class);

        assertEquals("BMW", car.getBrand());

    }

    @Test
    void fileToUnrecognizedCar() throws IOException {
        File file = new File("src/test/java/ru/JSONTest/resources/carUnrecognized.json");
        CarJson car = objectMapper.readValue(file, CarJson.class);

        assertEquals("1996", car.getUnrecognizedFields().get("productionYear"));
    }

    @Test
    void catToJson() throws JsonProcessingException {
        CatJson cat = new CatJson("Monica");

        String json = objectMapper.writeValueAsString(cat);

        System.out.println(json);
    }

    @Test
    void catToJsonWithMap() throws JsonProcessingException {
        CatJson cat = new CatJson("Monica");
        String json = objectMapper.writeValueAsString(cat);

        System.out.println(json);
    }

    @Test
    void dogToJson() throws JsonProcessingException {
        DogJson dog = new DogJson("Max", 3);

        String json = objectMapper.writeValueAsString(dog);

        System.out.println(json);
    }

    @Test
    void fileToDog() throws IOException {
        File file = new File("src/test/java/ru/JSONTest/resources/dog.json");

        DogJson dog = objectMapper.readValue(file, DogJson.class);

        assertEquals("bobby", dog.getName());
    }
}
