/*function go(){
	$("#id").text("1314").css("color","red");
	
}*/
function checkDeletePort() {
    var checkboxArr = document.getElementsByName("ids");
    var span = document.getElementById("deleteid");
    for (var i = 0; i < checkboxArr.length; i++) {

        if (checkboxArr[i].checked) {
            span.innerText = "";
            return true;
        }
    }
    span.innerHTML = "<font color='red'>至少选一个<font>";
    return false;
}