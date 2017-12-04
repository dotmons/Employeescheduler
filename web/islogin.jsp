<%-- 
    Document   : islogin
    Created on : 27-Feb-2016, 3:28:11 PM
    Author     : Dotmons
--%>
<!DOCTYPE html>
<html>
<%
    try
    {      
    if (session.getAttribute("username").toString().equals(""))
    {
        response.sendRedirect("logoff");
    }
    }
    catch (Exception e)
    {        
         response.sendRedirect("logoff");
    }
%>
</html>
