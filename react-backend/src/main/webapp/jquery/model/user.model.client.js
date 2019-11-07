
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
    this.getUserName = getUsername;
}