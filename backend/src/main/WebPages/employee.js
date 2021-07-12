const apiUrl = "http://localhost:8080/api/role/getRoles";

function getRoles() {

    fetch(apiUrl)
    .then(response => response.json())
    .then(data => {
        document.getElementById("main").innerHTML = data;
    });
//    document.getElementById("main").innerHTML = data;
}