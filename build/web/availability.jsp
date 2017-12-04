<%
    String ismanager = "";
    try {
        ismanager = session.getAttribute("managerstatus").toString();
    } catch (Exception e) {

    }
    if (ismanager.equals("1")) {%>
<%@include file="availablemanager.jsp" %> 
<% } else {%>
<%@include file="availablestaff.jsp" %> 
<% }

%>
