package tests.dbTests;

import baseEntities.BaseDBTest;
import dbEntities.CustomersTable;
import models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.CustomerService;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sqlTests extends BaseDBTest {
    static Logger logger = LogManager.getLogger(sqlTests.class);

    @Test
    public void firstDbTest() {
        ResultSet rs = dataBaseService.executeQuery("SELECT * FROM public.users WHERE id = 4 ORDER BY id ASC ");

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("Firstname");
                String lastname = rs.getString("Lastname");
                String email = rs.getString("Email");
                int age = rs.getInt("Age");

                logger.info("ID: " + id);
                logger.info("firstname: " + firstname);
                logger.info("lastname: " + lastname);
                logger.info("email: " + email);
                logger.info("age: " + age);
            }
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        }

        logger.info("Test is completed...");
    }

    @Test
    public void secondDbTest() {
        CustomersTable customersTable = new CustomersTable(dataBaseService);
        customersTable.dropTable();
        customersTable.createTable();

        customersTable.addCustomer("Иван", "Иванов", "ivanov@test.com", 28);
        customersTable.addCustomer("Петр", "Петров", "petrov@test.com", 38);
        customersTable.addCustomer("Марина", "Стасевич", "marina@test.com", 23);

        ResultSet rs = customersTable.getAllCustomers();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("Firstname");
                String lastname = rs.getString("Lastname");
                String email = rs.getString("Email");
                int age = rs.getInt("Age");

                logger.info("ID: " + id);
                logger.info("firstname: " + firstname);
                logger.info("lastname: " + lastname);
                logger.info("email: " + email);
                logger.info("age: " + age);
            }
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        }

        logger.info("Test is completed...");
    }

    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Ivan", "Grigoriev", "test@email.com", 28);
        customerService.saveUser(customer);

        List<Customer> customersList = customerService.findAllUsers();
        for (Customer cust : customersList) {
            logger.info(cust.toString());
        }
    }

    @Test
    public void secondTest() {
        List<Integer> firstArray = new ArrayList<>();
        firstArray.add(10);
        firstArray.add(20);
        firstArray.add(30);

        List<Integer> secondArray = new ArrayList<>();
        secondArray.add(10);
        secondArray.add(20);
        secondArray.add(30);

        Assert.assertTrue(firstArray.containsAll(secondArray));
    }

}
