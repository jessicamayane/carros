package br.edu.usj.ads.pw.carros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarroController {

    @Autowired
    CarroRepository carroRepository;
    
    @GetMapping(value="/")
    public ModelAndView getIndex() {
        List<Carro> lista = carroRepository.findAll();


    
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("lista_carros", lista);
    return modelAndView;

    }
        
    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
        Carro carro = new Carro();
        ModelAndView modelAndView = new ModelAndView("formulario");
        
        modelAndView.addObject("dados_carro", carro);
        return  modelAndView;
        
        
    }
    
    @PostMapping(value="/cadastro")
    public String postCadastro(Carro carroNovo){

        //gravanod no banco 
        carroRepository.save(carroNovo);

        return "redirect:/";
    }
    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {
        Carro carro = carroRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("detalhes");
        modelAndView.addObject("dados_carro", carro);

        return modelAndView;
    }

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id ) {
        carroRepository.deleteById(id);
        
        return "redirect:/";
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        //ler registro do banco
        Carro carro = carroRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("formulario");

        modelAndView.addObject("dados_carro", carro);
        
        return modelAndView;
    }
    
    
    

}


