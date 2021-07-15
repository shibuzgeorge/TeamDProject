window.onload = function(){
    const pTypeSwitch = document.querySelector("#pTypeSwitch")
    const tTypeSwitch = document.querySelector("#tTypeSwitch")
    const dTypeSwitch = document.querySelector("#dTypeSwitch")

    const pTypeTrainings = document.querySelectorAll(".pType")
    const tTypeTrainings = document.querySelectorAll(".tType")
    const dTypeTrainings = document.querySelectorAll(".dType")

    function changeHiddenState(element, index, array){
        element.hidden = element.hidden == false ? true : false
    }

    pTypeSwitch.onchange = function(){
        pTypeTrainings.forEach(changeHiddenState)
    }

    tTypeSwitch.onchange = function(){
        tTypeTrainings.forEach(changeHiddenState)
    }

    dTypeSwitch.onchange = function() {
        dTypeTrainings.forEach(changeHiddenState)
    }
}

