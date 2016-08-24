/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.*;
import dao.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author filipeviana_
 */
public class listAll extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        DBUtils dbManager = new DBUtils();
        
        BusDAO busManager = new BusDAO(dbManager);
        StopDAO stopManager = new StopDAO(dbManager);
        RelationDAO relationManager = new RelationDAO(dbManager);
        RouteDAO routeManager = new RouteDAO(dbManager);
        
        List<Bus> busList = busManager.getAllBuses();
        List<Route> routeList = routeManager.getAllRoutes();
        List<Stop> stopList = stopManager.getAllStops();
        List<Relation> relationList = relationManager.getAllRelations();
        
        //google API Key = AIzaSyAYSOWTxFQSmagCt1OKibMI8E_SCtSlHoo
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            out.println("<meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>Main</title>");
            out.println("<style>\n" +
"      html, body {\n" +
"        height: 100%;\n" +
"        margin: 0;\n" +
"        padding: 0;\n" +
"      }\n" +
"      #map {\n" +
"        height: 100%;\n" +                    
"      }\n" +
"    </style>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<center><h1>lista</h1></center>");
            
            out.println("<h2>Ônibus cadastrados</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>id</td><td>Placa</td><td>Rota</td>");
            out.println("</tr>");
            
            for(int i = 0; i < busList.size(); i++){
                out.println("<tr>");
                out.println("<td>" + busList.get(i).getBusID() + "</td><td>" + busList.get(i).getLicensePlate() + "</td><td>" + busList.get(i).getRouteFK()+ "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            
            out.println("<h2>Rotas de Ônibus cadastrados</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>id</td><td>nome</td>");
            out.println("</tr>");
            for(int i = 0; i < routeList.size(); i++){
                out.println("<tr>");
                out.println("<td>" + routeList.get(i).getRouteID() + "</td><td>" + routeList.get(i).getName() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("<h2>Paradas de Ônibus cadastrados</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>id</td><td>latitude</td><td>longitude</td>");
            out.println("</tr>");
            for(int i = 0; i < stopList.size(); i++){
                out.println("<tr>");
                out.println("<td>" + stopList.get(i).getStopID()+ "</td><td>" + stopList.get(i).getLatit()+ "</td><td>" + stopList.get(i).getLongi()+ "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("<h2>Relações de pertinência Parada Rota</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>id</td><td>rota</td><td>parada</td>");
            out.println("</tr>");
            for(int i = 0; i < relationList.size(); i++){
                out.println("<tr>");
                out.println("<td>" + relationList.get(i).getRelationID()+ "</td><td>" + relationList.get(i).getRouteID()+ "</td><td>" + relationList.get(i).getStopID()+ "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("<br><form method=\"post\" action=\"add\"><input type=\"submit\" value=\"Adicionar\"></form>\n" +
"        <form method=\"post\" action=\"remove\"><input type=\"submit\" value=\"Remover\"></form>\n" +
"        <form method=\"post\" action=\"update\"><input type=\"submit\" value=\"Atualizar\"></form>");
            
            //exemplo de uso googleMaps API - Simple Markers
            out.println("<div id=\"map\"></div>\n" +
"    <script>\n" +
"\n" +
"      function initMap() {\n" +
"        var myLatLng = {lat: -25.363, lng: 131.044};\n" +
"\n" +
"        var map = new google.maps.Map(document.getElementById('map'), {\n" +
"          zoom: 4,\n" +
"          center: myLatLng\n" +
"        });\n" +
"\n" +
"        var marker = new google.maps.Marker({\n" +
"          position: myLatLng,\n" +
"          map: map,\n" +
"          title: 'Hello World!'\n" +
"        });\n" +
"      }\n" +
"    </script>\n" +
"    <script async defer\n" +
"    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAYSOWTxFQSmagCt1OKibMI8E_SCtSlHoo&callback=initMap\">\n" +
"    </script>");
            
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
            Logger.getLogger(listAll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listAll.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(listAll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listAll.class.getName()).log(Level.SEVERE, null, ex);
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
