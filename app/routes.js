const express = require('express')
const router = express.Router()
const axios = require('axios').default;

// Add your routes here - above the module.exports line

router.get('/', (req, res) => {
    res.render('home')
})

var jobRoles = [];
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

module.exports = router


