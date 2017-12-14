package ua.nure;

import org.xml.sax.SAXException;
import ua.nure.parser.DOMParser;
import ua.nure.sportinventory.Inventory;
import ua.nure.sportinventory.InventoryList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/inventorylist")
public class InventoryListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException  {

        InventoryList inventoryList;
        DOMParser jaxParser = new DOMParser();
        try {
            inventoryList = jaxParser.parse(getServletContext().getResourceAsStream("/SportInventory.xml"));
        } catch (Exception e) {
            return;
        }
        List<Inventory> list = inventoryList.getInventory();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/wholelist.jsp").forward(req, res);
    }
}