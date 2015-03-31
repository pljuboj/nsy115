function getText(objStr) {
	var obj=getObject(objStr);
	return obj.value;
}	

function getObject(objStr) {
	var obj = null;
	try {
		obj = eval('document.forms[0].'+objStr);
	} catch(e) {}
	if (obj==null && objStr.indexOf('forms[')>=0) return eval(objStr);

	if (obj==null) obj = document.getElementById(objStr);

	return obj;
}