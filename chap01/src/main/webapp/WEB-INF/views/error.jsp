<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 50px;
        }
        #errorContainer {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        p {
            color: #555;
        }
        button {
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div id="errorContainer">
        <h1>Error Page</h1>
        <p>${error}</p>
        <p>${e.message}</p>
        <p>${e.stackTrace}</p>
        <button onclick="simulate500Error()">Simulate 500 Error</button>
    </div>

    <script>
        function simulate500Error() {
            // Ajax 요청을 통해 500번대의 에러를 발생시킴
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/simulate-500-error', true);
            xhr.send();
        }
    </script>
</body>
</html>

