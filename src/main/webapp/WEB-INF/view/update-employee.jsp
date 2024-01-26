<%@ include file="../common/header.jsp" %>

<div class="container">
    <div class="justify-content-center row">
        <div class="col-md-8 col-lg-6 col-xl-5">
            <div class="mt-4 card">
                <div class="p-4 card-body">
                    <div class="text-center mt-2"><h4 class="text-primary">Update Employee</h4></div>
                    <div class="p-2 mt-4">
                        <p class="text-danger"> ${errorMessage} </p>
                        <form action="${pageContext.request.contextPath}/update-employee.do" method="post" id="updateEmployeeForm">
                            <input type="hidden" name="id" value="${employee.id}">
                            <div class="form-group mb-3">
                                <label for="firstname">First Name</label>
                                <input type="text" class="form-control" id="firstname" name="firstname"
                                       placeholder="Enter Firstname" value="${employee.firstName}">
                            </div>
                            <div class="form-group mb-3">
                                <label for="lastname">Last Name</label>
                                <input type="text" class="form-control" id="lastname" name="lastname"
                                       placeholder="Enter Lastname" value="${employee.lastName}">
                            </div>
                            <div class="form-group mb-3">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email"
                                       placeholder="Enter Email" value="${employee.email}">
                            </div>
                            <div class="mt-4">
                                <button type="submit" class="btn btn-success w-100 btn btn-success">Update Employee</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $(document).ready(function () {
        $('#updateEmployeeForm').validate({
            rules: {
                firstname: {
                    required: true
                },
                lastname: {
                    required: true
                },
                email: {
                    required: true,
                }
            },
            messages: {
                firstname: {
                    required: "First name is required!"
                },
                lastname: {
                    required: "Last name is required!"
                },
                email: {
                    required: "Email is required!",
                }
            }
        })
    });

</script>

<%@ include file="../common/footer.jsp" %>