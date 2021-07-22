const express = require('express')
const router = express.Router()
const axios = require('axios').default
const permit = require('./middleware/authorization'); // middleware for checking if user's role is permitted to make request
const FormData = require('form-data');

if (typeof localStorage === "undefined" || localStorage === null) {
    var LocalStorage = require('node-localstorage').LocalStorage;
    localStorage = new LocalStorage('./scratch');
}

// Add your routes here - above the module.exports line

router.get('/', permit('Admin', 'Employee'), (req, res) => {
    res.render('home', {user: req.user})
})


router.get('/home', permit('Admin', 'Employee'), (req, res) => {
    res.render("home", {user: req.user})
})


router.get('/login', (req, res) => {
    if (localStorage.getItem("auth") != null) {
        return res.redirect('/home')
    }
    res.render('login')
})

router.post('/login', (req, res) => {
    const username = req.body.username;
    const password = req.body.password;
    const token = Buffer.from(`${username}:${password}`, 'utf8').toString('base64');
    axios({
        method: 'post',
        url: 'http://localhost:8080/api/login',
        headers: {
            'Authorization': `Basic ${token}`
        },
        responseType: 'json'
    }).then((response) => {
        localStorage.setItem("auth", `Basic ${token}`);
        res.redirect('home')
    }, (error) => {
        res.render('login', {error: "Invalid credentials"})
    })
})

router.post('/logout', (req, res) => {
    localStorage.removeItem("auth");
    res.header('Cache-Control', 'private, no-cache, no-store, must-revalidate');
    res.header('Expires', '-1');
    res.header('Pragma', 'no-cache');
    return res.redirect('login');
})


router.get("/addjobfamily", permit('Admin'), async (req, res) => {
    const capabilities = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/capability/getCapability',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    const jobFamily = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/jobFamily/getJobFamily',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('addjobfamily', {capabilities: capabilities.data, jobFamily: jobFamily.data, user: req.user});
});

router.get("/jobfamily", permit('Admin'), async (req, res) => {

    const jobFamily = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/jobFamily/getJobFamily',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('jobfamily', {jobFamilies: jobFamily.data, user: req.user});
});

router.get("/editjobfamily/:id", permit('Admin'), async (req, res) => {

    const capabilities = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/capability/getCapability',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    const jobFamily = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/jobFamily/getJobFamily/'+ req.params.id,
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('editjobfamily', {jobFamily: jobFamily.data, capabilities: capabilities.data, user: req.user});
});

router.post('/editjobfamily/:id', permit(`Admin`), (req, res) => {
    let capabilities = '';
    let jobFamily = '';
    axios({
        method: 'put',
        url: 'http://localhost:8080/api/editJobFamily/' + req.params.id,
        headers: {
            'Authorization': localStorage.getItem("auth"),
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        params: {
            jobFamilyName: req.body.jobFamilyName,
            capability: req.body.capability,
        },
        responseType: 'json'
    }).then(async (response) => {
        capabilities = await axios({
            method: 'get',
            url: 'http://localhost:8080/api/capability/getCapability',
            headers: {
                'Authorization': localStorage.getItem("auth")
            },
            responseType: 'json'
        })

        jobFamily = await axios({
            method: 'get',
            url: 'http://localhost:8080/api/jobFamily/getJobFamily/'+ req.params.id,
            headers: {
                'Authorization': localStorage.getItem("auth")
            },
            responseType: 'json'
        })
        if(!response.data){
            return res.render('editjobfamily', {error: "Job Family already exists within this capability please select another capability or enter a different job family name", capabilities: capabilities.data, jobFamily: jobFamily.data, user: req.user})
        }
        res.render('editjobfamily', {message: "Updated successfully", capabilities: capabilities.data, jobFamily: jobFamily.data, user: req.user})
    }, (error) => {
        return res.render('editjobfamily', {error: error.message, capabilities: capabilities.data, jobFamily: jobFamily.data, user: req.user})
    })
})

router.post('/addjobfamily', permit(`Admin`), (req, res) => {
    // const bodyFormData = new FormData();
    // bodyFormData.append('jobFamilyName', req.body.jobFamilyName);
    // bodyFormData.append('capability', req.body.capability);
    console.log(req.body.capability + req.body.jobFamilyName);
    axios({
        method: 'post',
        url: 'http://localhost:8080/api/newJobFamily',
        headers: {
            'Authorization': localStorage.getItem("auth"),
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        params: {
            jobFamilyName: req.body.jobFamilyName,
            capability: req.body.capability
        },
        //data: bodyFormData,
        responseType: 'json'
    }).then(async (response) => {
        const capabilities = await axios({
            method: 'get',
            url: 'http://localhost:8080/api/capability/getCapability',
            headers: {
                'Authorization': localStorage.getItem("auth")
            },
            responseType: 'json'
        })

        const jobFamily = await axios({
            method: 'get',
            url: 'http://localhost:8080/api/jobFamily/getJobFamily',
            headers: {
                'Authorization': localStorage.getItem("auth")
            },
            responseType: 'json'
        })
        if(!response.data){
           return res.render('addjobfamily', {error: "Job Family already exists within this capability please select another capability or enter a different job family name", capabilities: capabilities.data, jobFamily: jobFamily.data, user: req.user})
        }
        res.render('addjobfamily', {message: "Inserted successfully", capabilities: capabilities.data, jobFamily: jobFamily.data, user: req.user})
    }, (error) => {
        console.log(error.message);
    })
})

router.get('/capabilityleaders', permit('Admin', 'Employee'), async (req, res) => {

    const capabilityLeaders = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/capability/getCapabilityLeads',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('capabilityleaders', {capabilityLeaders: capabilityLeaders.data, user: req.user})
})


router.get('/jobroles', permit('Admin', 'Employee'), async (req, res) => {

    const jobRoles = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/role/getRoles',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

  const capabilities = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/capability/getCapabilityLeads',
    headers: {
      'Authorization' : localStorage.getItem("auth")
    },
    responseType: 'json'
  })

  const bands = await axios({
    method: 'get',
    url: 'http://localhost:8080/api/band/getBands',
    headers: {
      'Authorization' : localStorage.getItem("auth")
    },
    responseType: 'json'
  })

    var counter = 0
    var uniqueJobFamilies = []
    var uniqueJobFamiliesObjects = []
    var capabilitiesFromJobRoles = []
    for(var i = 0; i < jobRoles.data.length; i++) {
        if(capabilitiesFromJobRoles.indexOf(jobRoles.data[i].capability) == -1){
            capabilitiesFromJobRoles.push(jobRoles.data[i].capability)
        }
    }

    for(var x = 0; x < jobRoles.data.length; x++) {
        if(uniqueJobFamilies.indexOf(jobRoles.data[x].jobFamily) == -1){
            uniqueJobFamilies.push(jobRoles.data[x].jobFamily)
            uniqueJobFamiliesObjects[counter] = {
                name: jobRoles.data[x].jobFamily,
                id: counter
            }
            counter++
        }
    }

    res.render('jobroles', {
        jobRoles: jobRoles.data,
        capabilities: capabilities.data,
        bands: bands.data,
        user: req.user,
        capabilitiesFromJobRoles: capabilitiesFromJobRoles,
        uniqueJobFamiliesObjects: uniqueJobFamiliesObjects
    })
})

router.get('/jobroles/:roleID', permit('Admin', 'Employee'), async (req, res) => {

})

router.get('/role/:roleID', permit('Admin', 'Employee'), async (req, res) => {
    let role = ''
    try {
        role = await axios({
            method: 'get',
            url: 'http://localhost:8080/api/role/' + req.params.roleID,
            headers: {
                'Authorization': localStorage.getItem("auth")
            },
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
            headers: {
                'Authorization': localStorage.getItem("auth")
            },
            responseType: 'json'
        })
    } catch (err) {
        console.log(err.message)
    }

    res.render('role', {role: role.data, responsibility: responsibility.data, user: req.user})

})


router.get('/bands', permit('Admin', 'Employee'), async (req, res) => {
    const bands = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getBands',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('bands', {bands: bands.data, user: req.user})
})

router.get('/bands/:bandID', permit('Admin', 'Employee'), async (req, res) => {
    if (localStorage.getItem("auth") === null) {
        return res.render("login")
    }
    let competencies = '';
    try {
        competencies = await axios({
            method: 'get',
            url: 'http://localhost:8080/api/competency/getCompetencyByBand/' + req.params.bandID,
            headers: {
                'Authorization': localStorage.getItem("auth")
            },
            responseType: 'json'
        })
    } catch (err) {
        console.log('***ERROR: ', err.message)
    }

    const bands = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getBands',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('bands', {request: req, bands: bands.data, competencies: competencies.data, user: req.user})
})


router.get('/training', permit('Admin', 'Employee'), async (req, res) => {
    const bands = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getBands',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('training', {request: req, bands: bands.data, user: req.user})
})

router.get('/training/:bandID', permit('Admin', 'Employee'), async (req, res) => {
    let trainings = '';
    try {
        trainings = await axios({
            method: 'get',
            url: 'http://localhost:8080/api/training/getTrainingByBand/' + req.params.bandID,
            headers: {
                'Authorization': localStorage.getItem("auth")
            },
            responseType: 'json'
        })
    } catch (err) {
        console.log('***ERROR: ', err.message)
    }

    const bands = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getBands',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('training', {bands: bands.data, trainings: trainings.data, request: req, user: req.user})
})


router.get('/jobroles/capability/:capabilityID', permit('Admin', 'Employee'), async (req, res) => {
    const capability = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/capability/getCapability',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    const data = [{capability: capability.data}];
    res.render('capability', {data: data})
})

router.get('/capability/:capabilityName', permit('Admin', 'Employee'), async (req, res) => {
    const capability = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/capability/' + req.params.capabilityName,
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    const jobFamily = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/jobFamilyFromCapability/' + req.params.capabilityName,
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    const jobRoles = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/roleFromCapability/' + req.params.capabilityName,
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    const bands = await axios({
        method: 'get',
        url: 'http://localhost:8080/api/band/getBands',
        headers: {
            'Authorization': localStorage.getItem("auth")
        },
        responseType: 'json'
    })

    res.render('capability', {
        capabilityData: capability.data,
        jobFamilyData: jobFamily.data,
        jobRoleData: jobRoles.data,
        bandData: bands.data,
        user: req.user
    })
})

module.exports = router