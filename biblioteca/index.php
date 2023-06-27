<?php
    require "config.php"; 
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="imagens/logo.png">
    <title>Biblioteca Unialfa</title>
    <base href="<?php echo "http://" . $_SERVER["HTTP_HOST"] . $_SERVER["SCRIPT_NAME"]; ?>">    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/styles.css">
    
</head>
<body>
<?php
  $sqlGenero = "SELECT DISTINCT genero FROM livro ORDER BY genero";
  $stmt = $pdo->query($sqlGenero);
  $generos = $stmt->fetchAll(PDO::FETCH_COLUMN);
  

?>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="paginas/home">
            <img src="imagens/logo.png" alt="LOGO" width="150" height="50">
        </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

        <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="paginas/home">TODOS OS LIVROS</a>
                </li>
            <?php
               foreach ($generos as $genero) {
                echo 
                '<li><a class="nav-link active" aria-current="page" href="paginas/genero?genero=' . $genero .'">' . $genero .'</a></li>';
            }
            ?>
            </ul>
        </div>
    </div>
</nav>

    <?php
        $pagina = "home";

        if (isset($_GET["param"])) {
            $pagina = $_GET["param"];
            $param= explode("/", $pagina);
            $pagina = $param[1];  
          }
  
        $pagina = "paginas/{$pagina}.php";
        if (file_exists($pagina) ) {
            require $pagina;
        } else {
            require "./paginas/erro.php";
          }

        
?>

<footer class="bg-primary text-white py-5">
  <div class="container text-center">
    <p class="mb-0">Desenvolvido por Ellen Dias, João Gabriel e Vitor Inácio</p>
  </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>