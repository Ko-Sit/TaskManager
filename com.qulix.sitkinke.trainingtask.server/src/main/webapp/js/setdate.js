function setMin() {
    var minValue = document.getElementById('startdate').value;
    document.getElementById("enddate").min = minValue;
}

function setMax() {
    var maxValue = document.getElementById('enddate').value;
    document.getElementById("startdate").max = maxValue;
}