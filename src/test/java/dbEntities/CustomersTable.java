package dbEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;
import tests.dbTests.sqlTests;

import java.sql.ResultSet;

public class CustomersTable {
    static Logger logger = LogManager.getLogger(CustomersTable.class);

    DataBaseService dataBaseService;

    public CustomersTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void dropTable() {
        logger.info("Удаляем customers таблицу");
        String dropTableCustomersSQL = "DROP TABLE Customers;";

        dataBaseService.executeSQL(dropTableCustomersSQL);
    }

    public void createTable() {
        logger.info("Создаем customers таблицу");

        String createTableSQL = "CREATE TABLE Customers (" +
                "ID SERIAL PRIMARY KEY, " +
                "FirstName CHARACTER VARYING(30), " +
                "LastName CHARACTER VARYING(30), " +
                "Email CHARACTER VARYING(30), " +
                "Age INTEGER" +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void addCustomer(String firstName, String lastName, String email, int age) {
        logger.info("Добавляем запись в таблицу");

        String insertTableSQL = "INSERT INTO public.Customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', " + age + ");";

        dataBaseService.executeSQL(insertTableSQL);
    }

    public ResultSet getAllCustomers() {
        String selectSQL = "SELECT * FROM public.Customers ORDER BY id ASC;";

        return dataBaseService.executeQuery(selectSQL);
    }

    public ResultSet getById(int id) {
        String selectSQL = "SELECT * FROM public.Customers WHERE id = " + id + "ORDER BY id ASC;";

        return dataBaseService.executeQuery(selectSQL);
    }
}
