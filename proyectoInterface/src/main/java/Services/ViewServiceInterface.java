package Services;

import Beans.ReplyBean;

/**
 *
 * @author Julian
 */

public interface ViewServiceInterface {

    public ReplyBean getpage() throws Exception;

    public ReplyBean getcount() throws Exception;
}
