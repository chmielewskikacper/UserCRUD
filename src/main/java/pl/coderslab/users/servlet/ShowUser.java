package pl.coderslab.users.servlet;

import pl.coderslab.users.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class ShowUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //a wież cos sie stanie jak id jest nulem ??
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDao();
        req.setAttribute("user", userDao.read(id));
        getServletContext().getRequestDispatcher("/users/showUser.jsp").forward(req,resp);
    }
}
