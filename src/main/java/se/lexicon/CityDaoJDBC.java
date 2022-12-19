package se.lexicon;

import Interfaces.CityDao;
import SqlConnection.MySqlConnection;
import exception.DBConnectionException;

import java.sql.*;
import java.util.List;

public class CityDaoJDBC implements CityDao {

    public City findById(int id) {
        String query = "select * from city where id = ?";
        int cityId = id;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, cityId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println("Id : " + resultSet.getString("ID"));
                    System.out.println("Name : " + resultSet.getString("name"));
                    System.out.println("CountryCode : " + resultSet.getString("CountryCode"));
                    System.out.println("District : " + resultSet.getString("District"));
                    System.out.println("Population : " + resultSet.getString("Population"));
                    System.out.println("___________________");
                }
            }
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<City> findByCode(String code) {
        try {
            if (code.length() != 3) throw new RuntimeException("Code not valid enter only 3 characters!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        String query = "select * from city where CountryCode = ?";
        String cityCode = code;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, cityCode);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println("Id : " + resultSet.getString("ID"));
                    System.out.println("Name : " + resultSet.getString("name"));
                    System.out.println("CountryCode : " + resultSet.getString("CountryCode"));
                    System.out.println("District : " + resultSet.getString("District"));
                    System.out.println("Population : " + resultSet.getString("Population"));
                    System.out.println("___________________");
                }

            }


        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<City> findByName(String name) {
        String query = "select * from city where Name = ?";
        String cityName = name;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, cityName);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println("Id : " + resultSet.getString("ID"));
                    System.out.println("Name : " + resultSet.getString("name"));
                    System.out.println("CountryCode : " + resultSet.getString("CountryCode"));
                    System.out.println("District : " + resultSet.getString("District"));
                    System.out.println("Population : " + resultSet.getString("Population"));
                    System.out.println("___________________");
                }

            }


        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<City> findAll() {
        String query = "select * from city";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getString("ID"));
                System.out.println("Name : " + resultSet.getString("name"));
                System.out.println("CountryCode : " + resultSet.getString("CountryCode"));
                System.out.println("District : " + resultSet.getString("District"));
                System.out.println("Population : " + resultSet.getString("Population"));
                System.out.println("___________________");
            }
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public City add(City city) {
        String query = "insert into city(Id,Name,CountryCode,District,Population) values (?, ?, ?, ?, ?)";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(2, city.getName());
            preparedStatement.setString(3, city.getCountryCode());
            preparedStatement.setString(4, city.getDistrict());
            preparedStatement.setInt(5, city.getPopulation());

            int result = preparedStatement.executeUpdate();
            System.out.println(result);


        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("City was added");
        return city;

    }

    public City update(City city) {
        String query = "select * from city";
        int cityId = city.getId();
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();) {

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public int delete(City city) {
        int cityId = city.getId();
        String query = "delete from city where id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, cityId);

            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected);

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}
