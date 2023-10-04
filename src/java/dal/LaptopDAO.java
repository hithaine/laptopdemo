package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Laptop;

public class LaptopDAO extends DBContext {

    public List<Laptop> getLaptops() {
        List<Laptop> laptops = new ArrayList<>();
        try {
            String sql = "select id, name, price, color from laptop";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Laptop l = new Laptop();
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                l.setPrice(rs.getDouble("price"));
                l.setColor(rs.getString("color"));
                
                laptops.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return laptops;
    }

    public void insertLaptop(Laptop laptop) throws SQLException {
        String sql = "INSERT [dbo].[Laptop] ([id], [name], [price], [color]) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, laptop.getId());
        statement.setString(2, laptop.getName());
        statement.setDouble(3, laptop.getPrice());
        statement.setString(4, laptop.getColor());

        statement.executeUpdate();
    }

    public void updateLaptop(Laptop laptop) throws SQLException {
        String sql = "UPDATE [Laptop] SET [name] = ?, [price] = ?, [color] = ? WHERE [id] = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, laptop.getName());
        statement.setDouble(2, laptop.getPrice());
        statement.setString(3, laptop.getColor());
        statement.setInt(4, laptop.getId());

        statement.executeUpdate();
    }

    public void deleteLaptop(int id) throws SQLException {
        String sql = "DELETE FROM [Laptop] WHERE [id] = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        statement.executeUpdate();
    }
}
