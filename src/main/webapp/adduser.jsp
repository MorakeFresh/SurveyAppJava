<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey Users</title>

        <script type="text/javascript">
            function validateAge() {
                var age = document.getElementById("age");
                var number = parseInt(age.value);

                if (isNaN(number) || number < 5 || number > 120) {
                    alert("Please enter a number between 5 and 120.");
                    age.value = "";
                    age.focus();
                    return false;
                }


                return true;
            }
        </script>
    </head>
    <body>       
        <div align="center">
            <h1>User Details</h1>
            <form method="POST" action="UserController" onsubmit="return validateAge()">
                <table style="width: 40%">

                    <tr>
                        <td>Surname</td>
                        <td><input type="text" name="surname" required/></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" required/></td>
                    </tr>
                    <tr>
                        <td>Contact Number</td>
                        <td><input type="text" name="contactNumber" required/></td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td><input type="text" id="age" name="age"></td>
                    </tr>

                </table>
                <br>
                <center>
                    <input type="hidden" id="act" name="act" value="adduser">
                    <input type ='submit'>          
                </center>
                <br>
                <center>
                    <button type="button" name="back" onclick="history.back()">back</button>     
                </center>
            </form>
        </div>
    </body>
</html>
