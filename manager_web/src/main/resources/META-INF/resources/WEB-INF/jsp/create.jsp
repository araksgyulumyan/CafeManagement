<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
            integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <style>
        .error {
            color: #ff0000;
            font-style: italic;
        }
    </style>

</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-12">
            <a class="btn btn-link" href="/manager/dashboard">Go to dashboard</a>
        </div>
    </div>


    <div class="row">
        <div class="col-md-6 col-md-offset-3">

            <h2>Add waiter</h2>

            <form:form action="/manager/create_user" method="post" id="createUserForm"
                       modelAttribute="userCreationRequestModel">

                <div class="form-group">
                    <form:label class="control-label" path="userName" for="userName">Username:</form:label>
                    <div class="input-group">
                        <form:input path="userName" class="form-control" placeholder="Username"/>
                    </div>
                    <form:errors path="userName" cssClass="error"/>
                </div>

                <div class="form-group">
                    <form:label class="control-label" path="password" for="password">Password:</form:label>
                    <div class="input-group">
                        <form:password path="password" class="form-control" placeholder="Password"/>
                    </div>
                    <form:errors path="password" cssClass="error"/>
                </div>

                <div class="form-group">
                    <form:label class="control-label" path="firstName" for="firstName">First name:</form:label>
                    <div class="input-group">
                        <form:input path="firstName" class="form-control" placeholder="First name"/>
                    </div>
                    <form:errors path="firstName" cssClass="error"/>
                </div>

                <div class="form-group">
                    <form:label class="control-label" path="lastName" for="lastName">Last name:</form:label>
                    <div class="input-group">
                        <form:input path="lastName" class="form-control" placeholder="Last name"/>
                    </div>
                    <form:errors path="lastName" cssClass="error"/>
                </div>

                <button type="submit" class="btn btn-primary">Create</button>

            </form:form>
        </div>
    </div>
</div>

</body>
</html>
