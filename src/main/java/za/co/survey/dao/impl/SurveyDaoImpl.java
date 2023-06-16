package za.co.survey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.survey.dao.SurveyDao;
import za.co.survey.model.Survey;

public class SurveyDaoImpl implements SurveyDao {

    private static SurveyDaoImpl surveyDaoImpl = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private SurveyDaoImpl(Connection con) {
        this.con = con;
    }

    public static SurveyDaoImpl getInstance(Connection dbCon) {
        if (surveyDaoImpl == null) {
            surveyDaoImpl = new SurveyDaoImpl(dbCon);
        }

        return surveyDaoImpl;
    }

    @Override
    public List<Survey> allSurveys() {
        List<Survey> surveyList = new ArrayList<>();

        if (con == null) {
            return surveyList;
        }

        try {
            ps = con.prepareStatement("SELECT surveyId,pizza,pasta,papnWors,chicken,beef,other,eatOut,movies,tv,radio FROM surveydata");
            rs = ps.executeQuery();

            while (rs.next()) {
                surveyList.add(new Survey(rs.getInt("surveyId"), rs.getInt("pizza"), rs.getInt("pasta"), rs.getInt("papnWors"), rs.getInt("chicken"), rs.getInt("beef"), rs.getInt("other"), rs.getInt("eatOut"), rs.getInt("movies"), rs.getInt("tv"), rs.getInt("radio")));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return surveyList;
    }

    @Override
    public boolean addSurvey(Survey survey) {
        boolean add = false;
        
        if(con == null){
            return add;
        }
        
        try{
            ps = con.prepareStatement("INSERT INTO surveydata(pizza,pasta,papnWors,chicken,beef,other,eatOut,movies,tv,radio) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, survey.getPizza());
            ps.setInt(2, survey.getPasta());
            ps.setInt(3, survey.getPapnWors());
            ps.setInt(4, survey.getChicken());
            ps.setInt(5, survey.getBeef());
            ps.setInt(6, survey.getOther());
            ps.setInt(7, survey.getEatOut());
            ps.setInt(8, survey.getMovies());
            ps.setInt(9, survey.getTv());
            ps.setInt(10, survey.getRadio());
            
            
            if(ps.executeUpdate() > 0){
                add = true;
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }

        return add;
    }

}
