<%@page import="com.example.contacts.Contact"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String error = null;
    if(request.getParameter("insert")!=null){
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        try{
            Contact.insert(name, mail, phone);
        }catch(Exception e){error = e.getLocalizedMessage();}
    }else if(request.getParameter("update")!=null){
        String oldName = request.getParameter("oldName");
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        try{
            Contact.update(oldName, name, mail, phone);
        }catch(Exception e){error = e.getLocalizedMessage();}
    }else if(request.getParameter("delete")!=null){
        String name = request.getParameter("delete");
        try{
            Contact.delete(name);
        }catch(Exception e){error = e.getLocalizedMessage();}
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebApp - Contatos</title>
    </head>
    <body>
        <h1>Contatos</h1>
        <%if(error != null){%>
        <h2 style="color: red;">Erro: <%=error%></h2>
        <%}%>
        <fieldset>
            <% if(request.getParameter("prepare")!=null){ %>
            <% Contact c = Contact.getContact
            (request.getParameter("prepare")); %>
            <legend>Alterar</legend>
            <form>
                <input type="hidden" name="oldName" 
                       value="<%= c.getName()%>" />
                Nome: <input type="text" name="name" 
                             value="<%= c.getName() %>" />
                Email: <input type="text" name="mail" 
                              value="<%= c.getMail()%>" />
                Telefone: <input type="text" name="phone" 
                              value="<%= c.getPhone()%>" />
                <input type="submit" name="update" value="Alterar" />
            </form>
            <% }else{ %>
            <legend>Incluir</legend>
            <form>
                Nome: <input type="text" name="name" />
                Email: <input type="text" name="mail" />
                Telefone: <input type="text" name="phone" />
                <input type="submit" name="insert" value="Inserir" />
            </form>
            <% } %>
        </fieldset>
        <hr/>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Telefone</th>
                <th>Comandos</th>
            </tr>
            <% 
                for(Contact c: Contact.getList()){%>
            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getMail() %></td>
                <td><%= c.getPhone() %></td>
                <td>
                    <a href="?prepare=<%= c.getName() %>">
                        <button>Alterar</button>
                    </a>
                        <a href="?delete=<%= c.getName() %>">
                        <button>Excluir</button>
                    </a>
                </td>
            </tr>
            <% }%>
        </table>
    </body>
</html>