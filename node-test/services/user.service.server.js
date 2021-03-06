module.exports = function(app){
    app.get('/api/user', findAllUsers);
    app.get('/api/user/:userId', findUserById);
    app.post('/api/user', createUser);
    app.post('/api/login', login);
    app.get('/api/profile', profile);
    app.post('/api/logout', logout);
    app.put('/api/profile', updateProfile);
    app.get('/api/session/get/user', checkUserStatus);

    var userModel = require('../models/user/user.model.server');

    function  findUserById(req, res){
        var id = req.params['userId'];
        userModel.findUserById(id)
        .then(function(user){
            res.json(user);
        })
    }

    function logout(req, res){
        req.session.destroy();
        res.sendStatus(200);
    }

    function updateProfile(req, res){
        var user = req.body;

        userModel.updateUser(user._id, user)
        .then(function (user){
            req.session['currentUser'] = user;
            res.send(user);
        })
    }

    function profile(req, res){
        res.send(req.session['currentUser']);
    }

    function createUser(req, res){
        var user = req.body;
        userModel.createUser(user)
        .then(function (user){
            req.session['currentUser'] = user;
            res.send(user);
        })
    }

    function findAllUsers(req, res){
        userModel.findAllUsers()
        .then(function (users){
            res.send(users);
        })
    }

    function login(req, res){
        var user = req.body;
        userModel.findUserByCredentials(user.username, user.password)
        .then(function (user){
            req.session['currentUser'] = user;
            console.log(req.session);
            res.send(user);
        })
    }

    function checkUserStatus(req, res){
        console.log(JSON.stringify(req.session) + " TEST " + JSON.stringify(req.session['currentUser']));
        if(req.session && req.session['currentUser']){
            res.sendStatus(200);
        }
        else{
            res.sendStatus(400);
        }
    }
}