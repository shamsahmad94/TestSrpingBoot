package com.example.demo.config;
//package us.fetchr.api.user.config;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//@Configuration
//@EnableWebSecurity
//public class AuthTokenResponse extends WebSecurityConfigurerAdapter{
//
////	@Autowired
////	private HttpServletRequest request;
//	
//	private String AuthinticationToken = ConfigManager.AUTH_TOKEN;
//	
////	public ResponseEntity<?> AuthResponse(HttpServletRequest request)
////	{
////
//////		ResponseEntity.BodyBuilder Response;
////		
////		if(request.getHeader("Authorization").toString().equals(AuthinticationToken))
////		{
////			return   ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
////		}
////		else
////		{
////			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
////		}
////	}
////	
//	
//	  @Override
//	  public void configure(HttpSecurity http) throws Exception {
////			AuthTokenResponse auth = new AuthTokenResponse();
////			System.out.println("sss");
////			if(auth.AuthResponse(request).toString().equals("201"))
////			{
////	      http.
////	      			authorizeRequests().
//////	      			antMatchers("/**").permitAll().  // whitelist Swagger UI resources
////	      			// ... here goes your custom security configuration
////	      			antMatchers("/**").authenticated();
//////	              .requestMatchers().antMatchers("/v1/*").and()
//////	              authorizeRequests().anyRequest().hasAnyAuthority("dd");
////	      super.configure(http);
////			}
////			else
////			{
////				 http.
////				 authorizeRequests().
////	   			antMatchers("/**").denyAll();
////				 
////				 super.configure(http);
////			}
//			
//			 http.
//			 authorizeRequests().
//				antMatchers("/**").denyAll();
//			 super.configure(http);
//				
//	  }
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		auth
////			.inMemoryAuthentication()
////				.withUser("user").password("password").roles("USER");
////	}
//}
