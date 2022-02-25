package com.codingdojo.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorConta {
	
	@RequestMapping(value="/tu_servidor", method=RequestMethod.GET)
	public String Inicio(HttpSession session) {
		int contador=0;
		session.setAttribute("contador",contador);
		return "index.jsp";
	}
	
	@RequestMapping(value="/tu_servidor/counter", method=RequestMethod.GET)
	public String ContadorInicio(HttpSession session,Model model) {
		if (session.getAttribute("contador")==null) {
			Integer count= 0;
			model.addAttribute("VistaCount",count);
			return "count.jsp";
		}
		else {
			Integer count= (Integer) session.getAttribute("contador");
			count++;
			session.setAttribute("contador", count);
			//System.out.println(session.getAttribute("contador") + "Sesion Incrementa");
			model.addAttribute("VistaCount",count);
			return "count.jsp";
		}
	}
	
}
