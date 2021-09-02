var numberColor = document.getElementsByTagName("li");
function init() {
    setInterval("changeImg()", 1000);
}
var i = 0;
numberColor[0].style.cssText = "background:#ff6700;color:#fff;";
function changeImg() {
    i++;
    if (i < 3) {
        document.getElementById("pRotation").src = "image/house" + i + ".jpeg"
        numberColor[i].style.cssText = "background:#ff6700;color:#fff;";
        numberColor[i - 1].style.cssText = "background:none;color:#000;";
    }
    else {
        numberColor[3].style.cssText = "background:#ff6700;color:#fff;";
        numberColor[0].style.cssText = "background:none;color:#000;";
        i = 0;
    }
}