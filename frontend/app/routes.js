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

    res.render('capabilityleaders', {capabilityLeaders: capabilityLeaders.data})
})

router.get('/jobroles', async (req, res) => {
    const jobRoles = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/role/getRoles',
        responseType: 'json'
    })

    res.render('jobroles', {jobRoles: jobRoles.data})
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

    res.render('role', {role: role.data})
})

router.get('/bands', async (req, res) => {
    const bands = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getBands',
        responseType: 'json'
    })

    res.render('bands', {bands: bands.data})
})

router.get('/training', (req, res) => {
    var bands = [
        {
            bandID: 1,
            bandName: "Apprentice"
        },
        {
            bandID: 2,
            bandName: "Trainee"
        },
        {
            bandID: 3,
            bandName: "Associate"
        },
        {
            bandID: 4,
            bandName: "Senior Associate"
        },
        {
            bandID: 5,
            bandName: "Consultant"
        },
        {
            bandID: 6,
            bandName: "Manager"
        },
        {
            bandID: 7,
            bandName: "Principal"
        }
    ]
    var trainings = [
        {
            name: "Training 1",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 1,
            highBandLevel: 2,
        },
        {
            name: "Training 2",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 1,
            highBandLevel: 1,
        },
        {
            name: "Training 3",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 4,
            highBandLevel: 5,
        },
        {
            name: "Training 4",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 1,
            highBandLevel: 7,
        },
        {
            name: "Training 5",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 5,
            highBandLevel: 7,
        },
        {
            name: "Training 6",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 3,
            highBandLevel: 7,
        },
        {
            name: "Training 7",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 2,
            highBandLevel: 5,
        },
        {
            name: "Training 8",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 1,
            highBandLevel: 1,
        },
        {
            name: "Training 9",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 4,
            highBandLevel: 4,
        },
        {
            name: "Training 10",
            description: "You do this and that",
            place: "internet",
            lowBandLevel: 5,
            highBandLevel: 5,
        }
    ]

    res.render('training', {request: req, bands: bands, trainings: trainings})
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
