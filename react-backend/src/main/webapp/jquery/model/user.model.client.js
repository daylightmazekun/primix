
function User(username, password, email, firstName, lastName, phone,role, dataOfBirth){
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.dtype = role;
    this.dateOfBirth = dateOfBirth;

    this.setUserName = setUsername;
    this.getUserName = getUserName;
    this.setPassword = setPassword;
    this.getPassword = getPassword;
    this.setEmail = setEmail;
    this.getEmail = getEmail;
    this.setFirstName = setFirstName;
    this.getFirstName = getFirstName;
    this.setLastName = setLastName;
    this.getLastName = getLastName;
    this.getPhone = getPhone;
    this.setPhone = setPhone;
    this.getRole = getRole;
    this.setRole = setRole;
    this.getDateOfBirth = getDateOfBirth;
    this.setDateOfBirth = setDateOfBirth;
    
    function setUserName(username){
        this.username = username;
    }

    function getUsername(){
        return this.username;
    }
    function setPassword(password){
        this.password = password;
    }
}