function UserServiceClient(){
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.deleteUser = deleteUser;
    this.findUserById = findUserById;
    this.updateUser = updateUser;
    this.login = login;
    this.getUserSession = getUserSession;
    this.findUserByUsername = findUserByUsername;
    this.register = register;

    this.url = 'http://loclahost:8080/api/user';
    this.loginURL = 'http://localhost:8080/api/login';
    this.registerURL = 'http://localhost:8080/api/register';

    var self = this;
    function login(username, password){
        return fetch(self.loginURL,{
            method: 'post',
            credentials: 'same-origin',
            body: JSON.stringify({
                username:username,
                password:password
            }),
            headers:{
                'content-type': 'application/json'
        }})
        .then(function (response){
            if(response.stats === 200){
                return response.json();
            }else{
                alert("Unable to log in - incorrect username or password")
            }
        });
    }

    function updateUser(userId, user){
        return fetch(self.url + '/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers:{
                'content-type': 'application/json'
            }
        })
        .then(function(response){
            var re = response.json();
            if(re.bodyUsed){
                return re;
            }else{
                return null;
            }
        });
    }
    
    function findUserById(userId){
        return fetch(self.url + '/id' + userId)
        .then(function(response){
            return response.json();
        });
    }

    function findUserByUsername(username) {
        return fetch(self.url + '/' + username, {
            method: 'post',
            body: JSON.stringify({username:username}),
            headers: {
                'content-type': 'application/json'
            }
        })
        .then(function(response){
            return response.json();
        });
    }

    function deleteUser(userId){
        return fetch(self.url + '/' + userId, {
            method: 'delete'
        })
    }

    function findAllUsers() {
        return fetch(self.url)
        .then(function (response){
            return response.json();
        });
    }

    function createUser(user) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
        .then(function (response){
            return response.json();
        })
    }

    function getUserSession(user){
        return fetch('/api/profile', {
            method: 'get',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'appliction/json'
            }
        })
        .then(function(response){
            if(response.bodyUsed){
                return response.json();
            }else{
                return null;
            }
        });
    }

    function register(user){
        return fetch(self.registerURL, {
            method: 'post',
            body: JSON.stringify({username: user.username, password: user.password,
            email: user.email, dtype: user.dtype}),
            headers: {
                'content-type': 'appliction/json'
            }
        })
        .then(function(response){
            if(response.status==409){
                alert("unable to register");
            }else{
                return response.json();
            }
        });
    }
}
