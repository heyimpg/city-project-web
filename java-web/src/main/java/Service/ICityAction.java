package Service;

import Model.City;

import java.util.List;

public interface ICityAction {
    List<City> getAllData();
    City findByID(int ID);
    void insertCity(City city);
    void updateCity(int ID,City city);
    void deleteCity(int ID);
}
