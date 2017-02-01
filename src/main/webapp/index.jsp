<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>helloWorld | Observer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="resources/angular/jquery-1.10.0.min.js" type="text/javascript"></script>
    <script src="resources/angular/angular.min.js" type="text/javascript"></script>
    <script src="resources/angular/services.js" type="text/javascript"></script>
    <script src="resources/angular/controllers.js" type="text/javascript"></script>
    <script src="resources/angular/angular-resource.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="resources/angular/angular-ui-router.js"></script>
    <script type="text/javascript" src="resources/angular/angular-animate.js"></script>
    <script src="resources/angular/app.js" type="application/javascript"></script>
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="resources/angular/angular-locale_it-it.js" type="text/javascript"></script>
    <script src="resources/angular/ui-bootstrap-tpls-1.3.3.min.js" type="text/javascript"></script>
    <script src="resources/angular/moment.js" type="text/javascript"></script>
    <script src="resources/angular/angular-material-icons.min.js" type="text/javascript"></script>
    <link href="resources/bootstrap/css/style.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="resources/temp/truck.png">
</head>
<body data-ng-app="helloWorld">

<img style="position: absolute;bottom: 0;right: 0;opacity: 0.12;" src="resources/temp/albero.jpg">

<div data-ng-controller="MainCtrl" data-ng-hide="false">

    <nav class="navbar navbar-default" style="border-bottom-left-radius: 10px;border-bottom-right-radius: 10px;">
        <div class="container-fluid" style="">
           
        </div>
    </nav>

    <div class="well well-lg routing-main">
        <div ui-view></div>
    </div>

    <div class="footer navbar-fixed-bottom text-center"
         style="background-color: #fff; height: 25px; border: 3px solid #e7e7e7;border-radius: 5px;">
       <span style="color: #337ab7;font-weight: 800;">DEMO</span>
    </div>

</div>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
