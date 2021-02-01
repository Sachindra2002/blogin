<%-- 
    Document   : updateBlogPage
    Created on : Nov 16, 2020, 5:56:57 PM
    Author     : Raaid
--%>

<!DOCTYPE html>
<html lang="en">

    <head>
      
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">


        <title>Editing blog...</title>

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">


        <link href="css/main.css" rel="stylesheet" media="all">
    </head>

    <body>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title">Update Blog</h2>
                    </div>
                    <div class="card-body">
                        <form form action="BloggerController" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="command" value="UPDATE"/>
                             <div class="form-row">
                                <div class="name">Blog ID</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="text" value="<%=request.getParameter("blogId")%>" name="blogId"  readonly="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Category</div>
                                <div class="value" > 
                                    <select name="Category" class="input--style-6" >
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
                                        <input class="input--style-6" type="text" value="<%=request.getParameter("title")%>" name="Title"  required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Body</div>
                                <div class="value">
                                    <div class="input-group">
                                        <textarea class="textarea--style-6" type="text"  name="Body" required rows="10"><%=request.getParameter("body")%></textarea>
                                    </div>
                                </div>
                            </div>
                           
                             <div class="card-footer">
                        <button class="btn btn--radius-2 btn--blue-2" type="submit">Update Blog</button>
                    </div>
                        </form>
                    </div>
                   
                </div>
            </div>
        </div>


        <script src="vendor/jquery/jquery.min.js"></script>



        <script src="js/global.js"></script>

    </body>

</html>
