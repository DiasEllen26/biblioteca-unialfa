<?php
if (isset($_GET['genero'])) {
  $genero = $_GET['genero'];

  $sql = "SELECT livro.*, autor.nome AS nome_autor
          FROM livro
          JOIN autor ON livro.autor_id = autor.id
          WHERE livro.genero = :genero";
  $dados = $pdo->prepare($sql);
  $dados->bindParam(':genero', $genero);
  $dados->execute();
  $livros = $dados->fetchAll(PDO::FETCH_OBJ);
}
?>

<div class="container text-center">
  <h2>LIVROS DE <?= $genero ?></h2>
  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4">
    <?php foreach ($livros as $livro){ ?>
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
    <?php } ?>
  </div>
</div>
