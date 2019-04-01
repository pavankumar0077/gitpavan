function validation(frm)
{  //set vflag to "yes" indicating client side form validation are done
	frm.vflag.value="yes";
	//set styles to error messages
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("nameErr").style="color:'red'";
	documnet.getElementById("ageErr").style="color:'red'";
	
	//read from data
	var name = frm.pname.value;
	var age = frm.page.value;
	//perform client side form validation
	if(name=="")//required rule
		{
		document.getElementById("nameErr").innerHTML="person name is mandatory";
		frm.pname.focus();
		return false;
		}//if
		if(age=="")//required rule
			{
			document.getElementById("nameErr").innerHTML="person age is mandatory";
			frm.page.focus();
			return false;
			}//if
		else{
			if(isNaN(age))//check weather age is numberic value or not
			{
			documnet.getElementById("nameErr").innerHTML="person age must be numeric value";
			frm.page.focus();
			frm.page.value="";
			return false;
			}
		}
	return true;
}//function