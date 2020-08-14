$(function() {
	$("#submitBtn").click(function() {
		var form = $(".my-login-validation");
        if (form[0].checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
		form.addClass('was-validated');
	});
});
