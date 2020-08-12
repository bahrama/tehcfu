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



document.forms["login"]["login:authCode"].oninput = function() {
	document.forms["login"]["login:authCode"].value=persianToEnglish(document.forms["login"]["login:authCode"].value);
};