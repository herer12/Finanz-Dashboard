package finance.repository;

import at.herer12_erik_van_haentjens.logging.Logger;
import finance.config.Settings;
import finance.exception.ResourceNotFoundException;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static Logger logger = Logger.getLogger(ConnectionManager.class);

    private static Connection getConnection() {
        try(Connection connection = DriverManager.getConnection(Settings.getURL())) {
            return connection;
        }catch (Exception e){
            logger.fatal("Database connection failed:", e);
            throw new ResourceNotFoundException("Database connection failed");
        }
    }

    public static Jdbi getJDBI(){
        Jdbi jdbi = Jdbi.create(getConnection());
        jdbi.installPlugin(new SqlObjectPlugin());
        logger.info("JDBI initialized");
        return jdbi;
    }
}
