package se.Lexicon.dao;

import com.sun.org.apache.bcel.internal.generic.Select;
import se.Lexicon.MySQLConnection;
import se.Lexicon.exception.DBConnectionException;
import se.Lexicon.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            preparedStatement.setInt(1,id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()){
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



        return null;
    }

    public List<City> findByName(String name) {
        return null;
    }

    public List<City> findAll() {
        return null;
    }

    public City add(City city) {
        return null;
    }

    public City update(City city) {
        return null;
    }

    public int delete(City city) {
        return 0;
    }
}
