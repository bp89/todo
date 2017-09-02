<script src="webjars/jquery/3.2.1/jquery.min.js"/>
<script src="js/popper.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"/>
<!-- Plugin JavaScript -->
<script src="js/jquery.easing.min.js"></script>
<script src="js/scrollreveal.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<!-- Custom scripts for this template -->
<script src="js/creative.min.js"></script>
<script>

    var urlArray = $(location).attr('href').split("/")
    var relativeURL = urlArray[urlArray.length - 2]
    if (relativeURL === "") {
        relativeURL = "home"
    }
    $(".nav li").removeClass("active");
    $("#" + relativeURL).addClass("active");
    if ($(".nav .active").length === 0) {
        $("#home").addClass("active");
    }
    $('.scroll-top').click(function () {
        $('body,html').animate({scrollTop: 0}, 1000);
    })
</script>