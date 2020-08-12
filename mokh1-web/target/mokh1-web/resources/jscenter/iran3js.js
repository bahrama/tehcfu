 // slideShow
        var myIndex = 0;
        carousel();

        function carousel() {
            var i;
            var x = document.getElementsByClassName("mySlides");
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            myIndex++;
            if (myIndex > x.length) {myIndex = 1}
            x[myIndex-1].style.display = "block";
            setTimeout(carousel, 4000); // Change image every 4 seconds
        }

        // map
        var map = L.map('map2').setView([ 35.663211, 51.345170 ], 14);

        L.tileLayer('https://{s}.tile.openstreetmap.se/hydda/full/{z}/{x}/{y}.png', {
            attribution : 'Tiles courtesy of <a href="http://openstreetmap.se/" target="_blank">OpenStreetMap Sweden</a> &mdash; Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
            maxZoom : 18
        }).addTo(map);

        var popup = L.popup({
            minWidth : 250
        }).setContent('<p>بازار مبل ایران شماره ۳ </p>');

        var faxIcon = L.icon({
            iconUrl : 'resources/leaflet/images/marker-icon.png'
        });

        var
            marker=L.marker([35.663211, 51.345170]).addTo(map).bindPopup('<p>بازار مبل ایران شماره ۳</p>');
