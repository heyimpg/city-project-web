package Controller;

import Model.City;
import Service.CityDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(urlPatterns = "/cities")
public class CityServlet extends HttpServlet {
    private static final String DETAIL_PARAM = "detail";
    private static final String CREATE_PARAM = "create";
    private static final String EDIT_PARAM = "edit";
    private static final String DELETE_PARAM = "delete";

    private static final String SEARCH_PARAM = "search";
    private static final String GO_HOME = "cities?action";


    private CityDAO cityDAO;
    @Override
    public void init() throws ServletException {
//        super.init();
        cityDAO = new CityDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case DETAIL_PARAM:
                showCitiDetail(req, resp);
                break;
            case CREATE_PARAM:
                showCreateForm(req, resp);
                break;
            case EDIT_PARAM:
                showEditForm(req, resp);
                break;
            case DELETE_PARAM:
                showDeleteCity(req, resp);
                break;
            case SEARCH_PARAM:
                searchCity(req, resp);
                break;
            default:
                showListCities(req, resp);
                break;
        }

    }

    private void showDeleteCity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy data từ client
        int ID = Integer.parseInt(req.getParameter("id"));
        City city = cityDAO.findByID(ID);
        req.setAttribute("delete-city", city);
        //Chuyển sang trang xác nhận xóa
        String nextJSP = "View/delete.jsp";
        RedirectPage(nextJSP, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {

            case CREATE_PARAM:
                acceptCreateForm(req, resp);
                break;
            case EDIT_PARAM:
                acceptEditForm(req, resp);
                break;
            case DELETE_PARAM:
                acceptDeleteCity(req, resp);
                break;
            case SEARCH_PARAM:
                searchCity(req, resp);
                break;
            default:
                showListCities(req, resp);
                break;
        }
    }

    private void searchCity(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String search = req.getParameter("search-name");
        String action = SEARCH_PARAM;
        if (search!=null)
        {
            req.setAttribute("search-name-rt", search);
            req.setAttribute("action-rt", action);
        }

      //  System.out.println(search);

//        resp.getWriter().println(search);
        List<City> listCity = new ArrayList<>();
        listCity = cityDAO.searchByName(search);
        showListCitesPage(listCity, req, resp);

     /*   req.setAttribute("listCities", listCity);
        String nextJSP = "/View/list.jsp";
        RedirectPage(nextJSP, req, resp);*/
    }

    private void acceptDeleteCity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy data từ client
        int ID = Integer.parseInt(req.getParameter("id"));
        cityDAO.deleteCity(ID);
        //
        RedirectPage(GO_HOME, req, resp);

    }

    private void acceptEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy data từ client
        int ID = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        float area = Float.parseFloat(req.getParameter("area"));
        float population = Float.parseFloat(req.getParameter("population"));
        float GDP = Float.parseFloat(req.getParameter("GDP"));
        String instruction = req.getParameter("instruction");
        //lưu lại
        cityDAO.updateCity(ID, new City(name, country, area, population, GDP, instruction));
        //
        RedirectPage(GO_HOME, req, resp);

    }

    private void acceptCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy data từ form
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        float area = Float.parseFloat(req.getParameter("area"));
        float population = Float.parseFloat(req.getParameter("population"));
        float GDP = Float.parseFloat(req.getParameter("GDP"));
        String instruction = req.getParameter("instruction");

        City newCity = new City(name,country, area, population, GDP, instruction);
        //Validate
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<City>> constraintViolations = validator.validate(newCity);
        //Nếu lỗi
        if (!constraintViolations.isEmpty()) {
            String errors = "Vui long nhap day du thong tin!";
            req.setAttribute("errors", errors);
        //    req.setAttribute("city", newCity);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/View/create.jsp");
            dispatcher.forward(req, resp);
        }else
        {
            //Thêm mới
            cityDAO.insertCity(newCity);
            //Chuyển về trang chủ
            RedirectPage(GO_HOME, req, resp);
        }
    }


    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get data
        int ID = Integer.parseInt(req.getParameter("id"));
        City city = cityDAO.findByID(ID);
        //send to JSP
        req.setAttribute("edit-city", city);
        String nextJSP = "/View/edit.jsp";
        RedirectPage(nextJSP, req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextJSP = "/View/create.jsp";
        RedirectPage(nextJSP, req, resp);
    }
    //chuyển hướng trang Web
    private void RedirectPage(String nextJSP,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
    private void showCitiDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get City
        int ID = Integer.parseInt(req.getParameter("id"));
        City city = cityDAO.findByID(ID);
        //send data to JSP
        req.setAttribute("detail-city", city);
        String nextJSP = "/View/detail.jsp";
        RedirectPage(nextJSP, req, resp);
    }

    //Hiển thị tca tp
    private void showListCities(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<City> listCity = cityDAO.getAllData();
        showListCitesPage(listCity, req, resp);

        /*req.setAttribute("listCities", listCity);
        String nextJSP = "/View/list.jsp";
        RedirectPage(nextJSP, req, resp);*/
    }

    //Hiển thị tca tp có phân trang
    private void showListCitesPage(List<City> listCity, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize = 5;
        int countPage = (int)Math.ceil( (double) listCity.size()/pageSize );

        countPage = countPage!=0?countPage:1;

        //Trang hiện tại
        String currentPage = req.getParameter("pageIndex");

        int pageIndex = currentPage!=null?(Integer.parseInt(currentPage)):1;

        //Đếm tổng số trang
        req.setAttribute("countPage", countPage);
        req.setAttribute("pageIndex", pageIndex);


        List<City> listCityPage  = new ArrayList<>();

        for (int i= (pageIndex*pageSize-pageSize); i<=(pageIndex*pageSize-1); i++)
            if (i < listCity.size())
                listCityPage.add(listCity.get(i));

        req.setAttribute("listCities", listCityPage);
        String nextJSP = "/View/list.jsp";
        RedirectPage(nextJSP, req, resp);
    }

}
