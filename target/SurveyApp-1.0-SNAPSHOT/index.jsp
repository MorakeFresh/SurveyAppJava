<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .button-container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 20vh;
            }

            .button {
                padding: 20px 40px;
                font-size: 18px;
            }
        </style>
    </head>
    <body>
        <div class="button-container">
            <button class="button">
                <a href="adduser.jsp">Fill out survey</a>
            </button>
        </div>

        <br>
        <br>

        <div class="button-container">
            <button class="button">
                <a href="SurveyController?act=results">View survey results</a>
            </button>
        </div>
    </body>
</html>
