package Helper;

import static java.lang.Math.ceil;

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
}
