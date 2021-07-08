const express = require('express')
const router = express.Router()

// Add your routes here - above the module.exports line

router.get('/', (req, res) => {
    res.render('home')
})

router.get('/jobroles', (req, res) => {
    jobRoles = [
        {roleID: 2, roleName: "Software Engineer", capabilityID: 3},
        {roleID: 3, roleName: "Senior Software Engineer", capabilityID: 3},
        {roleID: 4, roleName: "Tech Lead", capabilityID: 3},
        {roleID: 7, roleName: "Test Engineer", capabilityID: 3}
    ]

    res.render('jobroles', {jobRoles: jobRoles})
})

module.exports = router
