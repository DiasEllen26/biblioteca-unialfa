<?php

    $sql = "SELECT aluno.*, curso.nome AS nome_curso FROM aluno JOIN curso ON aluno.curso_id = curso.id";
    $con = $pdo->query($sql);
    $dados = $con->fetchAll(PDO::FETCH_OBJ);

?>
<div class="card">
    <div class="card-header">
        <h2 class="float-center">Alunos</h2>
    </div>

    <div class="card-body">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">RA</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Endereço</th>
                    <th scope="col">Cidade</th>
                    <th scope="col">UF</th>
                    <th scope="col">Telefone</th>
                    <th scope="col">Curso</th>

                </tr>
            </thead>
            <tbody>
                <?php    
                foreach($dados as $dado){
                    ?>
                    <tr>
                        <th scope="row"><?=$dado->id?></th>
                        <td><?=$dado->ra?></td>
                        <td><?=$dado->nome?></td>
                        <td><?=$dado->endereco?></td>
                        <td><?=$dado->cidade?></td>
                        <td><?=$dado->uf?></td>
                        <td><?=$dado->telefone?></td>
                        <td><?=$dado->nome_curso?></td>

                    </tr>
                    <?php
                };
                ?>
                
            </tbody>
        </table>
    </div>
</div>