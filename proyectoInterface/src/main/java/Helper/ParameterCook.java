package Helper;

import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julian
 */
public class ParameterCook {

    public static String prepareCamelCaseObject(HttpServletRequest request) {
        String result = null;
        if (request.getParameter("ob") == null) {
            result = null;
        } else {
            result = Character.toUpperCase(request.getParameter("ob").charAt(0)) + request.getParameter("ob").substring(1);
        }
        return result;
    }

    public static LinkedHashMap<String, String> getOrderParams(String strOrder) {
        LinkedHashMap<String, String> oHMOrder = new LinkedHashMap<String, String>();
        if (strOrder != null && strOrder.length() > 0) {
            String[] arrOrderSplit1 = strOrder.split(" ");
            for (String s : arrOrderSplit1) {
                String[] arrOrderSplit2 = s.split(",");
                if (s.contains(",")) {
                    if ("asc".equalsIgnoreCase(arrOrderSplit2[1])) {
                        oHMOrder.put(arrOrderSplit2[0], "ASC");
                    } else {
                        oHMOrder.put(arrOrderSplit2[0], "DESC");
                    }
                } else {
                    oHMOrder.put(arrOrderSplit2[0], "ASC");
                }
            }
        } else {
            oHMOrder = null;
        }
        return oHMOrder;
    }

}
