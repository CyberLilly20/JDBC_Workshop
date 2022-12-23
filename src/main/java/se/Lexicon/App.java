package se.Lexicon;

import se.Lexicon.dao.CityDao;
import se.Lexicon.dao.CityDaoJDBC;
import se.Lexicon.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        CityDao dao = new CityDaoJDBC();

        City city = dao.findById(1);
        System.out.println(city);
        System.out.println("-------------------------------------------");

        List<City> cities = dao.findByCode("afg");

        System.out.println(cities);
        System.out.println("--------------------------------------------");

        City addCity = new City("Skopje", "MKD", "Skopje", 1000000);
        City newCity = dao.add(addCity);
        System.out.println(newCity);
        System.out.println("----------------------------------------");

        City updateCity = dao.findById(4081);
        System.out.println("Before update: " + updateCity.toString());
        updateCity.setPopulation(888888);
        updateCity.setDistrict("Center");

        City updatedCity = dao.update(updateCity);
        System.out.println("After update: " + updatedCity.toString());
        System.out.println("---------------------------------------");

        City deleteCity = dao.findById(4082);
        int result = dao.delete(deleteCity);

        System.out.println(result);


    }
}
