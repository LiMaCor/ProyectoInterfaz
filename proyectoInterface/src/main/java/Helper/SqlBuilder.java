package Helper;

import static java.lang.Math.ceil;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Julian
 */

public class SqlBuilder {
     
    public static String buildSqlLimit(Long intRegistrosTotales, Integer intRegistrosPorPagina,
             Integer intNumeroPagina) {
        String SQLLimit = "";
        if (intRegistrosPorPagina > 0 && intRegistrosPorPagina < 10000) {
            if (intNumeroPagina > 0 && intNumeroPagina <= (ceil(intRegistrosTotales / intRegistrosPorPagina))) {                                                          
                SQLLimit = " LIMIT " + (intNumeroPagina - 1) * intRegistrosPorPagina + " , " + intRegistrosPorPagina;
            }
        }
        return SQLLimit;
    }
     
     public static String buildSqlOrder(LinkedHashMap<String, String> hmOrder) {
        String strSQLOrder = "";
        if (hmOrder != null) {
            for (Map.Entry<String, String> entry : hmOrder.entrySet()) {
                strSQLOrder += entry.getKey();
                strSQLOrder += " ";
                strSQLOrder += entry.getValue();
                strSQLOrder += ",";                
            }
            strSQLOrder = " ORDER BY " + strSQLOrder.substring(0, strSQLOrder.length() - 1);
        }
        return strSQLOrder;
    }
     
}
