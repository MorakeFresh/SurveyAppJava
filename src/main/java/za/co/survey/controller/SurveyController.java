package za.co.survey.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.survey.dao.impl.SurveyDaoImpl;
import za.co.survey.dao.impl.UserDaoImpl;
import za.co.survey.db.manager.DBManager;
import za.co.survey.service.impl.SurveyServiceImpl;

@WebServlet(name = "SurveyController", urlPatterns = {"/SurveyController"})
public class SurveyController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProcessRequest pr = RequestActionFactorySurvey.createProcess(request);
        if (pr != null) {
            pr.processTheRequest(request, response);
            pr.processTheResponse(request, response);
        }
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

abstract class RequestActionFactorySurvey {

    public static ProcessRequest createProcess(HttpServletRequest request) {

        DBManager dbManager = null;
        ServletContext sc = request.getServletContext();
        if (sc != null) {
            dbManager = (DBManager) sc.getAttribute("dbman");
        }
        if (dbManager == null) {
            return null;
        }

        return new SurveyServiceImpl(SurveyDaoImpl.getInstance(dbManager.getConnection()), UserDaoImpl.getInstance(dbManager.getConnection()));

    }
}
