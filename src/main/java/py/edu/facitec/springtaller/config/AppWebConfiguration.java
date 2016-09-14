package py.edu.facitec.springtaller.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import py.edu.facitec.springtaller.controller.HomeController;
import py.edu.facitec.springtaller.dao.ClienteDAO;

//acativa el componente Mvc de Spring para trabajar con Servlet
@EnableWebMvc

//Carga las clases necesarias para iniciar la aplicacion
@ComponentScan(basePackageClasses={HomeController.class, ClienteDAO.class})

//Gestiona un nuevo componente de la aplicacion
public class AppWebConfiguration extends WebMvcConfigurerAdapter{
	
	
	//Gestiona como un nuevo de la aplicacion
	@Bean
	public InternalResourceViewResolver  internalResourceViewResolver(){
		
	
			InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	
	
	resolver.setPrefix("/WEB-INF/views/");
	
	resolver.setSuffix(".jsp");
	
	
	
	return resolver;
	
	}
	

	
}
