import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseTest {

    @Test
    @Ignore
    public void testAdminName() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager
                .getConnection("jdbc:mysql://localhost/ecm?"
                        + "user=root" +
                        "&password=");


        Statement statement = connect.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM `ecm_projects`");

        while (rs.next()) {

            String name = rs.getString("description");
            int createdate = rs.getInt("creationtime");
            System.out.println(name + " " + createdate);
        }

    }
}
