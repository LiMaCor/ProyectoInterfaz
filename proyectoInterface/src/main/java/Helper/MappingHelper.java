package Helper;

import Beans.ReplyBean;
import Services.PedidoService;
import Services.ProductoService;
import Services.TipoUsuarioService;
import Services.UsuarioService;
import javax.servlet.http.HttpServletRequest;

public class MappingHelper {

    public static ReplyBean executeMethodService(HttpServletRequest oRequest) throws Exception {
        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");
        ReplyBean oReplyBean = null;
        switch (ob) {
            case "usuario":
                UsuarioService oUsuarioService = new UsuarioService(oRequest);
                switch (op) {
                    case "get":
                        oReplyBean = oUsuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oUsuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oUsuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oUsuarioService.getpage();
                        break;
                    case "getcount":
                        oReplyBean = oUsuarioService.getcount();
                        break;
                    case "login":
                        oReplyBean = oUsuarioService.login();
                        break;
                    case "logout":
                        oReplyBean = oUsuarioService.logout();
                        break;
                    case "check":
                        oReplyBean = oUsuarioService.check();
                        break;
                    case "getpagextipousuario":
                        oReplyBean = oUsuarioService.getpagextipousuario();
                        break;
                    case "getcountxtipousuario":
                        oReplyBean = oUsuarioService.getcountxtiposuario();
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Operation not found : Please contact your administrator");
                        break;
                }
                break;
            case "tipousuario":
                TipoUsuarioService oTipoUsuarioService = new TipoUsuarioService(oRequest);
                switch (op) {
                    case "get":
                        oReplyBean = oTipoUsuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oTipoUsuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipoUsuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipoUsuarioService.getpage();
                        break;
                    case "getcount":
                        oReplyBean = oTipoUsuarioService.getcount();
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Operation not found : Please contact your administrator");
                        break;
                }
                break;
            case "pedido":
                PedidoService oPedidoService = new PedidoService(oRequest);
                switch (op) {
                    case "get":
                        oReplyBean = oPedidoService.get();
                        break;
                    case "set":
                        oReplyBean = oPedidoService.set();
                        break;
                    case "remove":
                        oReplyBean = oPedidoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oPedidoService.getpage();
                        break;
                    case "getcount":
                        oReplyBean = oPedidoService.getcount();
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Operation not found : Please contact your administrator");
                        break;
                }
                break;
            case "producto":
                ProductoService oProductoService = new ProductoService(oRequest);
                switch (op) {
                    case "get":
                        oReplyBean = oProductoService.get();
                        break;
                    case "set":
                        oReplyBean = oProductoService.set();
                        break;
                    case "remove":
                        oReplyBean = oProductoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProductoService.getpage();
                        break;
                    case "getcount":
                        oReplyBean = oProductoService.getcount();
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Operation not found : Please contact your administrator");
                        break;
                }
            default:
                oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oReplyBean;
    }
}
