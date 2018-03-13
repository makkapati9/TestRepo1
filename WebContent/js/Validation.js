function CheckDate(ctl) {
    var str = trim(ctl.value);
    var chk1 = "0123456789/";

    for (var i = 0; i < str.length; i++) {
        var ch = str.charAt(i);
        var rtn1 = chk1.indexOf(ch);

        if (rtn1 == -1) {
            ctl.value = '';
            ctl.focus();
            alert('Enter date in format dd/MM/yyyy');
            return false;
        }
    }
    return true;
}

function isAlphaNumeric(evt) {

    var charCode = (evt.which) ? evt.which : event.keyCode;

    if ((charCode >= 65 && charCode <= 90)  || (charCode == 32) || (charCode >= 97 && charCode <= 122) || (charCode >= 48 && charCode <= 57) || (charCode == 8) || (charCode == 32) || (charCode == 45)) {

        return true;

    }

    else {

        alert('कृपया अंको और शब्दों  में भरें');

        return false;

    }
}
function isAlphaNumericKey(evt) {

    var charCode = (evt.which) ? evt.which : event.keyCode;

    if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122) || (charCode >= 48 && charCode <= 57) || (charCode == 8) || (charCode == 32) || (charCode == 45)) {

        return true;

    }

    else {

        alert('कृपया अंको और शब्दों में भरें');

        return false;

    }
}

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode != 46 && charCode > 31
            && (charCode < 48 || charCode > 57)) {
    	evt.preventDefault();
        alert('कृपया अंको में भरें|');
        /*return false;*/
    }
    else {

        return true;
    }
}

function isCharacterName(evt) {
	

    var charCode = (evt.which) ? evt.which : event.keyCode;

    if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122)  || (charCode == 32)||(charCode == 8) || (charCode == 45)) {

        return true;

    }

    else {
    	evt.preventDefault();
        alert('कृपया शब्दों में भरें|');
        return false;

    }
}
function isCharacter(evt) {
	
	
    var charCode = (evt.which) ? evt.which : event.keyCode;

    if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122)  || (charCode == 8) || (charCode == 45)) {

        return true;

    }

    else {

    	evt.preventDefault();
        alert('कृपया शब्दों में भरें|');
        return false;

    }
}

function DisableCopyPaste (e)
{
// Message to display
var message = "Copy /Paste is not allowed.";
// check mouse right click or Ctrl key press
var kCode = event.keyCode || e.charCode;
//FF and Safari use e.charCode, while IE use e.keyCode
if (kCode == 17 || kCode == 2)
{
alert(message);
return false;
}
}


 status="Right Click is not allowed.";
    function disableclick(event)
    {
      if(event.button==2)
       {
         alert(status);
         return false;    
       }
    }


    function isCalenderKey(evt) {

        var charCode = (evt.which) ? evt.which : event.keyCode;

        if ((charCode == 8) || (charCode == 32)) {

            return true;

        }

        else {

            alert('Please select from the calender provided.');

            return false;

        }
    }

    function isEmailKey(evt) {

        var charCode = (evt.which) ? evt.which : event.keyCode;

        if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122) || (charCode >= 48 && charCode <= 57) || (charCode == 46) || (charCode == 8) || (charCode == 64) || (charCode == 45)) {

            return true;

        }

        else {

            alert('Kindly enter email address only.');

            return false;

        }
    }
    function alpha(e) {
    	

   	 var k;
   	    document.all ? k = e.keyCode : k = e.which;
   	 
      return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57 || k == 47) || (k > 2323 && k < 2360));
   }


   function nameValid(e) {
   	
   	
       var k;
       document.all ? k = e.keyCode : k = e.which;
       return ((k > 64 && k < 91) || (k > 96 && k < 123) ||  k == 32 || k == 8 );
   }
   function nameHindiValid(e) {
   	
   	
       var k;
       document.all ? k = e.keyCode : k = e.which;
       return ((k > 2323 && k < 2360) ||  k == 32 || k == 8 );
   }