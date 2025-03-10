import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class UserRepoDB implements UserRepository {

    private JdbcUtils dbUtils;


    private static final Logger logger = LogManager.getLogger();

    public UserRepoDB(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ", props);
        dbUtils = new JdbcUtils(props);
    }

    @Override
    public List<User> findByName(String nume) {
        Connection con = dbUtils.getConnection();
        List<User> users = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from users wherename =?")) {
            preStmt.setString(1, nume);
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int cnp = result.getInt("CNP");
                    String name = result.getString("name");
                    Date date = (java.util.Date) result.getDate("dateOfBirth");
                    int height = result.getInt("height");
                    User user = new User(cnp, name, date, height);
                    users.add(user);
                }
            }
        } catch (SQLException e) {

            System.err.println("Error DB " + e);
        }
        return users;
    }

    @Override
    public List<User> findBetweenHeight(int min, int max) {
        Connection con = dbUtils.getConnection();
        List<User> users = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from users where height > ? and height < ?")) {
            preStmt.setInt(1, min);
            preStmt.setInt(2, max);

            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int cnp = result.getInt("CNP");
                    String name = result.getString("name");
                    Date date = (java.util.Date) result.getDate("dateOfBirth");
                    int height = result.getInt("height");
                    User user = new User(cnp, name, date, height);
                    users.add(user);
                }
            }
        } catch (SQLException e) {

            System.err.println("Error DB " + e);
        }
        return users;
    }


    @Override
    public void add(User elem) {
        //Logger.traceEntry("saving task {}",elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("insert into users (CNP, name,dateOfBirth,height) values (?,?,?,?)")) {
            java.sql.Date dt = (java.sql.Date) elem.getBirthday();
            preStmt.setInt(1, elem.getCNP());
            preStmt.setString(2, elem.getName());
            preStmt.setDate(3, dt);
            preStmt.setInt(4, elem.getHeight());

            int result = preStmt.executeUpdate();
        } catch (SQLException ex) {

            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public void update(Integer integer, User elem) {
        //to do
    }


    @Override
    public Iterable<User> findAll() {
        Connection con = dbUtils.getConnection();
        List<User> users = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from users")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int cnp = result.getInt("CNP");
                    String name = result.getString("name");
                    Date date = (java.util.Date) result.getDate("dateOfBirth");
                    int height = result.getInt("height");
                    User user = new User(cnp, name, date, height);
                    users.add(user);
                }
            }
        } catch (SQLException e) {

            System.err.println("Error DB " + e);
        }
        return users;
    }
}
