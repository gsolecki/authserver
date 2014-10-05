<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sparklr</title>

<link type="text/css" rel="stylesheet" href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" />
<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script type='text/javascript'>
$(document).ready(
	function() {
		$.get("photos?callback=pictureDisplay&format=json", function(data, status) {
			for (var i = 0, len = data.length; i < len; i++) {
				var photoName = data[i].name;
				$("#photos").append('<img src="photos/' + photoName + '" alt="' + photoName + '">');
			}
		});
	});
</script>

</head>
<body>

	<div class="container">

		<h1>Sparklr</h1>

		<h2>Home</h2>

		<p>This is a great site to store and view your photos. Unfortunately, we don't have any services for printing your photos. For that, you'll have to go to Tonr.</p>

		<div class="form-horizontal">
			<form action="<c:url value="/logout.do"/>" role="form">
				<button class="btn btn-primary" type="submit">Logout</button>
			</form>
		</div>

		<h2>Your Photos</h2>

		<p id="photos"></p>

		<div class="footer">Sample OAuth Application</div>

	</div>

</body>
</html>
