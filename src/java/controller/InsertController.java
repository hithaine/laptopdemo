package controller;

import dal.LaptopDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Laptop;

@WebServlet(name = "InsertController", urlPatterns = {"/insert"})
public class InsertController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LaptopDAO laptopDAO = new LaptopDAO();
        request.getRequestDispatcher("insert.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LaptopDAO laptopDAO = new LaptopDAO();
        // Get the laptop's information from the request
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");

        // Create a new Laptop object
        Laptop l = new Laptop();
        l.setName(name);
        l.setPrice(price);
        l.setColor(color);
        
        //insert new laptop
        try {
            // Insert the laptop into the database
            laptopDAO.insertLaptop(l);
        } catch (SQLException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);       
        }

        // Get the updated list of laptops
        List<Laptop> laptops = laptopDAO.getLaptops();

        // Set the laptops attribute in the request
        request.setAttribute("laptops", laptops);

        // Redirect the user to the list.jsp page
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
