package se.Lexicon.dao;

import se.Lexicon.model.City;

import java.util.List;

public class CityDaoJDBC implements CityDao {


    //todo: implement all the methods
    public City findById(int id) {
        //step1: try-with-recourses
        //step2: define a select query
        //step3: define a db connection
        //step4: define a prepared statement
        //step5: set id to prepared statement
        //step6: execute the query
        //step7: get data from the result set and set it to city object
        //step8: return it

        return null;
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
