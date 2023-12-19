<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Stylish File Upload Form with Drag and Drop</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 50px;
        }
        #uploadContainer {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        #dropArea {
            border: 2px dashed #ccc;
            padding: 20px;
            margin: 20px auto;
            border-radius: 10px;
            width: 300px;
            cursor: pointer;
        }
        #fileList {
            text-align: left;
            margin-top: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        #fileList li {
            margin-bottom: 5px;
            list-style-type: none;
        }
        .fileItem {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .fileItem span {
            margin-right: 10px;
        }
        .cancelButton {
            background-color: #ff5f5f;
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
        }
        button {
            margin-top: 10px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="file"] {
            display: none;
        }
    </style>
</head>
<body>
    <div id="uploadContainer">
        <h1>Stylish File Upload Form with Drag and Drop</h1>
        
        <form action="/sample/uploadFiles" method="post" enctype="multipart/form-data" id="uploadForm">
            <label for="files">Choose files:</label>
            <input type="file" name="files" id="files" multiple required>
            <br>
            <div id="dropArea" ondrop="dropHandler(event);" ondragover="dragOverHandler(event);">
                <p>Drag & drop files here</p>
            </div>

            <div id="fileList"></div>

            <button type="button" onclick="upload()">Upload</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        function dropHandler(event) {
            event.preventDefault();

            var files = event.dataTransfer.files;
            showFiles(files);
        }

        function dragOverHandler(event) {
            event.preventDefault();
        }

        function showFiles(files) {
            var fileList = $('#fileList');

            for (var i = 0; i < files.length; i++) {
                var fileId = 'file_' + Date.now() + '_' + i;
                var listItem = $('<div class="fileItem" id="' + fileId + '"></div>');
                listItem.html('<span>' + files[i].name + '</span><button class="cancelButton" onclick="cancelUpload(\'' + fileId + '\')">Cancel</button>');
                fileList.append(listItem);
            }
        }

        function upload() {
            var files = $('#files')[0].files;

            // AJAX를 사용하여 파일 업로드
            var formData = new FormData();
            for (var i = 0; i < files.length; i++) {
                formData.append('files', files[i]);
            }

            $.ajax({
                url: '/sample/uploadFiles',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function(response) {
                    console.log(response);
                    alert('Files uploaded successfully!');
                    $('#fileList').empty();
                },
                error: function(error) {
                    console.error(error);
                    alert('Error uploading files.');
                }
            });
        }

        function cancelUpload(fileId) {
            $('#' + fileId).remove();
        }
    </script>
</body>
</html>
