package etu2063.framework.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;

public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> mappingUrl = new HashMap<String, Mapping>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String url = request.getRequestURL().toString();
        String[] urlt = url.split("/");
        url = "";
       for (int i = 5; i < urlt.length; i++) {
            url += urlt[i];
        }
        String requete = request.getQueryString();
        if (requete != null) {
            url = url + "?" + requete;
        }
        out.println(url);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}