const typSpd = 70;
    const waitTime = 500;

    const text = [
        "در این قسمت نمایشگاه های مبلمان داخلی و خارجی قرار داده می شود. جهت مشاهده ی جزئیات نمایشگاه ها روی مشاهده کلیک کنید.",
    ]

    var mi = 0;

    function writeString(e, str, i) {
        e.innerHTML = e.innerHTML + str[i];

        if (e.innerHTML.length == str.length && mi != text.length)
            setTimeout(slowlyDelete, waitTime, e);
    }

    function deleteString(e) {
        e.innerHTML = e.innerHTML.substring(0, e.innerHTML.length - 1);

        if (e.innerHTML.length == 0)
            slowlyWrite(e, text[mi++]);
    }

    function slowlyDelete(e) {
        for (var i = 0; i < e.innerHTML.length; i++) {
            setTimeout(deleteString, typSpd / 2 * i, e);
        }
    }

    function slowlyWrite(e, str) {
        for (var i = 0; i < str.length; i++) {
            setTimeout(writeString, typSpd * i, e, str, i);
        }
    }

    const msg = document.querySelector(".msg-icn");

    slowlyDelete(msg);

    $(document).ready(function() {

        $('.slick-slider').bxSlider({
            minSlides: 1,
            maxSlides: 1,
            controls: false
        });

        $( ".explore-button" ).hover(function() {
                $( this ).parent().addClass("hovered-card");
            }, function() {
                $( this ).parent().removeClass("hovered-card");
            }
        );

    });