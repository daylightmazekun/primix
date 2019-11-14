(function () {
    var $emailFld, $usernameFld, $passwordFld, $verifyPasswordFld;
    var $userType;
    var $registerBtn;
    var userService = new UserServiceClient();

    $(main);

    function main() {
        $emailFld = $('#email');
        $usernameFld = $('#userid');
        $passwordFld = $('#password');
        $verifyPasswordFld = $('#reenterpassword');


        $('#password, #reenterpassword').on('keyup', function () {
            if ($('#password').val() == $('#reenterpassword').val()) {
                $('#message').html('Matching').css('color', 'green');
            } else
                $('#message').html('Not Matching').css('color', 'red');
        });

        if ($("#usertype-1").is(":checked")) {
            $userType = "faculty";
        }
        else if ($("#usertype-0").is(":checked")) {
            $userType = "student";
        }

        $registerBtn = $('#confirmsignup')
            .click(register);
    }

    function register() {
        console.log('register');
        var user = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            email: $emailFld.val(),
            firstName: null,
            lastName: null,
            phone: null,
            dtype: $userType,
            dateOfBirth: null
        };
        console.log(user);

        userService.register(user).then(success);

    }

    function success(response) {
        if (response === null) {
            $('#error5').show();
        }
        else {
            console.log(response);
            window.location.href = "/jquery/components/profile/profile.template.client.html?userId=" + response.id;
        }
    }

})();