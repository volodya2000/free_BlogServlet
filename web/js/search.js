$(document).ready(function () {
    $("#searchPost").keyup(function () {
        $("#result").html('');
        var post = document.getElementById("searchPost").value;
        if(post.length>=1)
            $.ajax({
            url : '/find',
            method : 'POST',
            data : {post : post},
            success : function(resultText){
                $('#result').html(resultText);
            },
            error : function(jqXHR, exception){
                console.log('Error occured!!');
            }
        });

        // if(post.length>=1)
        //     $.ajax({
        //         contentType:"application/json;charset=UTF-8",
        //         url : '/find',
        //         method : 'POST',
        //         data : JSON.stringify(post),
        //         dataType:"json",
        //         success : function(resultText){
        //             $('#result').html(resultText);
        //         },
        //         error : function(jqXHR, exception){
        //             console.log('Error occured!!');
        //         }
        //     });
    });

});