package se.lexicon;

import SqlConnection.MySqlConnection;
import exception.DBConnectionException;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        CityDaoJDBC city = new CityDaoJDBC();
City testSubject = new City(4076,"Hebron","PSE","Hebron",119401);


//city.delete(testSubject);
//city.add(testSubject);
        //city.findAll();
        //city.findByName("Herat");
        //city.findByCode("AFG");
        //city.findById(4076);
    }
}
