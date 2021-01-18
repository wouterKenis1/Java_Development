package com.vdab.DAO;

import com.vdab.App.DataBaseAccess;
import com.vdab.models.Location;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationDAOImpl implements LocationDAO {
    final private String url = DataBaseAccess.getUrl();
    final private String pass = DataBaseAccess.getPass();
    final private String user = DataBaseAccess.getUser();

    @Override
    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT * FROM locations";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Location location = new Location();
                location.setCode(rs.getInt("code"));
                location.setCountry(rs.getString("country"));
                location.setName(rs.getString("name"));
                location.setRegion(rs.getString("region"));
                locations.add(location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    //region Add/Delete
    @Override
    public void addLocation(Location location) {
        String sql = "INSERT INTO locations (name, country, region, code) VALUES (?,?,?,?)";
        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,location.getName());
                pstmt.setString(2,location.getCountry());
                pstmt.setString(3,location.getRegion());
                pstmt.setInt(4,location.getCode());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteLocation(int locationCode) {
        String sql = "DELETE FROM locations WHERE code = ?";
        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,locationCode);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //endregion
}
