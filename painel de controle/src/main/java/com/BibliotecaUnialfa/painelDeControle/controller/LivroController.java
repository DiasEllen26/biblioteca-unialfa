package com.BibliotecaUnialfa.painelDeControle.controller;

import com.BibliotecaUnialfa.painelDeControle.model.Livro;
import com.BibliotecaUnialfa.painelDeControle.servicie.AutorService;
import com.BibliotecaUnialfa.painelDeControle.servicie.EditoraService;
import com.BibliotecaUnialfa.painelDeControle.servicie.LivroServicie;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("livro")
public class LivroController {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "ddsjxmzpg",
            "api_key", "652556558283329",
            "api_secret", "eeF0a7uHyfYmDqKHcWMOTTHYhCg"));


    @Autowired
    private LivroServicie service;
    @Autowired
    private AutorService serviceAutor;
    @Autowired
    private EditoraService serviceEditora;

    @GetMapping("/lista")
    public String index(Model model){
        model.addAttribute("MensagemTelaInicil", "Todos os Livros!");
        model.addAttribute("livros", service.listarTodos());
        return "livro/lista";
    }

    @GetMapping("/formulario")
    public String formulario(Model model, Livro livro){

        model.addAttribute("MensagemTelaInicil", "Cadastrar novo livro!");
        model.addAttribute("autores", serviceAutor.listarTodos());
        model.addAttribute("editoras", serviceEditora.listarTodos());
        return "livro/formulario";
    }
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam("file")MultipartFile file, @Valid Livro livro, BindingResult result, Model model) throws IOException {
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("autores", serviceAutor.listarTodos());
            model.addAttribute("editoras", serviceEditora.listarTodos());
            return "livro/formulario";
        }

        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("secure_url");
            livro.setImagemUrl(imageUrl);
            System.out.println(imageUrl);
            service.salvar(livro);
            return "redirect:/livro/lista";
        }catch (Exception e){
            livro.setImagemUrl("https://res.cloudinary.com/ddsjxmzpg/image/upload/v1687396258/ndk0zxlashgwgzf9v8dq.jpg");
            service.salvar(livro);
            return "redirect:/livro/lista";
        }

    }
    @GetMapping("/pesquisar")
    public String pesquisarLivros(@RequestParam("termo") String termo, Model model) {
        model.addAttribute("MensagemTelaInicil", "Livros encontrados");
        model.addAttribute("livros", service.pesquisarLivros(termo));
        return "livro/lista";
    }


    @GetMapping("/alterar/{id}")
    public String editar(@PathVariable Long id, Model model){
        model.addAttribute("MensagemTelaInicil", "Editar dados do livro!");
        model.addAttribute("livro", service.buscarPorId(id));
        model.addAttribute("autores", serviceAutor.listarTodos());
        model.addAttribute("editoras", serviceEditora.listarTodos());
        return "livro/formulario";
    }


    @GetMapping("deletar/{id}")
    public String deletar(@PathVariable Long id) throws IOException{
        var livro = service.buscarPorId(id);
        String imagePublicId = livro.getImagemUrl();
        try {
            cloudinary.uploader().destroy(imagePublicId, ObjectUtils.emptyMap());
            service.deletarPorId(id);
            return "redirect:/livro/lista";
        } catch (IOException e) {
            System.out.println("Erro de IO ao excluir a imagem: " + e.getMessage());
            return "redirect:/erro";
        }
    }

}
