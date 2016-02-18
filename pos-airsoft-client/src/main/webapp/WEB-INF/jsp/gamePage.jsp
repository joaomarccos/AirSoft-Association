<%-- 
    Document   : gamePage
    Created on : Feb 16, 2016, 10:10:59 PM
    Author     : João Marcos <joaomarccos.github.io>
--%>

<section class="content-header">
    <h1>
        Jogos                  
    </h1>                    
</section>

<!-- Main content -->
<section class="content">
    <div class="row">

        <div class="col-md-3 col-sm-6 col-xs-12">
            <a href="#nextGames">
                <div onclick="loadAllGames()" class="info-box bg-yellow-gradient">
                    <span class="info-box-icon"><i class="fa fa-calendar"></i></span>
                    <div class="info-box-content">
                        <span class="info-box-text">Próximos Jogos</span>                    
                    </div><!-- /.info-box-content -->
                </div><!-- /.info-box -->
            </a>
        </div><!-- /.col -->

        <div class="col-md-3 col-sm-6 col-xs-12">
            <a href="#finishedGames">
                <div onclick="loadFinishedGames(1)" class="info-box bg-blue-gradient">
                    <span class="info-box-icon"><i class="fa fa-thumbs-o-up"></i></span>
                    <div class="info-box-content">
                        <span class="info-box-text">Jogos Realizados</span>                    
                    </div><!-- /.info-box-content -->
                </div><!-- /.info-box -->
            </a>
        </div><!-- /.col -->
    </div>

</section>