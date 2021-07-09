const express = require('express')
const router = express.Router()
const axios = require('axios').default;

// Add your routes here - above the module.exports line

router.get('/', (req, res) => {
    res.render('home')
})

router.get('/capabilityleaders', (req, res) => {
    var techLeads = [
        {
            image: "https://static.boredpanda.com/blog/wp-content/uploads/2017/12/funny-weird-wtf-stock-photos-19-5a3926af95d9d__700.jpg",
            capability: "Engineering",
            name: "Will Hamill",
            info: "Hi there!"
        },
        {
            image: "https://cdn.theatlantic.com/media/mt/science/cat_caviar.jpg",
            capability: "Product",
            name: "Charlene McDonald",
            info: "Salut!"
        },
        {
            image: "https://www.apimages.com/Images/Ap_Creative_Stock_Header.jpg",
            capability: "Cyber Security",
            name: "Peter Gallagher",
            info: "Dzien Dobry!"
        }
    ]


    res.render('capabilityleaders', {techLeads: techLeads})
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