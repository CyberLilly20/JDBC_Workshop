package se.Lexicon;

import se.Lexicon.dao.CityDao;
import se.Lexicon.dao.CityDaoJDBC;
import se.Lexicon.model.City;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        CityDao dao = new CityDaoJDBC();
        City city = dao.findById(1);
        System.out.println(city);



    }
}
