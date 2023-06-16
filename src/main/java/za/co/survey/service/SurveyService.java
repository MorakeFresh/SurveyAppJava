package za.co.survey.service;

import java.util.List;
import za.co.survey.model.Survey;

public interface SurveyService {

    public List<Survey> allSurveys();

    public boolean addSurvey(Survey survey);
}
