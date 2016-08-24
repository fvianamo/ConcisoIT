/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RouteDAO;
import dao.StopDAO;
import db.DBUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Route;
import model.Stop;

/**
 *
 * @author filipeviana_
 */
public class add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        DBUtils dbManager = new DBUtils();
        
        RouteDAO routeManager = new RouteDAO(dbManager);
        StopDAO stopManager = new StopDAO(dbManager);
        
        List<Route> allRoutes = routeManager.getAllRoutes();
        List<Stop> allStops = stopManager.getAllStops();
        
        StringBuilder routeSelector = new StringBuilder();
        StringBuilder stopSelector = new StringBuilder();
        
        for(int i = 0; i < allRoutes.size();i++){
            routeSelector.append("<option>" + allRoutes.get(i).getRouteID() + "</option>\n" );
        }
        for(int i = 0; i < allStops.size(); i++){
            stopSelector.append("<option>" + allStops.get(i).getStopID() + "</option>\n");
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet add</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2>Adicionar Ônibus</h2>");
            //formulario de adicionar onibus
            out.println("<form action=\"addBus\" method=\"POST\">\n" +
"            <table border=\"0\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>Placa</td>\n" +
"                        <td><input type=\"text\" name=\"licensePlate\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>Rota</td>\n" +
"                        <td><select name=\"routeID\">\n" +
                         routeSelector + //seletor de rotaID
"                            </select></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td></td>\n" +
"                        <td><input type=\"submit\" value=\"Adicionar\" /></td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </form>");
            
            out.println("<h2>Adicionar rota</h2>");
            //formulario de adicionar rota
            out.println("<form action=\"addRoute\" method=\"POST\">\n" +
"            <table border=\"0\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>Nome</td>\n" +
"                        <td><input type=\"text\" name=\"name\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td></td>\n" +
"                        <td><input type=\"submit\" value=\"Adicionar\" /></td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </form>");
            
            out.println("<h2>Adicionar Parada</h2>");
            //formulario pra adicionar Parada
            out.println("<form action=\"addStop\" method=\"POST\">\n" +
"            <table border=\"0\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>Latitude</td>\n" +
"                        <td><input type=\"text\" name=\"latitude\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>Longitude</td>\n" +
"                        <td><input type=\"text\" name=\"longitude\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td></td>\n" +
"                        <td><input type=\"submit\" value=\"Adicionar\" /></td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </form>");
            
            out.println("<h2>Adicionar Relação</h2>");
            out.println("<form action=\"addRelation\" method=\"POST\">\n" +
"            <table border=\"0\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>Rota</td>\n" +
"                        <td><select name=\"rotaID\">\n" +
                         routeSelector +//rotaId selector
"                            </select></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>Parada</td>\n" +
"                        <td><select name=\"stopID\">\n" +
                         stopSelector +//stopID Selector
"                            </select></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td></td>\n" +
"                        <td><input type=\"submit\" value=\"Adicionar\" /></td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </form>");
            
            out.println("<br><form method=\"post\" action=\"listAll\"><input type=\"submit\" value=\"Voltar\"></form>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
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
