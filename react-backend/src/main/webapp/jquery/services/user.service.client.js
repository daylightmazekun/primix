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
    fuction login(username, password){
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
            if(response.stats == 200){
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
            header:{
                'content-type': 'application/json'
            }
        }
    }
}