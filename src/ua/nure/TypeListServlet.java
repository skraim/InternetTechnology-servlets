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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/typelist")
public class TypeListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String type = req.getParameter("type").trim();
        InventoryList invnetoryList;
        DOMParser jaxParser = new DOMParser();
        try {
            invnetoryList = jaxParser.parse(getServletContext().getResourceAsStream("/SportInventory.xml"));
        } catch (Exception e) {
            return;
        }
        List<Inventory> list = invnetoryList.getInventory();
        List<Inventory> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType().equals(type = (type.substring(0, 1).toUpperCase() + type.substring(1)))) {
                resultList.add(list.get(i));
            }
        }
        req.setAttribute("resultList", resultList);
        req.setAttribute("type", type);
        req.getRequestDispatcher("/typelist.jsp").forward(req, res);
    }
}