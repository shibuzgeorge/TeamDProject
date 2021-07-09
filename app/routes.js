const express = require('express')
const router = express.Router()
const axios = require('axios').default;

// Add your routes here - above the module.exports line

router.get('/', (req, res) => {
    res.render('home')
})

var jobRoles = [];
var bands = [];

router.get('/jobroles', (req, res) => {

    axios({
        method: 'get',
        url: 'http://localhost:8080/api/role/getRoles',
        responseType: 'json'
    })
        .then(function (response) {
            jobRoles = response.data;
            console.log(jobRoles);
            res.render('jobroles', {jobRoles: jobRoles})
        });
})

router.get('/bands', (req, res) => {

    axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getBands',
        responseType: 'json'
    })
        .then(function (response) {
            bands = response.data;
            console.log(bands);
            res.render('bands', {bands: bands})
        });
})

router.get('/apprentice', (req, res) => {

    axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/apprentice',
        responseType: 'json'
    })
        .then(function (response) {
            apprentice = response.apprentice;
            console.log(apprentice);
            res.render('apprentice', {apprentice: apprentice})
        });
})



module.exports = router


