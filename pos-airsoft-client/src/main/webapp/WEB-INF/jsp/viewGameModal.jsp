<%-- 
    Document   : viewGameModal
    Created on : Feb 16, 2016, 11:32:33 PM
    Author     : João Marcos <joaomarccos.github.io>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Jogo</h4>                
                <span class="pull-right label label-warning">${selected.status}</span>
            </div>
            <div class="modal-body">
                <img src="/game/image/${selected.id}" class="img-lg img-bordered margin pull-right" alt="Imagem tematica">
                <p><b>Objetivo:</b> ${selected.goal}</p>                
                <p><b>Missão: </b>${selected.mission}</p>
                <p><b>Enredo </b>${selected.plot}</p>
                <p><b>Local: </b>${selected.site}</p>
                <p><b>Horário </b>${selected.timetable}</p>
                <br>

                <h4>Participantes</h4>
                <table class="table table-striped">
                    <c:forEach items="${selected.players}" var="player">
                        <tr>
                            <td>${player.name}</td>
                            <td>${player.email}</td>
                            <td>${player.phone}</td>
                        </tr>
                    </c:forEach>
                </table>

                <c:if test="${selected.album.name != null}">
                    <h4>Album de fotos <span class="text-muted text-sm">${selected.album.name}</span>
                    </h4>
                    <div class="row">
                        <div class="col-md-12">
                            <c:forEach items="${selected.album.images}" var="image">
                                <img src="/game/album/image/${selected.album.id}/${image.id}" class="img-md margin" alt="imagem">
                            </c:forEach>
                        </div>
                    </div>                  

                </c:if>

                <c:if test="${selected.status == 'FINISHED' && selected.album.name == null}">
                    <form id="album" onsubmit="sendAlbum('${selected.id}');
                            return false;" enctype="multipart/form-data">
                        <h4>Enviar fotos do jogo</h4>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Nome do Albúm</label>
                            <div class="col-sm-7">
                                <input type="text" id="name" required class="form-control"  name="name">                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fotos do Jogo</label>
                            <div class="col-sm-7">
                                <input type="file" id="files" class="form-control" required  name="files" multiple accept="image/*">                                
                            </div>
                            <div class="col-sm-2">
                                <button class=" btn btn-success"  type="submit">Enviar</button>                                                    
                            </div>
                            <br>
                        </div>
                        <br>                        
                        <br>
                        <br>
                    </form>
                </c:if>                               

            </div>
            <div class="modal-footer">
                <c:if test="${selected.status == 'DEFAULT'}">
                    <div class="btn-group">
                        <button type="button" onclick="finishGame('${selected.id}')" class="btn btn-warning pull-left" data-dismiss="modal">Encerrar</button>
                        <button type="button" onclick="cancelGame('${selected.id}')" class="btn btn-warning pull-left" data-dismiss="modal">Cancelar esse Jogo</button>
                    </div>
                </c:if>                
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Fechar</button>                
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<script>
    $('#modal').modal('show');
</script>