import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/my-index")
public class testServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

       /* PrintWriter writer = resp.getWriter();
        writer.println("Nguyễn Văn Phương");
        writer.close();*/

        sendDataforClient(req, resp);
    }

    private void sendDataforClient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = "Nguyễn Văn Phương";
        req.setAttribute("myname", name);
        String nextJSP = "/index.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
//        dispatcher.include(req, resp);

    }
}
