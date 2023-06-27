<?php
if (isset($_GET['id'])) {
  $id = $_GET['id'];

  $sql = 'SELECT livro.*, autor.nome AS nome_autor, editora.nome AS nome_editora, reserva.id AS reserva_id
          FROM livro
          JOIN autor ON livro.autor_id = autor.id
          JOIN editora ON livro.editora_id = editora.id
          LEFT JOIN reserva ON livro.id = reserva.livro_id
          WHERE livro.id = :id';
  $stmt = $pdo->prepare($sql);
  $stmt->bindParam(':id', $id, PDO::PARAM_INT);
  $stmt->execute();
  $livro = $stmt->fetch(PDO::FETCH_OBJ);

  if ($livro) {
    $titulo = $livro->titulo;
    $autor = $livro->nome_autor;
    $imagem = $livro->imagem_url;
    $ano = $livro->ano;
    $editora = $livro->nome_editora;
    $genero = $livro->genero;
    $ibsn = $livro->ibsn;
    $local = $livro->local;
    $sub = $livro->sub_titulo;
    $reserva_id = $livro->reserva_id;

    ?>
    <h2 class="bg-primary text-light text-center w-100 p-3"><?= $titulo ?></h2>
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <img src="<?= $imagem ?>" alt="<?= $titulo ?>" class="img-fluid">
        </div>
        <div class="col-lg-6">
          <strong><p>Autor:</strong> <?= $autor ?></p>
          <strong><p>Subtitulo:</strong> <?= $sub ?></p>
          <strong><p>Ano:</strong> <?= $ano ?></p>
          <strong><p>Editora:</strong> <?= $editora ?></p>
          <strong><p>Genero:</strong> <?= $genero ?></p>
          <strong><p>Ibsn:</strong> <?= $ibsn ?></p>
          <strong><p>Local:</strong> <?= $local ?></p>
          <?php if ($reserva_id) { ?>
            <div class="alert alert-danger" role="alert">
              Reservado
            </div>
          <?php } else { ?>
            <div class="alert alert-success" role="alert">
              Disponível para reserva
            </div>
          <?php } ?>
        </div>
      </div>
    </div>
<?php 
  }
}
?>
