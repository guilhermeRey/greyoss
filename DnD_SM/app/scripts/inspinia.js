/**
 * INSPINIA - Responsive Admin Theme
 * 2.0
 *
 * Custom scripts
 */

$(document).ready(function () {

    jQuery.event.props.push('dataTransfer');

    // Full height
    function fix_height() {
        var heightWithoutNavbar = $("body > #wrapper").height() - 61;
        $(".sidebard-panel").css("min-height", heightWithoutNavbar + "px");

        var navbarHeigh = $('nav.navbar-default').height();
        var wrapperHeigh = $('#page-wrapper').height();

        if(navbarHeigh > wrapperHeigh){
            $('#page-wrapper').css("min-height", navbarHeigh + "px");
        }

        if(navbarHeigh < wrapperHeigh){
            $('#page-wrapper').css("min-height", $(window).height()  + "px");
        }
    }

    $(window).bind("load resize scroll", function() {
        if(!$("body").hasClass('body-small')) {
            fix_height();
        }
    });

    setTimeout(function () {
      $( ".draggable" ).draggable({
        containment: 'parent'
      });
      $( "#grid-square-guide" ).draggable({
        containment: 'parent',
        drag: function( e, ui ) {
          var target = $('#' + ui.helper.data('target-grid'));
          var parentHeight = parseFloat(ui.helper.parent().height());

          var y = (ui.position.top / parentHeight) * 100;
          var x = (ui.position.left / parentHeight) * 100.0;

          y = parseFloat((y * 100.00) / 81.81);

          target.css('background-position-x', x + '%');
          target.css('background-position-y', y + '%');
        }
      });
    }, 3000);

    setTimeout(function(){
        fix_height();
    })

    setTimeout(function () {
      $('.grid').each(function () {
        var bw = 520;
        var bh = 520;
        //padding around grid
        var p = 10;
        //size of canvas
        var cw = bw + (p*2) + 1;
        var ch = bh + (p*2) + 1;

        var canvas = $('<canvas/>').attr({width: cw, height: ch}).appendTo($(this));
        var context = canvas.get(0).getContext("2d");

        function drawBoard() {
            for (var x = 0; x <= bw; x += 40) {
                context.moveTo(0.5 + x + p, p);
                context.lineTo(0.5 + x + p, bh + p);
            }
            for (var x = 0; x <= bh; x += 40) {
                context.moveTo(p, 0.5 + x + p);
                context.lineTo(bw + p, 0.5 + x + p);
            }
            context.strokeStyle = "white";
            context.stroke();
        }
        drawBoard();
      });
    }, 1200);
});

// Minimalize menu when screen is less than 768px
$(function() {
    $(window).bind("load resize", function() {
        if ($(this).width() < 769) {
            $('body').addClass('body-small')
        } else {
            $('body').removeClass('body-small')
        }
    })
});
