package gersgarage.cct.ie.gersgarage;

/* 
* Ger 's Garage APP is a freeware open source solution for booking and to buy products.
*
* Ger 's Garage APP is an application developed using Cordova(Phonegap) which communicates with an external API.
*
* This program was developed using PhoneGAp platform on its servers and it was
* developed with Spring Boot where its APIs are located.
*
* Copyright(C) 2019 Fernando Francisco Azevedo
*
* Licensing information
*
* This file is part of The of free and open - source software Ger 's Garage APP:
* you can redistribute it and / or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or(at your option) any later version.
*
* WebConfig.java is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY;
* without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
* GNU General Public License
* for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.
* See https: //www.gnu.org/licenses/ .
*
*    I am here to help
* Contatct me: Fernando.tech @icloud.com
*/

/*
 * 
 *  
 *  @author Fernando Francisco Azevedo 2019061 */


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/* register configuration for using method POST */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("POST");
	}

}
