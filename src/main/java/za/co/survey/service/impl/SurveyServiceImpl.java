package za.co.survey.service.impl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.survey.controller.ProcessRequest;
import za.co.survey.dao.SurveyDao;
import za.co.survey.dao.UserDao;
import za.co.survey.model.Survey;
import za.co.survey.model.User;
import za.co.survey.service.SurveyService;

public class SurveyServiceImpl implements SurveyService, ProcessRequest {

    private SurveyDao surveyDao;
    private UserDao userDao;
    private String surveyView;
    
    public SurveyServiceImpl() {
        this.surveyDao = surveyDao;
        this.userDao = userDao;
    }

    public SurveyServiceImpl(SurveyDao surveyDao, UserDao userDao) {
        this.surveyDao = surveyDao;
        this.userDao = userDao;
    }

    @Override
    public List<Survey> allSurveys() {
        return surveyDao != null ? surveyDao.allSurveys() : null;
    }

    @Override
    public boolean addSurvey(Survey survey) {
        return surveyDao != null ? surveyDao.addSurvey(survey) : null;
    }

    @Override
    public void processTheRequest(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("act");
        System.out.println(action);

        Survey survey = null;
        List<Survey> surveyList;
        List<User> userList = null;

        int pizza = 0;
        int pasta = 0;
        int papnWors = 0;
        int chicken = 0;
        int beef = 0;
        int other = 0;
        int eatOut = 0;
        int movies = 0;
        int tv = 0;
        int radio = 0;

        if (action != null) {
            action = action.toLowerCase().trim();

            switch (action) {
                //---------------------------------------Add survey to database-----------------------------------------------------
                case "addsurvey":
                    pizza = Integer.parseInt(request.getParameter("pizza"));
                    pasta = Integer.parseInt(request.getParameter("pasta"));
                    papnWors = Integer.parseInt(request.getParameter("papnWors"));
                    chicken = Integer.parseInt(request.getParameter("chicken"));
                    beef = Integer.parseInt(request.getParameter("beef"));
                    other = Integer.parseInt(request.getParameter("other"));
                    eatOut = Integer.parseInt(request.getParameter("eatOut"));
                    movies = Integer.parseInt(request.getParameter("movies"));
                    tv = Integer.parseInt(request.getParameter("tv"));
                    radio = Integer.parseInt(request.getParameter("radio"));
                    
                    if(addSurvey(new Survey(pizza,pasta,papnWors,chicken,beef,other,eatOut,movies,tv,radio))){
                        request.setAttribute("survey", "survey added");
                    }else{
                        request.setAttribute("ans", "survey not added");
                    }
                    
                    surveyView = "addsurvey.jsp";
                    break;
                   
                //--------------------------------------Get all surveys from database----------------------------------------------    
                case "getallsurveys":

                    surveyList = surveyDao.allSurveys();

                    if (surveyList != null && !surveyList.isEmpty()) {
                        request.setAttribute("allSurveys", surveyList);
                    } else {
                        request.setAttribute("ans", "No surveys found");
                    }
                    surveyView = "";
                    break;

                //--------------------------------------Get survey results---------------------------------------------    
                case "results":

                    System.out.println("inside");
                    surveyList = allSurveys();

                    if (surveyList != null && !surveyList.isEmpty()) {
                        System.out.println("got it");
                        request.setAttribute("allSurveys", surveyList);
                    } else {
                        request.setAttribute("ans", "No surveys found");
                    }

                    userList = userDao.getAllUsers();

                    if (userList != null && !userList.isEmpty()) {
                        System.out.println("got it");
                        request.setAttribute("allUsers", userList);
                    } else {
                        request.setAttribute("ans", "No users found");
                    }
                    surveyView = "results.jsp";
                    break;
            }
        }
    }

    @Override
    public void processTheResponse(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(surveyView);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.err.println("Error Dispatching View: " + ex.getMessage());
        }
    }

}
