(function(w, d) {
	$(d).ready(function(e) {
		
		$("#s_loginName, #s_emailId").keyup(function(e) {
			e.preventDefault();
			if(e.keyCode == 13) {
				$("#searchUser").click();
			}
		});
      $("#backreport1").click(function(e) {
			
			$("#tbl_report").css('display', '');
			location.href="userReport";
		
		});
		
		$("#backreport").click(function(e) {
			
			$("#tbl_report").css('display', '');
			$("#backreport").css('display', 'none');
			$("#tbl_usrProfile").css('display', 'none');
		});
       
		
		$("table#tbl_report a.editLink").click(function(e) {
			
			$("#noUserFound").css('display', 'none');
			$("#tr_error").css('display', 'none');
			var loginName = $(e.currentTarget).attr('loginName');
			var emailId = null;
			if(loginName != null) {
				var searchUrl = "search";
				
				$.ajax({
					url : searchUrl,
					type : "POST",
					data : {
						loginName : loginName,
						emailId : emailId
					},
					success : function(data, textStatus, jqXHR) {
						if(data != null && data != "") {
							$("input[name='loginIdOfUser']").val(data.loginid);
							$("input[name='firstName']").val(data.firstname);
							$("input[name='middleName']").val(data.middlename);
							$("input[name='lastName']").val(data.lastname);
							$("input[name='loginName']").val(data.loginname);
							$("input[name='loginName']").attr('disabled', true);
							$('input:radio[name=sex]:nth('+data.sex+')').prop('checked',true);
							$("input[name='dateOfBirth']").val(data.dobStr);
							$("input[name='mobileNo']").val(data.mobno);
//							$("input[name='mailId']").attr('disabled', true);
							$("input[name='mailId']").val(data.emailid);
							$("select[name='status']").val(data.status);
							$("select[name='userType']").val(data.userTypeId);
							$("#tbl_row_password").css('display', 'none');
							$("input[type='submit']").removeAttr('disabled');
							$('form#userform').attr('action', 'edit');
							$("#tbl_usrProfile").css('display', '');
							$("#backreport").css('display', '');
							$("#tbl_report").css('display', 'none');
						} else {
							$("#noUserFound").css('display', 'block');
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						//alert("Server down.");
					}
				});
			} else {
				alert("Login Name not found.");
			}
		});
		$("#searchUser").click(function(e) {
			$("#noUserFound").css('display', 'none');
			$("#tr_error").css('display', 'none');
			var loginName = $("input[name='s_loginName']").val();
			var emailId = $("input[name='s_emailId']").val();

			loginName = loginName == "" ? null : loginName;
			emailId = emailId == "" ? null : emailId;

			if (loginName != null || emailId != null) {

				var searchUrl = "search";

				$.ajax({
					url : searchUrl,
					type : "POST",
					data : {
						loginName : loginName,
						emailId : emailId
					},
					success : function(data, textStatus, jqXHR) {
						if(data != null && data != "") {
							$("input[name='loginIdOfUser']").val(data.loginid);
							$("input[name='firstName']").val(data.firstname);
							$("input[name='middleName']").val(data.middlename);
							$("input[name='lastName']").val(data.lastname);
							$("input[name='loginName']").val(data.loginname);
							$("input[name='loginName']").attr('disabled', true);
							$('input:radio[name=sex]:nth('+data.sex+')').prop('checked',true);
							$("input[name='dateOfBirth']").val(data.dobStr);
							$("input[name='mobileNo']").val(data.mobno);
//							$("input[name='mailId']").attr('disabled', true);
							$("input[name='mailId']").val(data.emailid);
							$("select[name='status']").val(data.status);
							$("select[name='userType']").val(data.userTypeId);
							$("#tbl_row_password").css('display', 'none');
							$("#tbl_usrProfile").css('display', '');
							$("#tbl_report").css('display', 'none');
							$("#backreport").css('display', '');
							$("input[type='submit']").removeAttr('disabled');
							$('form#userform').attr('action', 'edit');
						} else {
							$("#noUserFound").css('display', 'block');
							$("#tbl_usrProfile").css('display', 'none');
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						//alert("Server down.");
						window.location = window.location.origin + "/" + window.location.pathname.split("/")[1] + "/" + "error";
					}
				});
			} else {
				alert("Please insert atleast one filter to search");
			}

		});
		
		$("#loginName").blur(function (e){

			var loginName = $("input[name='loginName']").val();
			loginName = loginName == "" ? null : loginName;
			var searchUrl = "checkloginname";

			$.ajax({
				url : searchUrl,
				type : "POST",
				data : {
					loginName : loginName
				
					
				},
				success : function(data, textStatus, jqXHR) {
				
					if(data) {
						$("#tr_error td").html("Login Name Already Exists");
						$("#tr_error").css('display', 'block');
						$("input[name='loginName']").val("");
						$("input[name='loginName']").focus();
					} else {
						$("#tr_error td").html("");
						$("#tr_error").css('display', 'none');
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
					//alert("Server down.");
				}
			});
		
		});
		
		
		$("#123444").blur(function (e){
			
			var mailId = $("input[name='mailId']").val();
			mailId = mailId == "" ? null : mailId;
			var searchUrl = "checkMailId";

			$.ajax({
				url : searchUrl,
				type : "POST",
				data : {
							mailId : mailId
						},
				success : function(data, textStatus, jqXHR) {
				
					if(data) {
						$("#tr_error td").html("Email Already Exists");
						$("#tr_error").css('display', 'block');
						$("input[name='mailId']").val("");
						$("input[name='mailId']").focus();
					} else {
						$("#tr_error").css('display', 'none');
						$("#tr_error td").html("");
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
				//	alert("Server down.");
				}
			});
		
		});
		
		$(".paginationDiv a").click(function(e) {
			var pageSize = $('#pageSize').html();
			var lastPageNum = $('#lastPageNum').html();
			var currPageNo = $(e.target).attr('pageno');
			var endIndx = (currPageNo * pageSize) + 1;
			var startIndx = endIndx - pageSize + 1;
			
			$(".paginationDiv a").css('color','');
			$(".paginationDiv a[pageno='"+currPageNo+"']").css('color','darkgrey');
			
			$(".paginationDiv a").css('display','none');
			$(".paginationDiv a[pageno='"+(currPageNo-2)+"']").css('display','');
			$(".paginationDiv a[pageno='"+(currPageNo-1)+"']").css('display','');
			$(".paginationDiv a[pageno='"+currPageNo+"']").css('display','');
			$(".paginationDiv a[pageno='"+(currPageNo-(-1))+"']").css('display','');
			$(".paginationDiv a[pageno='"+(currPageNo-(-2))+"']").css('display','');
			
			$('a.firstPage').css('display','');
			$('a.lastPage').css('display','');
			/*$('a.firstPage').css('color','darkgrey');
			$('a.lastPage').css('color','darkgrey');*/
			
			if(currPageNo > 3) {
				$('span.firstPagiDots').css('color','darkgrey');
			} else {
				$(".paginationDiv a[pageno='4']").css('display','');
				$(".paginationDiv a[pageno='5']").css('display','');
			}
			if(currPageNo < (lastPageNum - 2)) {
				$('span.lastPagiDots').css('color','darkgrey');
			} else {
				$(".paginationDiv a[pageno='"+(lastPageNum-3)+"']").css('display','');
				$(".paginationDiv a[pageno='"+(lastPageNum-4)+"']").css('display','');
			}
			if(currPageNo == 1) {
				$('a.firstPage').css('color','darkgrey');
			} else if(currPageNo == lastPageNum) {
				$('a.lastPage').css('color','darkgrey');
			}
			
			$("#tbl_report tr").css('display','');
			$("#tbl_report tr:lt("+startIndx+")").css('display','none');
			$("#tbl_report tr:gt("+endIndx+")").css('display','none');
			$("#tbl_report tr#th_report").css('display','');
			$("#tbl_report tr.tr_pagination").css('display','');
		});

	});
}(window, document));
