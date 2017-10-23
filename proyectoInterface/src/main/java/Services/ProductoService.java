package Services;

import Beans.ProductoBean;
import Beans.ReplyBean;
import Connection.BoneCPImpl;
import Dao.ProductoDao;
import Helper.AppConfigurationHelper;
import Helper.ParameterCook;
import Static.Log4jStatic;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julian
 */
public class ProductoService implements EmptyServiceInterface, ViewServiceInterface, TableServiceInterface {

    HttpServletRequest oRequest = null;

    public ProductoService(HttpServletRequest request) {
        oRequest = request;
    }

    @Override
    public ReplyBean get() throws Exception {
        int id = Integer.parseInt(oRequest.getParameter("id"));
        Connection oConnection = null;
        ReplyBean oReplyBean = null;
        try {
            oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
            ProductoBean oBean = new ProductoBean(id);
            ProductoDao oDao = new ProductoDao(oConnection);
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
    }

    @Override
    public ReplyBean set() throws Exception {
        String json = oRequest.getParameter("json");
        Connection oConnection = null;
        ReplyBean oReplyBean = null;
        ProductoBean oBean = new ProductoBean();
        Gson oGson = new Gson();
        oBean = oGson.fromJson(json, oBean.getClass());
        int iResult = 0;
        try {
            oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
            ProductoDao oDao = new ProductoDao(oConnection);
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
    }

    @Override
    public ReplyBean remove() throws Exception {
        int id = Integer.parseInt(oRequest.getParameter("id"));
        int iResult = 0;
        Connection oConnection = null;
        ReplyBean oReplyBean = null;
        try {
            oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
            ProductoDao oDao = new ProductoDao(oConnection);
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
    }

    @Override
    public ReplyBean getcount() throws Exception {
        Long lResult;
        Connection oConnection = null;
        ReplyBean oReplyBean = null;
        try {
            oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
            ProductoDao oDao = new ProductoDao(oConnection);
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
    }

    @Override
    public ReplyBean getpage() throws Exception {
        int np = Integer.parseInt(oRequest.getParameter("np"));
        int rpp = Integer.parseInt(oRequest.getParameter("rpp"));
        String strOrder = oRequest.getParameter("order");
        LinkedHashMap<String, String> hmOrder = ParameterCook.getOrderParams(strOrder);
        Connection oConnection = null;
        ReplyBean oReplyBean = null;
        ArrayList<ProductoBean> aloBean = null;
        try {
            oConnection = AppConfigurationHelper.getSourceConnection().newConnection();
            ProductoDao oDao = new ProductoDao(oConnection);
            aloBean = oDao.getpage(rpp, np, hmOrder);
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
    }
}
