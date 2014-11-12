<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<title>多文件控制</title>
	
	<meta http-equiv="description" content="error">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		function checkFile() {
			if($("#all").attr("checked")){
				$("input[name='attachmentPath']").attr("checked",true);
			}else {
				$("input[name='attachmentPath']").attr("checked",false);
			}
		}
		
	</script>
	</head>

	<body>
	
		<form  action="downloadMultiFile" method="post">
			<table>
				 <tr>
			         <th>
			         		<input type="checkbox" name="all" id="all" onchange="checkFile()">全选
			         </th>
			          <th>
			         		文件名
			         </th>
			          <th>
			         		文件路径
			         </th>
			     </tr>
			    <c:forEach items="${attachmentList}" var="attachment">
			    	<tr>
			    		<td>
			    			<input type="checkbox" name="attachmentPath" value="${attachment.filePath}">
			    		</td>
			    		<td>${attachment.fileName}</td>
			    		<td>${attachment.filePath}</td>
			    	</tr>
			    </c:forEach>
			</table>
			<tr>
				<td>
					<input type="submit" value="下载所选文件" id="submit">
				</td>
			</tr>
		</form>
		
	</body>
</html>
