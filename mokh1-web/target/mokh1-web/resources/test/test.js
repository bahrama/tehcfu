function myFunction() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("example-input1-group2");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function myFunction2() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("example-input1-group2");
    filter = input.value.toUpperCase();
   // alert(filter);
    //ul = document.getElementById("myUL");
   // alert(ul.tagName);
    liX = document.getElementsByClassName("chat-data");
    li = document.getElementsByClassName("user-data");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("span")[0];
        txtValue = a.textContent || a.innerText;
       // alert(a.innerHTML);
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            liX[i].style.display = "";
        } else {
            liX[i].style.display = "none";
        }
    }
}