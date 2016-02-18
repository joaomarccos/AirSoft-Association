<%-- 
    Document   : allGames
    Created on : Feb 16, 2016, 11:56:42 PM
    Author     : João Marcos <joaomarccos.github.io>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Próximos jogos
    </h1>                    
</section>

<!-- Main content -->
<section class="content pad">
    <div class="box box-solid">
        <table class="table table-hover">
            <c:forEach var="game" items="${games}">
                <tr onclick="viewGame('${game.id}')" style="cursor: pointer">
                    <td>
                        <img src="/game/image/${game.id}" alt="imagem tematica" class="img-sm">
                    </td>
                    <td>
                        ${game.timetable}
                    </td>                    
                    <td>
                        ${game.site}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>

<section class="modal-wrapper">

</section>
<!-- /.content -->
