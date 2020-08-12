function readag(){
	alert("ooooooooooooooooooooooooooooo");
}
function persianToEnglish(value) {
    	var newValue="";
    	for (var i=0;i<value.length;i++)
    	{
    	var ch=value.charCodeAt(i);
    	if (ch>=1776 && ch<=1785) // For Persian digits.
    	{
    	var newChar=ch-1728;
    	newValue=newValue+String.fromCharCode(newChar);
    	}
    	else if(ch>=1632 && ch<=1641) // For Arabic & Unix digits.
    	{
    	var newChar=ch-1584;
    	newValue=newValue+String.fromCharCode(newChar);
    	}
    	else
    	newValue=newValue+String.fromCharCode(ch);
    	}
    	return newValue;
    }


document.forms["form"]["form:senfiPhone"].oninput = function() {
	document.forms["form"]["form:senfiPhone"].value=persianToEnglish(document.forms["form"]["form:senfiPhone"].value);
};

document.forms["form"]["form:motMobile"].oninput = function() {
	document.forms["form"]["form:motMobile"].value=persianToEnglish(document.forms["form"]["form:motMobile"].value);
};

document.forms["form"]["form:senfiShenase"].oninput = function() {
	document.forms["form"]["form:senfiShenase"].value=persianToEnglish(document.forms["form"]["form:senfiShenase"].value);
};

document.forms["form"]["form:postcode"].oninput = function() {
	document.forms["form"]["form:postcode"].value=persianToEnglish(document.forms["form"]["form:postcode"].value);
};

