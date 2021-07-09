const express = require('express')
const router = express.Router()
const axios = require('axios').default;

// Add your routes here - above the module.exports line

router.get('/', (req, res) => {
    res.render('home')
})

router.get('/capabilityleaders', (req, res) => {
    var capabilityLeaders = [];

    axios({
        method: 'get',
        url: 'http://localhost:8080/api/capability/getCapabilityLeads',
        responseType: 'json'
    })
        .then(function (response) {
            capabilityLeaders = response.data;
            console.log(capabilityLeaders);
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

module.exports = router