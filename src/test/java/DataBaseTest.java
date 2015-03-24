import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class DataBaseTest {
    private static Logger LOGGER = Logger.getLogger(DataBaseTest.class.getName());

    @Test(enabled = false)
    public void testAdminName() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager
                .getConnection("jdbc:mysql://sql5.freesqldatabase.com/sql561932?"
                        + "user=sql561932" +
                        "&password=bZ5%25sK2%2A");
        //password encoded. Decoded password is - bZ5%sK2*


        Statement statement = connect.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM `ecm_projects`");

        while (rs.next()) {

            String name = rs.getString("description");
            int createdate = rs.getInt("creationtime");
            LOGGER.info(name + " " + createdate);
        }

    }
}
