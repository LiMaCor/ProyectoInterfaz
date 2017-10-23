package Helper;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julian
 */

public class ParameterCook {

    public static String prepareCamelCaseObject(HttpServletRequest request) {
        String result = null;
        if (request.getParameter("ob") == null) {
            result = "Usuario";
        } else {
            result = Character.toUpperCase(request.getParameter("ob").charAt(0)) + request.getParameter("ob").substring(1);
        }
        return result;
    }
}
