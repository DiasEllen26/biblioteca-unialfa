<?php
    require "config.php"; 
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca</title>
    <base href="http://localhost:PORTA/BANCO/">


</head>
<body>


    <?php

        $pagina = "index";
        if ( isset($_GET["param"]) ) {
            $pagina = $_GET["param"];
            $pag = explode("/", $pagina);
            $pagina = $pag[0];
        }
        $pagina = "{$pagina}.php";
        if ( file_exists($pagina) ) {
            require $pagina;
        } else {
            require "erro.php";
        }
    ?>


</body>
</html>