<?php
    require "config.php"; 
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca Unialfa</title>
    <base href="<?php echo "http://" . $_SERVER["HTTP_HOST"] . $_SERVER["SCRIPT_NAME"]; ?>">
    <!-- <base href="http://localhost:3306/biblioteca-unialfa/">   http://localhost:8888/biblioteca-unialfa/  --> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/styles.css">

</head>
<body>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="paginas/home">
            <img src="imagens/logo.png" alt="LOGO" width="150" height="50">
        </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="paginas/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">generos aqui</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listar/alunos">Alunos</a>
                </li>
            </ul>

            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Pesquisar..." aria-label="Search">
                <button class="btn btn-info" type="submit">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>
<?php
    $pagina = "home";
        
        if ( isset($_GET["param"]) ) {
                    
            $pag = explode("/", $_GET["param"]);

            $pasta = $pag[0] ?? NULL;
            $pagina = $pag[1] ?? NULL;
            $id = $pag[2] ?? NULL;

            $pag = "{$pasta}/{$pagina}";
        }

        if (file_exists("{$pag}.php")) {
            require "{$pag}.php";
        }else {
            require "paginas/erro.php";
        };
?>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>