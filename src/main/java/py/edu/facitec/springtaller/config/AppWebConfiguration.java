package py.edu.facitec.springtaller.config;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import py.edu.facitec.springtaller.controller.HomeController;
import py.edu.facitec.springtaller.dao.ClienteDAO;
import py.edu.facitec.springtaller.model.Producto;
import py.edu.facitec.springtaller.resolver.CustomXMLViewResolver;
import py.edu.facitec.springtaller.resolver.JsonViewResolver;

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
	
	//configuracion necesaria para habilitar peticiones de recursos estaticos css, javascript etc
	@Override  
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();  
		
	} 
	
	
	//Configuracion para convertir fecha a un formato especifico
	@Bean  
	public FormattingConversionService mvcConversionService() {  
		DefaultFormattingConversionService conversionService =  new DefaultFormattingConversionService(true);
		DateFormatterRegistrar registrar =  new DateFormatterRegistrar();  
		registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));  
		registrar.registerFormatters(conversionService);  
		return conversionService;  
		}
	
	
	@Bean  
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {   
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();      
		resolvers.add(internalResourceViewResolver());   
		resolvers.add(new JsonViewResolver());   
		
		resolvers.add(getMarshallingXmlViewResolver());      
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();   
		resolver.setViewResolvers(resolvers);   
		resolver.setContentNegotiationManager(manager);   
		return resolver;  
	}  
	 
	@Bean  
	 public CustomXMLViewResolver getMarshallingXmlViewResolver() {   
		 Jaxb2Marshaller marshaller = new Jaxb2Marshaller();   
		 marshaller.setClassesToBeBound(Producto.class);   
		 return new CustomXMLViewResolver(marshaller);  
	} 


	
}
