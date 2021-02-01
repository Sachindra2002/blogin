<%-- 
    Document   : createBlog
    Created on : Nov 30, 2020, 10:27:18 AM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">


        <title>Creating new blog...</title>

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
              rel="stylesheet">


        <link href="css/createBlog.css" rel="stylesheet" media="all">
        <script src="https://cdn.tiny.cloud/1/4su3lne9yzq5p2bx4fuiya25eimkq8a1okpqzpb4ocsklxcm/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script>
            tinymce.init({
                selector: '#mytextarea',
            });
            function validateForm()
            {
                var editorContent = tinymce.get('mytextarea').getContent();
                if (editorContent == "" || editorContent == null)
                {
                    // Add error message if not already present
                    if (!$('#editor-error-message').length)
                    {
                        $('<span id="editor-error-message">Please type in the body</span>').insertAfter($(tinymce.get('mytextarea').getContainer()));


                    }
                    alert("Please enter the body!");
                    return false;
                } else
                {
                    // Remove error message
                    if ($('#editor-error-message'))
                        $('#editor-error-message').remove();

                    document.getElementById('submit').submit();
                    return true;
                }
            }
        </script>
    </head>

    <body>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title">Create new blog</h2>
                    </div>
                    <div class="card-body">
                        <form form action="BloggerController" method="POST" enctype="multipart/form-data" >
                            <input type="hidden" name="command" value="ADD" />
                            <div class="form-row">
                                <div class="name">Category</div>
                                <div class="value">
                                    <select name="Category" class="input--style-6">
                                        <option values="Travel">Travel</option>
                                        <option values="Food">Food</option>
                                        <option values="Music">Music</option>
                                        <option values="Fashion">Fashion</option>
                                        <option values="Lifestyle">Lifestyle</option>
                                        <option values="Sports">Sports</option>
                                        <option values="Fitness">Fitness</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Title</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="text" name="Title"
                                               placeholder="Type the title of your blog here" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Body</div>
                                <div class="value">
                                    <div class="input-group">
                                        <textarea id="mytextarea" class="textarea--style-6" name="Body"
                                                  placeholder="Type the body of your blog here" ></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Upload Image</div>
                                <div class="value">
                                    <div class="input-group js-input-file">
                                        <input class="input-file" type="file" name="fileToUpload" id="file" required>
                                        <label class="label--file" for="file">Choose file</label>
                                        <span class="input-file__info">No file chosen</span>
                                    </div>
                                    <div class="label--desc">Upload your blog image. Max file size 10 MB</div>
                                </div>
                                <div class="preview"> <img src="BlogImages/preview.png" id="previewPhoto" size="50"></div>
                            </div>
                            <div class="card-footer">
                                <button class="btn btn--radius-2 btn--blue-2" type="submit" id="submit" onclick="return validateForm()">Post Blog</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>


        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="app.js"></script>



        <script src="js/global.js"></script>

    </body>

</html>
