package Helper;


public class ConnectionClassHelper {
    
    public static String getDatabaseName() {
        return "usuariodb";
    }

    public static String getDatabaseLogin() {
        return "root";
    }

    public static String getDatabasePassword() {
        return "admin";
    }

    public static String getDatabasePort() {
        return "3306";
    }

    public static String getDatabaseIP() {
        return "192.168.122.26";
    }

    public static String getConnectionChain() {
        return "jdbc:mysql://" + ConnectionClassHelper.getDatabaseIP() + ":" + ConnectionClassHelper.getDatabasePort() + "/" + ConnectionClassHelper.getDatabaseName();
    }

}
