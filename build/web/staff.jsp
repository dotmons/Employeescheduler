<%@ page contentType="text/html; charset=UTF-8" %>

<%
    String ismanager = "";
    try {
        ismanager = session.getAttribute("managerstatus").toString();
    } catch (Exception e) {

    }
    if (ismanager.equals("1")) {
     %>
<%@include file="staffmanager.jsp" %> 
<% } else {%>
<%@include file="staffnonmanager.jsp" %> 
<% }

%>


