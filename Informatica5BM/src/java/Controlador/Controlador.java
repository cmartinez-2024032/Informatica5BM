package Controlador;

import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.Zapato;
import Modelo.ZapatoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Zapato zapato = new Zapato();
    ZapatoDAO zapatoDAO = new ZapatoDAO();
    Venta venta = new Venta();
    VentaDAO ventaDAO = new VentaDAO();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }

        if(menu != null){
            switch (menu) {
                case "Zapato":
                    switch (accion) {
                        case "Listar":
                            List listaZapato = zapatoDAO.listar();
                            request.setAttribute("zapatos", listaZapato);
                            break;
                            case "Agregar":
                            String modelo = request.getParameter("txtModelo");
                            String tallaStr = request.getParameter("txtTalla");
                            String color = request.getParameter("txtColor");
                            String precioStr = request.getParameter("txtPrecio");
                            String stockStr = request.getParameter("txtStock");

                            zapato.setModelo(modelo);
                            zapato.setTalla(Integer.parseInt(tallaStr));
                            zapato.setColor(color);
                            zapato.setPrecio(Double.parseDouble(precioStr));
                            zapato.setStock(Integer.parseInt(stockStr));
                            zapatoDAO.agregar(zapato);
                            request.getRequestDispatcher("Controlador?menu=Zapato&accion=Listar").forward(request, response);
                            break;

                        case "Editar":
                        int codigoZapato = Integer.parseInt(request.getParameter("codigoZapato"));
                        Zapato z = zapatoDAO.listarCodigoPorZapato(codigoZapato);
                        request.setAttribute("zapato", z);
                        request.getRequestDispatcher("zapato.jsp").forward(request, response);
                        break;
                        case "Actualizar":
                    int codigoZapatoActualizar = Integer.parseInt(request.getParameter("txtCodigoZapato"));
                    String modeloActualizar = request.getParameter("txtModelo");
                    int tallaActualizar = Integer.parseInt(request.getParameter("txtTalla"));
                    String colorActualizar = request.getParameter("txtColor");
                    double precioActualizar = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stockActualizar = Integer.parseInt(request.getParameter("txtStock"));
                    zapato.setCodigoZapato(codigoZapatoActualizar);
                    zapato.setModelo(modeloActualizar);
                    zapato.setTalla(tallaActualizar);
                    zapato.setColor(colorActualizar);
                    zapato.setPrecio(precioActualizar);
                    zapato.setStock(stockActualizar);
                    zapatoDAO.actualizar(zapato);
                    response.sendRedirect("Controlador?menu=Zapato&accion=Listar");
                    break;
                    case "Eliminar":
                        int codigoZapatoEliminar = Integer.parseInt(request.getParameter("codigoZapato"));
                        zapatoDAO.eliminar(codigoZapatoEliminar);
                        response.sendRedirect("Controlador?menu=Zapato&accion=Listar");
                        break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("zapato.jsp").forward(request, response);
                    break;
                     case "Venta":
                    switch (accion) {
                        case "Listar":
                            List listaVenta = ventaDAO.listar();
                            request.setAttribute("ventas", listaVenta);
                            break;
                            case "Agregar":
                            String codZapatoStr = request.getParameter("txtCodigoZapato");

                            venta.setCodigoZapato(Integer.parseInt(codZapatoStr));

                            ventaDAO.agregar(venta);
                            request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);
                            break;

                        case "Actualizar":
                            break;
                        case "Eliminar":
                            break;
                        case "Buscar":
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("venta.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
