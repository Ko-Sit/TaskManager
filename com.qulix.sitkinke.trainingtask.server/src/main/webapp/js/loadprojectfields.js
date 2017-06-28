/**
 * Created by upsit on 22.06.2017.
 */
function load(linkID) {
    var name = document.getElementById('name').value;
    var abbr = document.getElementById('abbr').value;
    var descr = document.getElementById('descr').value;
    var parameters = '&name=' + name + '&abbr=' + abbr + '&descr=' + descr;
    document.getElementById(linkID).href += parameters;
}