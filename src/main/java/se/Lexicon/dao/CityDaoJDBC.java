package se.Lexicon.dao;

import com.sun.org.apache.bcel.internal.generic.Select;
import se.Lexicon.MySQLConnection;
import se.Lexicon.exception.DBConnectionException;
import se.Lexicon.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {


    //todo: implement all the methods
    public City findById(int id) {
        String query = "select * from city where id = ? ";
        City city = new City();


        try (
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    city.setId(resultSet.getInt(1));
                    city.setName(resultSet.getString(2));
                    city.setCountryCode(resultSet.getString(3));
                    city.setDistrict(resultSet.getString(4));
                    city.setPopulation(resultSet.getInt(5));
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }


        //step1: try-with-recourses
        //step2: define a select query
        //step3: define a db connection
        //step4: define a prepared statement
        //step5: set id to prepared statement
        //step6: execute the query
        //step7: get data from the result set and set it to city object
        //step8: return it


        return city;
    }

    public List<City> findByCode(String code) {
        String query = "select * from city where CountryCode = ? ";
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, code);
            // get the results from database
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                //go over the results
                while (resultSet.next()) {
                    City city = new City();
                    city.setId(resultSet.getInt(1));
                    city.setName(resultSet.getString(2));
                    city.setCountryCode(resultSet.getString(3));
                    city.setDistrict(resultSet.getString(4));
                    city.setPopulation(resultSet.getInt(5));
                    cities.add(city);
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }


        return cities;
    }

    public List<City> findByName(String name) {
        String query = "select * from city where Name = ? ";
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, name);
            // get the results from database
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                //go over the results
                while (resultSet.next()) {
                    City city = new City();
                    city.setId(resultSet.getInt(1));
                    city.setName(resultSet.getString(2));
                    city.setCountryCode(resultSet.getString(3));
                    city.setDistrict(resultSet.getString(4));
                    city.setPopulation(resultSet.getInt(5));
                    cities.add(city);
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return cities;
    }

    public List<City> findAll() {
        String query = "select * from city ";
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            // get the results from database
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                //go over the results
                while (resultSet.next()) {
                    City city = new City();
                    city.setId(resultSet.getInt(1));
                    city.setName(resultSet.getString(2));
                    city.setCountryCode(resultSet.getString(3));
                    city.setDistrict(resultSet.getString(4));
                    city.setPopulation(resultSet.getInt(5));
                    cities.add(city);
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return cities;
    }

    public City add(City city) {
        String query = "insert into city (Name, CountryCode, District, Population) values (?, ?, ?, ?)";
        try (
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        ) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());

            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {
                if (resultSet.next()) {
                    return this.findById(resultSet.getInt(1));
                }
            }
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public City update(City city) {
        String query = "update city set Name = ?, CountryCode = ?, District = ?, Population = ? where id = ? ";
        try (
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);

        ) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setInt(5, city.getId());

            preparedStatement.executeUpdate();

            return this.findById(city.getId());

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int delete(City city) {
        String query = "delete from city where id = ?";
        try (
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);

        ) {

            preparedStatement.setInt(1, city.getId());

            preparedStatement.executeUpdate();
            return 1;

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }
}
