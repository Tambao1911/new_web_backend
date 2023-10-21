<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>
</head>
<body>
	<section class="vh-100">
		<div class="container py-5 h-100">
			<div
				class="row d-flex align-items-center justify-content-center h-100">
				<div class="col-md-8 col-lg-7 col-xl-6">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
						class="img-fluid" alt="Phone image">
				</div>
				<div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}" role="alert">
                                ${message}
                        </div>
                    </c:if>
                    <form action="<c:url value='/dang-nhap'/>" id="formLogin" method="post">
					
						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="text" id="userName"
								class="form-control form-control-lg" name="userName"/> <label
								class="form-label" for="userName">Tên Đăng Nhập</label>
						</div>
						<!-- Password input -->
						<div class="form-outline mb-4">
							<input type="password" id="password"
								class="form-control form-control-lg" name="password"/> <label
								class="form-label" for="password">Mật Khẩu</label>
						</div>
						<input type="hidden" value="login"  name="action" />
						<!-- Submit button -->
						<button type="submit" class="btn btn-primary btn-lg btn-block">Đăng Nhập</button>

						<div class="divider d-flex align-items-center my-4">
							<p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
						</div>

						<a class="btn btn-primary btn-lg btn-block"
							style="background-color: #3b5998" href="#!" role="button"> <i
							class="fab fa-facebook-f me-2"></i>Tiếp Tục Với Facebook
						</a> <a class="btn btn-primary btn-lg btn-block"
							style="background-color: #55acee" href="#!" role="button"> <i
							class="fab fa-twitter me-2"></i>Tiếp Tục Với Twitter
						</a>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>