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
  let role = ''
  try {
    role = await axios({
      method: 'get',
      url: 'http://localhost:8080/api/role/' + req.params.roleID,
      responseType: 'json'
    })
  } catch (err) {
    console.log(err.message)
  }

  let responsibility = ''
  try {
    responsibility = await axios({
      method: 'get',
      url: 'http://localhost:8080/api/responsibility/getResponsibilityByID/' + req.params.roleID,
      responseType: 'json'
    })
  } catch (err) {
    console.log(err.message)
  }

  res.render('role', { role: role.data, responsibility: responsibility.data })

})

router.get('/bands', async (req, res) => {
  const bands = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/band/getBands',
    responseType: 'json'
  })

    let data = [ {bands: bands.data} ];

  res.render('bands', { data: data })
})

router.get('/bands/:bandID', async (req, res) => {
let competencies = '';
      try {
      competencies = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/competency/getCompetencyByBand/' + req.params.bandID,
        responseType: 'json'
      })
      } catch (err) {
      console.log('***ERROR: ', err.message)}

      const bands = await axios({
          method: 'get',
          url: 'http://localhost:8080/api/band/getBands',
          responseType: 'json'
        })

        let data = [
        {bands: bands.data,
        competencies: competencies.data}
        ];

  res.render('bands', {data: data, request: req})

})

router.get('/jobroles/capability/:capabilityID', async (req, res) => {
  const capability = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/capability/getCapability',
    responseType: 'json'
  })

  const data = [{capability: capability.data}];
  res.render('capability', { data: data })
})

router.get('/capability/:capabilityName', async (req,res) =>{
  const capability = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/capability/getCapability',
    responseType: 'json'
  })

  const jobFamily = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/jobFamilyFromCapability/' +req.params.capabilityName,
    responseType: 'json'
  })

  const jobRoles = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/roleFromCapability/' +req.params.capabilityName,
    responseType: 'json'
  })

  const jobRolesData = [{jobRoles: jobRoles.data}]
  const jobFamilyData = [{jobFamily: jobFamily.data}]
  const capabilityData = [{capability: capability.data}]
  res.render('capability', {capabilityData: capabilityData, jobFamilyData: jobFamilyData, jobRolesData: jobRolesData})
})

module.exports = router
