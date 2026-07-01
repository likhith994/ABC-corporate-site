window.addEventListener("scroll", () => {

    const header = document.querySelector("header");

    if(window.scrollY > 50){

        header.style.background="#08111f";

    }
    else{

        header.style.background="#0f172a";

    }

});