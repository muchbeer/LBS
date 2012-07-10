<%@include file="/resources/common/include.jsp"%>
<html>
	<head>
		<title><spring:message code="adduser.title"/></title>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	</head>
	<body>
		<%@include file="/resources/common/header.jsp"%>
		<%@include file="/resources/common/leftpanel.jsp"%>
		<div id="content">
			<div style="margin: 10px;" class="errorMsg">
				<c:if test="${errors != null}">
					<spring:bind path="errors">
						<c:forEach items="${errors.globalErrors}" var="error">
	        				${error.defaultMessage}<br/>
						</c:forEach>
					</spring:bind>
				</c:if>
			</div>
			<form:form action="addUser.htm" method="post" commandName="userCommand">
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td width="30%">
							<label><spring:message code="adduser.label.firstname"></spring:message>:</label>
						</td>
						<td width="70%">
							<form:input path="firstName" autocomplete="false"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="addspace10px"></td>
					</tr>
					<tr>
						<td width="30%">
							<label><spring:message code="adduser.label.middlename"></spring:message>:</label>
						</td>
						<td width="70%">
							<form:input path="middleName" autocomplete="false"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="addspace10px"></td>
					</tr>
					<tr>
						<td width="30%">
							<label><spring:message code="adduser.label.lastname"></spring:message>:</label>
						</td>
						<td width="70%">
							<form:input path="lastName" autocomplete="false"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="addspace10px"></td>
					</tr>
					<tr>
						<td width="30%">
							<label><spring:message code="adduser.label.address"></spring:message>:</label>
						</td>
						<td width="70%">
							<form:input path="address1" autocomplete="false"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="addspace10px"></td>
					</tr>
					<tr>
						<td width="30%">&nbsp;</td>
						<td width="70%">
							<form:input path="address2" autocomplete="false"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="addspace10px"></td>
					</tr>
					<tr>
						<td width="30%">
							<label><spring:message code="adduser.label.contactno"></spring:message>:</label>
						</td>
						<td width="70%">
							<form:input path="contactNo" autocomplete="false"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="addspace10px"></td>
					</tr>
					<tr>
						<td width="30%">
							<label><spring:message code="adduser.label.recamount"></spring:message>:</label>
						</td>
						<td width="70%">
							<form:input path="reccuringAmount" autocomplete="false"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="addspace10px"></td>
					</tr>
					<tr>
						<td width="30%">&nbsp;</td>
						<td width="70%">
							<input type="submit" name="btnSubmit" value='<spring:message code="adduser.btn.createuser"/>'/>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</body>
</html>