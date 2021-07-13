const express = require('express')
const router = express.Router()
const axios = require('axios').default

// Add your routes here - above the module.exports line

router.get('/', (req, res) => {
  res.render('home')
})

router.get('/capabilityleaders', async (req, res) => {
  const capabilityLeaders = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/capability/getCapabilityLeads',
    responseType: 'json'
  })

  res.render('capabilityleaders', { capabilityLeaders: capabilityLeaders.data })
})

router.get('/jobroles', async (req, res) => {
  const jobRoles = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/role/getRoles',
    responseType: 'json'
  })

  res.render('jobroles', { jobRoles: jobRoles.data })
})

router.get('/role/:roleID', async (req, res) => {
  const role = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/role/' + req.params.roleID,
    responseType: 'json'
  })

  res.render('role', { role: role.data })
})

router.get('/bands', async (req, res) => {
  const bands = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/band/getBands',
    responseType: 'json'
  })

  res.render('bands', { bands: bands.data })
})

router.get('/competencies', (req, res) => {
var competencies = [];
var compName = document.getElementById("mySelect").value;
console.log('compName: ', compName)
//TODO: Pass CompetencyID to axios request
    axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getCompetencies',
        responseType: 'json',
        data: {
            competencyName: compName
            }
    })
        .then(function (response) {
            competencies = response.data;
            console.log(competencies);
            res.render('competencies', {competencies: competencies})
        });
})


module.exports = router
