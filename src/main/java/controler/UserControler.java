package controler;

import model.Person;
import repository.PersonRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserControler", value = "/persons")
public class UserControler extends HttpServlet
{
    @Inject
    private PersonRepository personRepo;
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Person> perosnsList = personRepo.getAll();
        request.setAttribute("persons", perosnsList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
