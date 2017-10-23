package Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Julian
 */

public class HikariCPImpl implements ConnectionInterface {

    private HikariDataSource connectionPool = null;

    @Override
    public Connection newConnection() throws Exception {

        Connection c = null;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://192.168.122.26:3306/usuariodb");
        config.setUsername("root");
        config.setPassword("admin");

        connectionPool = new HikariDataSource(config);

        try {
            c = connectionPool.getConnection();
        } catch (SQLException ex) {
            
        }
        return c;
    }

    @Override
    public void disposeConnection() throws Exception {
        if (connectionPool != null) {
            connectionPool.close();
        }
    }
}
