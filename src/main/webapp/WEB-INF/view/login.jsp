<%@ include file="../common/header.jsp"%>

<div class="container">
    <div class="justify-content-center row">
        <div class="col-md-8 col-lg-6 col-xl-5">
            <div class="mt-4 card">
                <div class="p-4 card-body">
                    <div class="text-center mt-2"><h4 class="text-primary">Member Login</h4></div>
                    <div class="p-2 mt-4">
                        <p class="text-danger"> ${errorMessage} </p>
                        <form action="${pageContext.request.contextPath}/login.do" method="post" id="loginForm">
                            <div class="form-group mb-3">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
                            </div>
                            <div class="form-group mb-3">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
                            </div>
                            <div class="mt-4">
                                <button type="submit" class="btn btn-success w-100 btn btn-success">Sign In</button>
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
        $('#loginForm').validate({
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 12
                }
            },
            messages: {
                username: {
                    required: "Username is required!"
                },
                password: {
                    required: "Password is required!",
                    minlength: "Please enter at least {0} characters",
                    maxlength: "password length not more than {0} characters"
                }
            }
        })
    });

</script>

<%@ include file="../common/footer.jsp"%>