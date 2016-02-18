<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AirSoft Association</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link href="/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="/AdminLTE2/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>        
        <link href="/AdminLTE2/dist/css/skins/skin-yellow-light.css" rel="stylesheet" type="text/css"/>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="hold-transition skin-yellow-light sidebar-mini">
        <div class="wrapper">

            <!-- Main Header -->
            <header class="main-header">

                <!-- Logo -->
                <a href="index2.html" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>A</b>A</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>AirSoft</b> Association</span>
                </a>

                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>      
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">                                       
                    <!-- Sidebar Menu -->
                    <ul class="sidebar-menu">
                        <li class="header">Opções</li>
                        <!-- Optionally, you can add icons to the links -->
                        <li onclick="loadGamePage()"><a href="#GamePage"><i class="fa fa-link"></i> <span>Jogos</span></a></li>
                        <li onclick="loadPlayerRegister()" ><a href="#newPlayer"><i class="fa fa-link"></i> <span>Cadastrar novo Membro</span></a></li>
                        <li onclick="loadGameRegister()"><a href="#newGame"><i class="fa fa-link"></i> <span>Criar novo Jogo</span></a></li>
                    </ul>
                    <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Welcome!                       
                    </h1>                    
                </section>

                <!-- Main content -->
                <section class="content">

                    <div class="box box-solid" style="background: transparent; box-shadow: none">
                        <div class="box-body">
                            <c:if test="${confirmed!=null}">
                                <div class="alert alert-warning">${confirmed}</div>
                            </c:if>
                        </div>
                    </div>

                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <footer class="main-footer">
                <!-- To the right -->
                <div class="pull-right hidden-xs">
                    AirSoft Association
                </div>
                <!-- Default to the left -->
                <strong>Copyright &copy; 2016 <a href="#">João Marcos F</a>.</strong> All rights reserved.
            </footer>            
        </div>
        <!-- ./wrapper -->
        <script src="/js/dashboard.js" type="text/javascript"></script>
        <!-- REQUIRED JS SCRIPTS -->
        <!-- jQuery 2.1.4 -->
        <script src="/bower_components/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <!-- Bootstrap 3.3.5 -->        
        <script src="/bower_components/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- AdminLTE App -->        
        <script src="/AdminLTE2/dist/js/app.min.js" type="text/javascript"></script>        
    </body>
</html>
