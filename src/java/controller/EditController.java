
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


@WebServlet(name="EditController", urlPatterns={"/edit"})
public class EditController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        LaptopDAO laptopDAO = new LaptopDAO();
        String id = request.getParameter("id");  
        request.setAttribute("id", id);
        
        request.getRequestDispatcher("edit.jsp").forward(request, response);  
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        LaptopDAO laptopDAO = new LaptopDAO();
        // Get the laptop's information from the request
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");

        // Create a new Laptop object
        Laptop l = new Laptop();
        l.setId(id);
        l.setName(name);
        l.setPrice(price);
        l.setColor(color);
        
        //update new laptop
        try {
            // Update the laptop into the database
            laptopDAO.updateLaptop(l);
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

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
