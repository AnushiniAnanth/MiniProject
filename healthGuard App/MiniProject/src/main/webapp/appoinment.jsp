<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appointment Form</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url("appoint.jpeg");
            background-size: cover;
            background-position: center;
        }

        .container {
            max-width: 400px;
            width: 100%;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
        }

        label {
            font-size: 14px;
            font-weight: bold;
            color: #333;
            margin-bottom: 5px;
        }

        input, select {
            width: 100%;
            padding: 12px;
            margin-top: 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        button, input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover, input[type="submit"]:hover {
            background-color: #218838;
        }

        #confirmationMessage {
            margin-top: 20px;
            font-size: 18px;
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Book An Appointment</h2>
        <form action="submit_appointment" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="doctorname">Doctor's Name:</label>
           
            
            
            <select id="doctorname" name="doctorname" required>
                <option value="Dr.Anushini ananth">Dr. Anushini ananth - Cardiologist</option>
                <option value="Dr. Narmitha ">Dr.Narmitha - Orthologist</option>
                <option value="Dr.Hari hara sudhan ">Dr. Hari hara sudhan - general Physician</option>
                <option value="Dr.harini">Dr. Harini - Dentist</option>
                <option value="Dr. John ">Dr.john - Psycologist</option>
            </select>
            
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required>
            
            <label for="time">Time:</label>
            <input type="time" id="time" name="time" required>
            
            <input type="submit" value="Submit" class="btn btn-primary" onclick="appointment_details()">
        </form>
        <div id="confirmationMessage"></div>
    </div>
</body>
<script>
function  appointment_details(){
    window.location.href = "success.jsp"; 
}
</script>
</html>
