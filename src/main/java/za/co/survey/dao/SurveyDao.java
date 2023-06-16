package za.co.survey.dao;

import java.util.List;
import za.co.survey.model.Survey;

public interface SurveyDao {

    public List<Survey> allSurveys();

    public boolean addSurvey(Survey survey);
}
