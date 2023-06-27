<?php

$sql = "SELECT livro.*, autor.nome AS nome_autor
        FROM livro
        JOIN autor ON livro.autor_id = autor.id";
$stmt = $pdo->prepare($sql);
$stmt->execute();
$dados = $stmt->fetchAll(PDO::FETCH_OBJ) ?? NULL;
?>

<div class="banner w-100">
  <img src="./imagens/banner.png" alt="UniAlfa" class="img-fluid d-block">
</div>

<h2 class="text-center w-100">TODOS OS LIVROS</h2>
<div class="container text-center">
  <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4">
    <?php foreach ($dados as $livro) { ?>
      <div class="col mb-4">
        <div class="card h-90">
          <div class="card" style="width: 18rem;">
            <div class="position-relative">
              <img src="<?= $livro->imagem_url ?>" class="card-img-top" alt="<?= $livro->titulo ?>">
              <div class="card-overlay">
                <h5 class="card-title"><?= $livro->titulo ?></h5>
                <p class="card-text"><strong>Autor: </strong><?= $livro->nome_autor ?></p>
                <a href="paginas/livro?id=<?= $livro->id ?>" class="btn btn-primary">Detalhes</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    <?php } ?>
  </div>
</div>
