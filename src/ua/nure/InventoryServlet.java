package ua.nure;

import ua.nure.parser.DOMParser;
import ua.nure.sportinventory.Inventory;
import ua.nure.sportinventory.InventoryList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/aboutinventory")
public class InventoryServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Integer integer;
        try {
            integer = Integer.parseInt(req.getParameter("inventory"));
        } catch (Exception ex) {
            req.setAttribute("message", "\"id\" can only be a number");

            req.getRequestDispatcher("/error.jsp").forward(req, res);
            return;
        }
        InventoryList invnetoryList;
        DOMParser jaxParser = new DOMParser();
        try {
            invnetoryList = jaxParser.parse(getServletContext().getResourceAsStream("/SportInventory.xml"));
        } catch (Exception e) {
            return;
        }
        List<Inventory> list = invnetoryList.getInventory();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == integer) {
                req.setAttribute("name", "About Inventory");
                req.setAttribute("message", list.get(i).toString());
                req.getRequestDispatcher("/singlemess.jsp").forward(req, res);
                return;
            }
        }
        req.setAttribute("message", "There is no items with this id");
        req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
}