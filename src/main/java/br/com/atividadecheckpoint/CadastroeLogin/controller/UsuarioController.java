package br.com.atividadecheckpoint.CadastroeLogin.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.atividadecheckpoint.CadastroeLogin.dto.UsuarioDto;
import br.com.atividadecheckpoint.CadastroeLogin.model.Usuario;
import br.com.atividadecheckpoint.CadastroeLogin.repositories.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/cadastro")
	public ModelAndView cadastro(UsuarioDto usuario){
		return new ModelAndView("cadastro");
	}
	
	@GetMapping("/login")
	public ModelAndView login(UsuarioDto usuario){
		return new ModelAndView("login");
		
	}
	
	@PostMapping("cadastro")
	public ModelAndView cadastrar(@Valid UsuarioDto usuario, BindingResult bindigResult) {
		
		if(bindigResult.hasErrors()) {
			System.out.println("TEMOS ERROS");
			return new ModelAndView("cadastro");
		}
		
		Usuario usuarioEntity = modelMapper.map(usuario, Usuario.class); 
		usuarioRepository.save(usuarioEntity);
		
		return new ModelAndView ("login");
	}
	
	@PostMapping("login")
	public ModelAndView logar( UsuarioDto usuario) {
		
		Usuario usuarioEntity = modelMapper.map(usuario, Usuario.class); 
		List<Usuario> usuarioLista = usuarioRepository.findAll();
		
		for (Usuario usuarioI : usuarioLista) {
			if(usuarioI.getNomeUsuario().equals(usuario.getnomeUsuario()) && usuarioI.getSenha().equals(usuario.getSenha())) {
				return new ModelAndView("home");
			}
		}

		
		
		return new ModelAndView ("redirect:/login");
	}
	
	
}
