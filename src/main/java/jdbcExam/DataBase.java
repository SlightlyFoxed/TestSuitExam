package jdbcExam;

import java.sql.*;
import static jdbcExam.DB_Methods.*;
import static jdbcExam.DataSource.*;

public class DataBase {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "89205990123";




    public static void main(String[] args) throws SQLException {
        driverConnection();

        /*executeStatement(dsMap(), "INSERT INTO human (name, surname, middlename,salary, branch, age, gender)" +
                "VALUES ('Доброжир','Довольный','Жидоборович',8000, 'Sevastopol', 41, 'male');");
        executeStatement(dsMap(), "INSERT INTO human (name, surname, middlename,salary, branch, age, gender)" +
                "VALUES ('Доброгнева','Квитун','Ярополковна',10000, 'Rostov-on-Don', 32, 'female');");
        executeStatement(dsMap(), "INSERT INTO human (name, surname, middlename,salary, branch, age, gender)" +
                "VALUES ('Гостомысл','Каверзин','Градимирович',14000, 'Rostov-on-Don', 38, 'male');");
        executeStatement(dsMap(), "INSERT INTO human (name, surname, middlename,salary, branch, age, gender)" +
                "VALUES ('Градислав','Братухин','Милонегович',9000, 'Rostov-on-Don', 25, 'male');");
        executeStatement(dsMap(), "INSERT INTO human (name, surname, middlename,salary, branch, age, gender)" +
                "VALUES ('Святозар','Кузьменко','Тихомирович',11000, 'Tula', 29, 'male');");
        executeStatement(dsMap(), "INSERT INTO human (name, surname, middlename,salary, branch, age, gender)" +
                "VALUES ('Богдан','Дядин','Велимудрович',10000, 'Tula', 28, 'male');");
        executeStatement(dsMap(), "INSERT INTO human (name, surname, middlename,salary, branch, age, gender)" +
                "VALUES ('Ждан','Неждан','Ратиборович',13000, 'Tula', 33, 'male');");
        executeStatement(dsMap(), "INSERT INTO human (name, surname, middlename,salary, branch, age, gender)" +
                "VALUES ('Добронега','Тугодуменко','Наумовна',15000, 'Tula', 26, 'female');");*/


        /*executeStatement(dsMap(),"INSERT INTO branches (city, number_of_employees) VALUES ('Sevastopol', 2);");
        executeStatement(dsMap(),"INSERT INTO branches (city, number_of_employees) VALUES ('Rostov-on-Don', 3);");
        executeStatement(dsMap(),"INSERT INTO branches (city, number_of_employees) VALUES ('Tula', 4);");*/

        getHumanzTable(dsMap(),"SELECT * FROM human");

        getHumanzTable(dsMap(),"SELECT * FROM human");


    }



}
