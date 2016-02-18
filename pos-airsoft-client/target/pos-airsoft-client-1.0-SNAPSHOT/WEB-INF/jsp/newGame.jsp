<%-- 
    Document   : newGame
    Created on : Feb 16, 2016, 12:13:17 PM
    Author     : João Marcos <joaomarccos.github.io>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Novo Jogo                     
    </h1>                    
</section>

<!-- Main content -->
<section class="content pad">

    <div class="box box-solid">
        <div class="box-header with-border">
            <h3 class="box-title">Formulário</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form id="new-game" class="form-horizontal" onsubmit="saveGame(); return false;">
            <div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Objetivo</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required placeholder="Objetivo" name="goal">
                    </div>
                </div>                    
                <div class="form-group">
                    <label class="col-sm-2 control-label">Enrero</label>
                    <div class="col-sm-10">
                        <textarea id="plot" class="form-control" required placeholder="Enredo" name="plot"></textarea>
                    </div>
                </div>                    
                <div class="form-group">
                    <label class="col-sm-2 control-label">Missão</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required placeholder="Missão" name="mission">
                    </div>
                </div>                    
                <div class="form-group">
                    <label class="col-sm-2 control-label">Local</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required placeholder="Local" name="site">
                    </div>
                </div>                    
                <div class="form-group">
                    <label class="col-sm-2 control-label">Horário</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required placeholder="31/12/2016 10:40" name="timeTable">
                    </div>
                </div>                    
                <div class="form-group">
                    <label class="col-sm-2 control-label">Foto temática</label>
                    <div class="col-sm-10">
                        <input type="file" id="file" class="form-control" required accept="image/*" name="thematicImage">
                    </div>
                </div>                    
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
                <button type="submit" class="btn btn-info pull-right">Salvar</button>
        </form>
    </div>
    <div class="overlay" hidden>
        <i class="fa fa-refresh fa-spin"></i>
    </div>
    <!-- /.box-footer -->
</div>

</section>
<!-- /.content -->

