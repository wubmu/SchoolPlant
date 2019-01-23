function changeVerifyCode(img) {
    img.src="/getCode?"+Math.floor(Math.random()*100);
}