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

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            Hello cafe manager - ${dashboardModel.manager.userName}
        </div>
        <a class="btn btn-link" href="/manager/update_user/${dashboardModel.manager.id}"> Edit profile</a>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <h4>Waiters List</h4>
                <div class="col-md-6">
                    <a class="btn btn-default" href="/manager/create_user">Add Waiter</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th>User Name</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th colspan="2">Actions</th>
                    <th>Last edited</th>
                    </thead>
                    <tbody>
                    <c:if test="${not empty dashboardModel.waiters}">
                        <c:forEach var="waiter" items="${dashboardModel.waiters}">
                            <tr>
                                <td>${waiter.userName}</td>
                                <td>${waiter.firstName}</td>
                                <td>${waiter.lastName}</td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">

                                        <a class="btn btn-primary btn-xs" href="/manager/update_user/${waiter.id}">
                                            <span class="glyphicon glyphicon-pencil"></span> Edit
                                        </a>
                                    </p>
                                </td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">

                                        <a class="btn btn-danger btn-xs" href="/manager/delete_user/${waiter.id}">
                                            <span class="glyphicon glyphicon-trash"></span> Delete
                                        </a>

                                    </p>
                                </td>
                                <td>${waiter.updated}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <h4>Tables List</h4>
                <div class="col-md-6">
                    <a class="btn btn-default" href="/manager/create_table">Add Table</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="mytable2" class="table table-bordred table-striped">
                    <thead>
                    <th>Table Number</th>
                    </thead>
                    <tbody>
                    <c:if test="${not empty dashboardModel.tables}">
                        <c:forEach var="table" items="${dashboardModel.tables}">
                            <tr>
                                <td>${table.tableNumber}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>

</div>
</body>
</html>