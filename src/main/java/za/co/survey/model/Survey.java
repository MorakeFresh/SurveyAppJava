package za.co.survey.model;

public class Survey {
    
    private int surveyId;
    private int pizza;
    private int pasta;
    private int papnWors;
    private int chicken;
    private int beef;
    private int other;
    private int eatOut;
    private int movies;
    private int tv;
    private int radio;

    public Survey() {
    }

    public Survey(int surveyId, int pizza, int pasta, int papnWors, int chicken, int beef, int other, int eatOut, int movies, int tv, int radio) {
        this.surveyId = surveyId;
        this.pizza = pizza;
        this.pasta = pasta;
        this.papnWors = papnWors;
        this.chicken = chicken;
        this.beef = beef;
        this.other = other;
        this.eatOut = eatOut;
        this.movies = movies;
        this.tv = tv;
        this.radio = radio;
    }

    public Survey(int pizza, int pasta, int papnWors, int chicken, int beef, int other, int eatOut, int movies, int tv, int radio) {
        this.pizza = pizza;
        this.pasta = pasta;
        this.papnWors = papnWors;
        this.chicken = chicken;
        this.beef = beef;
        this.other = other;
        this.eatOut = eatOut;
        this.movies = movies;
        this.tv = tv;
        this.radio = radio;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getPizza() {
        return pizza;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    public int getPasta() {
        return pasta;
    }

    public void setPasta(int pasta) {
        this.pasta = pasta;
    }

    public int getPapnWors() {
        return papnWors;
    }

    public void setPapnWors(int papnWors) {
        this.papnWors = papnWors;
    }

    public int getChicken() {
        return chicken;
    }

    public void setChicken(int chicken) {
        this.chicken = chicken;
    }

    public int getBeef() {
        return beef;
    }

    public void setBeef(int beef) {
        this.beef = beef;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getEatOut() {
        return eatOut;
    }

    public void setEatOut(int eatOut) {
        this.eatOut = eatOut;
    }

    public int getMovies() {
        return movies;
    }

    public void setMovies(int movies) {
        this.movies = movies;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.surveyId;
        hash = 43 * hash + this.pizza;
        hash = 43 * hash + this.chicken;
        hash = 43 * hash + this.eatOut;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Survey other = (Survey) obj;
        if (this.surveyId != other.surveyId) {
            return false;
        }
        if (this.pizza != other.pizza) {
            return false;
        }
        if (this.chicken != other.chicken) {
            return false;
        }
        if (this.eatOut != other.eatOut) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Survey{" + "surveyId=" + surveyId + ", pizza=" + pizza + ", pasta=" + pasta + ", papnWors=" + papnWors + ", chicken=" + chicken + ", beef=" + beef + ", other=" + other + ", eatOut=" + eatOut + ", movies=" + movies + ", tv=" + tv + ", radio=" + radio + '}';
    }
    
    
}
