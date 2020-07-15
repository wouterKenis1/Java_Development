import java.sql.*;

public class BeerDAO {
    private String url;
    private String user;
    private String pass;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    public Beer getBeerById(int index){
        try(Connection con = DriverManager.getConnection(url,user,pass);
            Statement stmt = con.createStatement();
        ){
            try(ResultSet rs = stmt.executeQuery("SELECT * FROM Beers WHERE ID = " + index)){
                if(rs.next()){
                    Beer beer = new Beer();
                    beer.setId(rs.getInt("id"));
                    beer.setName(rs.getString("Name"));
                    beer.setBrewerId(rs.getInt("brewerId"));
                    beer.setCategoryId(rs.getInt("categoryId"));
                    beer.setPrice(rs.getFloat("price"));
                    beer.setStock(rs.getInt("Stock"));
                    beer.setAlcohol(rs.getFloat("alcohol"));
                    beer.setVersion(rs.getInt("version"));
                    return beer;
                }
            }

        }catch(Exception e){
            System.out.println("getting beer failed!");
            e.printStackTrace();
        }

        return null;
    }

    public void updateBeer(Beer beer){
        try(Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = con.prepareStatement("UPDATE Beers SET Name = ?, BrewerId = ?, CategoryId = ?, Price = ?, Stock = ?, Alcohol = ?, Version = ? WHERE id = ?" );
        ){

            pstmt.setString(1,beer.name);
            pstmt.setInt(2,beer.brewerId);
            pstmt.setInt(3,beer.categoryId);
            pstmt.setFloat(4,beer.price);
            pstmt.setInt(5,beer.stock);
            pstmt.setFloat(6,beer.alcohol);
            pstmt.setInt(7,beer.version);
            pstmt.setInt(8,beer.id);
            pstmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       BeerDAO dao = new BeerDAO();
        dao.setUrl("jdbc:mysql://localhost:3306/beersdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dao.setUser("root");
        dao.setPass("SnOtTe9BeL");

        Beer a = dao.getBeerById(4);

        System.out.println(a.id);
        System.out.println(a.name);
        System.out.println(a.brewerId);
        System.out.println(a.categoryId);

        System.out.println("---");

        a.name = "A.C.O";

        dao.updateBeer(a);
        System.out.println(a.id);
        System.out.println(a.name);
        System.out.println(a.brewerId);
        System.out.println(a.categoryId);

    }

}
