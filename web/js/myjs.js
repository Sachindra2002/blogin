function doLike(blogId, userId)
{
    console.log(blogId + "," + userId);
    const d = {
        userId: userId,
        blogId: blogId,
        operation: 'like'
    };
    $.ajax({
        url: "LikeServlet",
        data: d,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if (data.trim() === 'true')
            {
           
                let c = $(".like-counter").html();
                c++; 
                $('.like-counter').html(c);
               
              
             
            } else {
                let c = $(".like-counter").html();
                c--;
                $('.like-counter').html(c);
          
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(data);
        }

    });
}
