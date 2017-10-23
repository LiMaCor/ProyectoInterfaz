package Services;

import Beans.ReplyBean;
import Beans.UsuarioBean;
import Connection.BoneCPImpl;
import Connection.HikariCPImpl;
import Connection.JdbcImpl;
import Dao.UsuarioDao;
import Helper.AppConfigurationHelper;
import Helper.ParameterCook;
import Static.Log4jStatic;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julian
 */
public class UsuarioService implements ViewServiceInterface, EmptyServiceInterface, TableServiceInterface {

    HttpServletRequest oRequest = null;

    public UsuarioService(HttpServletRequest request) {
        oRequest = request;
    }

    private Boolean checkPermission(String strMethodName) throws Exception {
        UsuarioBean oUsuarioBean = (UsuarioBean) oRequest.getSession().getAttribute("user");
        if (oUsuarioBean != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * http://127.0.0.1:8081/conexion/json?ob=usuario&op=get&id=1
     *
     * @return ReplyBean
     * @throws Exception
     */
    @Override
    public ReplyBean get() throws Exception {
        if (this.checkPermission("get")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            Connection oConnection = null;
            ReplyBean oReplyBean = null;
            try {
                oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
                UsuarioBean oBean = new UsuarioBean(id);
                UsuarioDao oDao = new UsuarioDao(oConnection);
                oBean = oDao.get(oBean, AppConfigurationHelper.getJsonMsgDepth());
                Gson oGson = new Gson();
                String strJson = oGson.toJson(oBean);
                oReplyBean = new ReplyBean(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jStatic.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (AppConfigurationHelper.getSourceConnection() != null) {
                    AppConfigurationHelper.getSourceConnection().disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBean(401, "Unauthorized operation");
        }
    }

    /**
     * http://127.0.0.1:8081/conexion/json?ob=usuario&op=set&id=1
     *
     * @return @throws Exception
     */
    @Override
    public ReplyBean set() throws Exception {
        if (this.checkPermission("set")) {
            String json = oRequest.getParameter("json");
            Connection oConnection = null;
            ReplyBean oReplyBean = null;
            UsuarioBean oBean = new UsuarioBean();
            Gson oGson = new Gson();
            oBean = oGson.fromJson(json, oBean.getClass());
            int iResult = 0;
            try {
                oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
                UsuarioDao oDao = new UsuarioDao(oConnection);
                iResult = oDao.set(oBean);
                String strJson = oGson.toJson(iResult);
                oReplyBean = new ReplyBean(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jStatic.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (AppConfigurationHelper.getSourceConnection() != null) {
                    AppConfigurationHelper.getSourceConnection().disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBean(401, "Unauthorized operation");
        }
    }

    /**
     * http://127.0.0.1:8081/conexion/json?ob=usuario&op=remove&id=1
     *
     * @return ReplyBean
     * @throws Exception
     */
    @Override
    public ReplyBean remove() throws Exception {
        if (this.checkPermission("remove")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            int iResult = 0;
            Connection oConnection = null;
            ReplyBean oReplyBean = null;
            try {
                oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
                UsuarioDao oDao = new UsuarioDao(oConnection);
                iResult = oDao.remove(id);
                Gson oGson = new Gson();
                String strJson = oGson.toJson(iResult);
                oReplyBean = new ReplyBean(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jStatic.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (AppConfigurationHelper.getSourceConnection() != null) {
                    AppConfigurationHelper.getSourceConnection().disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBean(401, "Unauthorized operation");
        }

    }

    /**
     * http://127.0.0.1:8081/conexion/json?ob=usuario&op=getcount
     *
     * @return ReplyBean
     * @throws Exception
     */
    @Override
    public ReplyBean getcount() throws Exception {
        if (this.checkPermission("getcount")) {
            Long lResult;
            Connection oConnection = null;
            ReplyBean oReplyBean = null;
            try {
                oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
                UsuarioDao oDao = new UsuarioDao(oConnection);
                lResult = oDao.getcount();
                Gson oGson = new Gson();
                String strJson = oGson.toJson(lResult);
                oReplyBean = new ReplyBean(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jStatic.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (AppConfigurationHelper.getSourceConnection() != null) {
                    AppConfigurationHelper.getSourceConnection().disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBean(401, "Unauthorized operation");
        }
    }

    /**
     * http://127.0.0.1:8081/conexion/json?ob=usuario&op=getpage
     *
     * @return ReplyBean
     * @throws Exception
     */
    @Override
    public ReplyBean getpage() throws Exception {
        if (this.checkPermission("getpage")) {
            int numeroPaginas = Integer.parseInt(oRequest.getParameter("np"));
            int registrosPorPagina = Integer.parseInt(oRequest.getParameter("rpp"));
            String strOrder = oRequest.getParameter("order");
            LinkedHashMap<String, String> hmOrder = ParameterCook.getOrderParams(strOrder);
            Connection oConnection = null;
            ReplyBean oReplyBean = null;
            ArrayList<UsuarioBean> aloBean = null;
            try {
                oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
                UsuarioDao oDao = new UsuarioDao(oConnection);
                aloBean = oDao.getpage(registrosPorPagina, numeroPaginas, hmOrder);
                Gson oGson = new Gson();
                String strJson = oGson.toJson(aloBean);
                oReplyBean = new ReplyBean(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jStatic.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (AppConfigurationHelper.getSourceConnection() != null) {
                    AppConfigurationHelper.getSourceConnection().disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBean(401, "Unauthorized operation");
        }
    }

    public ReplyBean login() throws Exception {
        Connection oConnection = null;
        ReplyBean oReplyBean = null;
        UsuarioBean oUsuarioBean = new UsuarioBean();
        oUsuarioBean.setLogin(oRequest.getParameter("user"));
        oUsuarioBean.setPass(oRequest.getParameter("pass"));
        if (!oUsuarioBean.getLogin().equalsIgnoreCase("") && !oUsuarioBean.getPass().equalsIgnoreCase("")) {
            try {
                oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
                UsuarioDao oDao = new UsuarioDao(oConnection);
                oUsuarioBean = oDao.getFromLoginAndPass(oUsuarioBean);
                HttpSession oSession = oRequest.getSession();
                oSession.setAttribute("user", oUsuarioBean);
                Gson oGson = AppConfigurationHelper.getGson();
                String strJson = oGson.toJson(oUsuarioBean);
                oReplyBean = new ReplyBean(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jStatic.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (AppConfigurationHelper.getSourceConnection() != null) {
                    AppConfigurationHelper.getSourceConnection().disposeConnection();
                }
            }
        }
        return oReplyBean;
    }

    public ReplyBean logout() throws Exception {
        HttpSession oSession = oRequest.getSession();
        oSession.invalidate();
        ReplyBean oReplyBean = new ReplyBean(200, "Session is closed");
        return oReplyBean;
    }

    public ReplyBean check() throws Exception {
        ReplyBean oReplyBean = null;
        UsuarioBean oUsuarioBean = null;
        try {
            HttpSession oSession = oRequest.getSession();
            oUsuarioBean = (UsuarioBean) oSession.getAttribute("user");
            Gson oGson = AppConfigurationHelper.getGson();
            String strJson = oGson.toJson(oUsuarioBean);
            oReplyBean = new ReplyBean(200, strJson);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jStatic.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }

        return oReplyBean;
    }

}