<%@page import="java.text.DecimalFormat"%>
<%@page import="za.co.survey.model.Survey"%>
<%@page import="za.co.survey.model.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey Results</title>
        <style>
            body {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                min-height: 100vh;
            }

            table {
                margin-top: 20px;
                border-spacing: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Survey Results</h1>

        <table>
                            <%
                    List<User> userList = (List<User>) request.getAttribute("allUsers");
                    if (userList != null && !userList.isEmpty()) {

                        DecimalFormat decimalFormat = new DecimalFormat("#.#");

                        int totalSum = 0;
                        int maxAge = Integer.MIN_VALUE;
                        int minAge = Integer.MAX_VALUE;
                        for (User user : userList) {
                            totalSum += user.getAge();

                            if (user.getAge() > maxAge) {
                                maxAge = user.getAge();
                            }

                            if (user.getAge() < minAge) {
                                minAge = user.getAge();
                            }
                        }

                        double averageAge = (double) totalSum / userList.size();

                %>

                <tr>
                    <td>Total number of surveys:</td>
                    <td><%= userList.size()%></td>
                </tr>

                <tr>
                    <td>Average age</td>
                    <td><%= decimalFormat.format(averageAge)%></td>
                </tr>
                <tr>
                    <td>Oldest person who participate in survey</td>
                    <td><%=maxAge%></td>
                </tr>
                <tr>
                    <td>Youngest person who participate in survey</td>
                    <td><%=minAge%></td>
                </tr>

                <%
                    }
                %>
        </table>

        <br>

        <table>
             <%
                    List<Survey> surveyList = (List<Survey>) request.getAttribute("allSurveys");
                    if (surveyList != null && !surveyList.isEmpty()) {

                        DecimalFormat decimalFormat = new DecimalFormat("#.#");

                        int pizzaCount = 0;
                        int pastaCount = 0;
                        int papnWorsCount = 0;
                        int totalEatOut = 0;
                        int totalMovies = 0;
                        int totalTv = 0;
                        int totalRadio = 0;

                        for (Survey survey : surveyList) {
                            if (survey.getPizza() == 1) {
                                pizzaCount++;
                            }

                            if (survey.getPasta() == 1) {
                                pastaCount++;
                            }

                            if (survey.getPapnWors() == 1) {
                                papnWorsCount++;
                            }

                            totalEatOut += survey.getEatOut();
                            totalMovies += survey.getMovies();
                            totalTv += survey.getTv();
                            totalRadio += survey.getRadio();
                        }

                        double pizzaPercentage = (double) pizzaCount / surveyList.size() * 100;
                        double pastaPercentage = (double) pastaCount / surveyList.size() * 100;
                        double papnWorsPercentage = (double) papnWorsCount / surveyList.size() * 100;

                        double averageEatOut = (double) totalEatOut / surveyList.size();
                        double averageMovies = (double) totalMovies / surveyList.size();
                        double averageTv = (double) totalTv / surveyList.size();
                        double averageRadio = (double) totalRadio / surveyList.size();

                %>

                <tr>
                    <td>Percentage of people who like Pizza:</td>
                    <td><%= decimalFormat.format(pizzaPercentage)%>%</td>
                </tr>

                <tr>
                    <td>Percentage of people who like Pasta</td>
                    <td><%= decimalFormat.format(pastaPercentage)%>%</td>
                </tr>
                <tr>
                    <td>Percentage of people who like Pap and Wors</td>
                    <td><%= decimalFormat.format(papnWorsPercentage)%>%</td>
                </tr>

                <tr>
                    <td>People who like to eat out</td>
                    <td><%= decimalFormat.format(averageEatOut)%></td>
                </tr>
                <tr>
                    <td>People who like to watch movies</td>
                    <td><%= decimalFormat.format(averageMovies)%></td>
                </tr>
                <tr>
                    <td>People who like to watch tv</td>
                    <td><%= decimalFormat.format(averageTv)%></td>
                </tr>
                <tr>
                    <td>People who like to listen to the radio</td>
                    <td><%= decimalFormat.format(averageRadio)%></td>
                </tr>

                <%                    }
                %>
        </table>

        <br>

        <center>
            <button>
                <a href="index.jsp">Home</a>
            </button>
        </center>
    </body>
</html>