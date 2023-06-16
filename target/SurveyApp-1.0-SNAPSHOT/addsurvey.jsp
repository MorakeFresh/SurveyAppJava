<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey Questions</title>
        <script type="text/javascript">
            function validateSurvey() {
                 alert("Survey Submitted");
            }
        </script>
    </head>
    <body>
        <div align="left">
            <h1>Survey Questions</h1>
            <form method="POST" action="SurveyController" onsubmit="return validateSurvey()">
                <br>
                <p>What is your favourite food? (You can choose more than 1 answer)</p>
                <br>

                <input type="checkbox" name="pizza" value="1"> Pizza<br>
                <input type="hidden" name="pizza" value="0"> 

                <input type="checkbox" name="pasta" value="1"> Pasta<br>
                <input type="hidden" name="pasta" value="0"> 

                <input type="checkbox" name="papnWors" value="1"> Pap & Wors<br>
                <input type="hidden" name="papnWors" value="0"> 

                <input type="checkbox" name="chicken" value="1"> Chicken<br>
                <input type="hidden" name="chicken" value="0"> 

                <input type="checkbox" name="beef" value="1"> Beef<br>
                <input type="hidden" name="beef" value="0"> 

                <input type="checkbox" name="other" value="1"> Other<br>
                <input type="hidden" name="other" value="0"> 

                <br>
                <p>On a scale of 1 to 5 indicate whether you strongly agree to strongly disagree</p>
                <br>

                <table>
                    <tr>
                        <th></th>
                        <th>Strongly Agree (1)</th>
                        <th>Agree (2)</th>
                        <th>Neutral (3)</th>
                        <th>Disagree (4)</th>
                        <th>Strongly Disagree (5)</th>
                    </tr>
                    <tr>
                        <th>I like to eat out</th>
                        <td>
                            <input type="radio" name="eatOut" value="1" checked>
                        </td>
                        <td>
                            <input type="radio" name="eatOut" value="2">
                        </td>
                        <td>
                            <input type="radio" name="eatOut" value="3">
                        </td>
                        <td>
                            <input type="radio" name="eatOut" value="4">
                        </td>
                        <td>
                            <input type="radio" name="eatOut" value="5">
                        </td>
                    </tr>
                    <tr>
                        <th>I like to watch movies</th>
                        <td>
                            <input type="radio" name="movies" value="1">
                        </td>
                        <td>
                            <input type="radio" name="movies" value="2" checked>
                        </td>
                        <td>
                            <input type="radio" name="movies" value="3">
                        </td>
                        <td>
                            <input type="radio" name="movies" value="4">
                        </td>
                        <td>
                            <input type="radio" name="movies" value="5">
                        </td>
                    </tr>
                    <tr>
                        <th>I like to watch tv</th>
                        <td>
                            <input type="radio" name="tv" value="1">
                        </td>
                        <td>
                            <input type="radio" name="tv" value="2">
                        </td>
                        <td>
                            <input type="radio" name="tv" value="3" checked>
                        </td>
                        <td>
                            <input type="radio" name="tv" value="4">
                        </td>
                        <td>
                            <input type="radio" name="tv" value="5">
                        </td>
                    </tr>
                    <tr>
                        <th>I like to listen to the radio</th>
                        <td>
                            <input type="radio" name="radio" value="1">
                        </td>
                        <td>
                            <input type="radio" name="radio" value="2">
                        </td>
                        <td>
                            <input type="radio" name="radio" value="3">
                        </td>
                        <td>
                            <input type="radio" name="radio" value="4" checked>
                        </td>
                        <td>
                            <input type="radio" name="radio" value="5">
                        </td>
                    </tr>

                </table>

               
                <br>
                <center>
                    <input type="hidden" name="act" value="addsurvey">
                    <input type ='submit'>          
                </center>

                <br>
                <center>
                    <button>
                        <a href="SurveyController?act=results">Results</a>
                    </button>
                </center>

            </form>

        </div>
    </body>
</html>
