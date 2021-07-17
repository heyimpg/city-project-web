package Service;

import Model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CityDAO implements ICityAction{
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String NAME_DATABASE = "mini_project";
    private static final String USER_NAME = "oop";
    private static final String PASSWORD = "123";

    private static String DB_URL = "jdbc:mysql://localhost:3306/"+NAME_DATABASE;

    private static final String SELECT_ALL_CITIES = "select * from city";
    private static final String INSERT_CITY_SQL = "INSERT INTO city" + "(Name, Country, Area, Population, GDP, Instruction) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CITY_BY_ID = "select ID,Name,Country,Area,Population,GDP,Instruction from city where ID =?";
    private static final String DELETE_CITY_SQL = "delete from city where ID = ?";
    private static final String UPDATE_CITY_SQL = "update city set Name = ?,Country= ?, Area =?, Population=?, GDP=?, Instruction=? where ID = ?";

    private static Connection conn;

    public CityDAO() {
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi kết nối tới Driver");
            //e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("Lỗi khởi tạo Connection");
            //throwables.printStackTrace();
        }
    }

    @Override
    public List<City> getAllData() {
        List<City> arrList = new ArrayList<>();
        try {
            PreparedStatement psmtm = conn.prepareStatement(SELECT_ALL_CITIES);
            ResultSet rs = psmtm.executeQuery();
            while (rs.next())
            {
                int ID = rs.getInt(1);
                String Name = rs.getString(2);
                String Country = rs.getString(3);
                float Area = rs.getFloat(4);
                float Population = rs.getFloat(5);
                float GDP = rs.getFloat(6);
                String Instruction = rs.getString(7);
                arrList.add(new City(ID, Name, Country, Area, Population, GDP, Instruction));
            }
            rs.close();
            psmtm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return arrList;
    }

    @Override
    public City findByID(int id) {
        try {
            PreparedStatement psmtm = conn.prepareStatement(SELECT_CITY_BY_ID);
            psmtm.setInt(1, id);
            ResultSet rs = psmtm.executeQuery();
            rs.next();

            int ID = rs.getInt(1);
            String Name = rs.getString(2);
            String Country = rs.getString(3);
            float Area = rs.getFloat(4);
            float Population = rs.getFloat(5);
            float GDP = rs.getFloat(6);
            String Instruction = rs.getString(7);

            rs.close();
            psmtm.close();

            return new City(ID, Name, Country, Area, Population, GDP, Instruction);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertCity(City city) {
        try {

            PreparedStatement psmtm = conn.prepareStatement(INSERT_CITY_SQL);
            psmtm.setString(1, city.getName());
            psmtm.setString(2, city.getCountry());
            psmtm.setFloat(3, city.getArea());
            psmtm.setFloat(4, city.getPopulation());
            psmtm.setFloat(5, city.getGdp());
            psmtm.setString(6, city.getInstruction());

            psmtm.executeUpdate();
            psmtm.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void updateCity(int ID, City city) {
        try {

            PreparedStatement psmtm = conn.prepareStatement(UPDATE_CITY_SQL);
            psmtm.setString(1, city.getName());
            psmtm.setString(2, city.getCountry());
            psmtm.setFloat(3, city.getArea());
            psmtm.setFloat(4, city.getPopulation());
            psmtm.setFloat(5, city.getGdp());
            psmtm.setString(6, city.getInstruction());
            psmtm.setInt(7, ID);

            psmtm.executeUpdate();

            psmtm.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteCity(int ID) {
        try {
            PreparedStatement psmtm = conn.prepareStatement(DELETE_CITY_SQL);
            psmtm.setInt(1, ID);
            psmtm.executeUpdate();

            psmtm.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<City> searchByName(String name)
    {
        List<City> arrList = new ArrayList<>();
        arrList = getAllData();

        if (name == null)
        {
            return arrList;
        }
        else
        {
            List<City> arrListTemp = new ArrayList<>();
           // arrListTemp = arrList;

            for (City city : arrList)
            {
                if (city.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                    arrListTemp.add(city);
            }

            return arrListTemp;
        }
    }
}
