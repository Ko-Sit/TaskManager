function setMin() {
    var minValue = document.getElementById('startdate').value;
    document.getElementById("enddate").min = minValue;
}

function setMax() {
    var maxValue = document.getElementById('enddate').value;
    document.getElementById("startdate").max = maxValue;
}
/*
* NOTSTARTED - 0
* INPROGRESS - 1
* COMPLETED - 2
* POSTPONED - 3
*/
function validateState() {
    var startDate = new Date(document.getElementById('startdate').value);
    var endDate = new Date(document.getElementById('enddate').value);
    var currentDate = new Date();
    if (currentDate < startDate) {
        document.getElementById("state").options[1].disabled = "disabled";
        document.getElementById("state").options[2].disabled = "disabled";
        document.getElementById("state").options[3].disabled = "disabled";
    }
    if (currentDate > endDate) {
        document.getElementById("state").options[0].disabled = "disabled";
        document.getElementById("state").options[1].disabled = "disabled";
        document.getElementById("state").options[3].disabled = "disabled";
    }
}

function validateDuration() {
    var startDate = new Date(document.getElementById('startdate').value);
    var endDate = new Date(document.getElementById('enddate').value);
    var maxDurationInMilliSeconds = endDate - startDate;
    var maxDurationInHours = maxDurationInMilliSeconds / (1000 * 3600);
    console.log(maxDurationInHours);
    document.getElementById("duration").max = maxDurationInHours;
}