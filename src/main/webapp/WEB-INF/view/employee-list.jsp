<%@ include file="../common/header.jsp"%>

<div class="container">
    <h2 class="mb-2">Welcome ${sessionScope.username}</h2>

    <hr>
    <h5>Manage Employee</h5>
    <hr>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/update-employee.do?empId=${employee.id}" class="btn btn-info btn-sm">Edit</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/delete-employee.do?empId=${employee.id}" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../common/footer.jsp"%>