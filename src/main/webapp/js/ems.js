function checkName() {
    var obj = document.getElementById("name");
    var span = document.getElementById("nameid");
    if (obj.value == "") {
        span.innerHTML = "<font color='red'>请输入姓名<font>";
        return false;
    } else {
        span.innerText = "";
        return true;
    }

}

function checkSalary() {
    var obj = document.getElementById("salary");
    var span = document.getElementById("salaryid");
    if (isNaN(obj.value) == true || obj.value == "") {
        span.innerHTML = "<font color='red'>请输入工资<font>";
        return false;
    } else {
        span.innerText = "";
        return true;
    }
}

function checkBirthday() {
    var obj = document.getElementById("birthday");
    var span = document.getElementById("birthdayid");
    if (obj.value == "") {
        span.innerHTML = "<font color='red'>请输入出生日期<font>";
        return false;
    } else {
        span.innerText = "";
        return true;
    }
}

function checkForm() {
    if (checkName() == false | checkSalary() == false | checkBirthday() == faase) {
        return false;
    }
    return true;
}