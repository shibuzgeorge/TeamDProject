window.onload = function(){
    const btn = document.querySelector("#band")
    const form = document.querySelector("#bandChoice")

    btn.onchange = function(){
        form.submit()
    }
}