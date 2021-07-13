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

router.get('/apprentice', (req, res) => {
//    axios({
  //        method: 'get',
  //        url: 'http://localhost:8080/api/band/apprentice',
  //        responseType: 'json'
  //    })
  //        .then(function (response) {
  //            apprentice = response.apprentice;
  //            console.log(apprentice);
  //            res.render('apprentice', {apprentice: apprentice})
  //        });
})

module.exports = router
