const apiUrl = "http://localhost:8080/api/band/getBands";

function getBands() {

    fetch(apiUrl)
    .then(response => response.json())
    .then(data => {
        document.getElementById("main").innerHTML = data;
    });
}