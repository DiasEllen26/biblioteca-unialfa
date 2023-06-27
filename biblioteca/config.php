<?php
    $servidor = "localhost";
    $usuario  = "root";
    $senha    = ""; 
    $banco    = "biblioteca_unialfa";

    try {                                                    //port=8889 ou 3306
        $pdo = new PDO("mysql:host={$servidor};dbname={$banco};port=3310;charset=utf8;",$usuario,$senha);
    } catch (Exception $e) {
        echo "<p>Erro ao tentar conectar</p>";
        echo $e->getMessage();
    }