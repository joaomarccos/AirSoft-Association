<%-- 
    Document   : newGame
    Created on : Feb 16, 2016, 12:13:17 PM
    Author     : João Marcos <joaomarccos.github.io>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Novo Jogador                     
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
        <form id="new-player" class="form-horizontal" onsubmit="savePlayer(); return false;">
            <div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required placeholder="Nome completo" name="name">
                    </div>
                </div>                                                      
                <div class="form-group">
                    <label class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" required placeholder="Email" name="email">
                    </div>
                </div>                    
                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefone</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required placeholder="Telefone" name="phone">
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

