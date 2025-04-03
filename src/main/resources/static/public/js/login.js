var pageTitle = "Login";

function Registration() {
    $.ajax({
        data: JSON.stringify({
            'data': formToJson("#user_registration")
        }),
        url: "/registration",
        type: "POST",
        success: function (res) {
            var response = JSON.parse(res);
            if (response.success) {
                $("#user_registration")[0].reset();
                window.location = window.location.href+"?success";
            } else {
                window.location = window.location.href+"?error";
            }
        },
        error: function (res) {
            notifyError("Error")
        }
    });
}