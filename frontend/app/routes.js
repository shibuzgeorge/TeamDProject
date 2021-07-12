const express = require('express')
const router = express.Router()
const axios = require('axios').default;

// Add your routes here - above the module.exports line

router.get('/', (req, res) => {
    res.render('home')
})

var jobRoles = [];
var bands = [];

router.get('/capabilityleaders', (req, res) => {
    var capabilityLeaders = [];

    axios({
        method: 'get',
        url: 'http://localhost:8080/api/capability/getCapabilityLeads',
        responseType: 'json'
    })
        .then(function (response) {
            capabilityLeaders = response.data;
            res.render('capabilityleaders', {capabilityLeaders: capabilityLeaders})
        });
})

router.get('/jobroles', (req, res) => {
    var jobRoles = [];
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

router.get('/competencies', (req, res) => {
var competencies = [];
//TODO: Pass CompetencyID to axios request
    axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getCompetencies',
        responseType: 'json',
        data: {
            competencyID: '',
            competencyName: ''
            }
    })
        .then(function (response) {
            competencies = response.data;
            console.log(competencies);
            res.render('competencies', {competencies: competencies})
        });
})





module.exports = router
