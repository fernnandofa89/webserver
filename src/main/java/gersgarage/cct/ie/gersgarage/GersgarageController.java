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
* GersgarageController.java is distributed in the hope that it will be useful,
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

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class GersgarageController {
    
	private static ArrayList<Profile> profileList = new ArrayList<Profile>(); 
	 /* API login */
	/* Checking login information */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseID login(@RequestParam String email, @RequestParam String password){
    	if (email == null || email.length() == 0) { /* check if the field is correct */
    		throw new ValidationException("invalid email"); 
    	}

    	if (password == null || password.length() == 0) { /*  check if the field is correct, */
    		throw new ValidationException("invalid password"); 
    	}
    	/* Finding the information verifies that they are correct (email && Password)*/
    	Profile found = null;
    	for (int i = 0; i < profileList.size(); i++) {
    		Profile p = profileList.get(i);
    		if (p.getEmail().equals(email) && p.getPassword().equals(password)) {
    			found = p;
    		}
    	}
    	
    	if (found == null) {
    		throw new ValidationException("invalid credentials");
    	}
    	
        return new ResponseID(found.getID());
    }
	
	/* API Register */
	/* to verify that all fields are filled in correctly. */
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@RequestBody Profile p){
    	if (p.getName() == null || p.getName().length() == 0) {
    		throw new ValidationException("invalid name"); 
    	}
    	
    	if (p.getEmail() == null || p.getEmail().length() == 0) {
    		throw new ValidationException("invalid email"); 
    	}
    	
    	if (p.getPassword() == null || p.getPassword().length() == 0) {
    		throw new ValidationException("invalid password"); 
    	}
    	
    	if (p.getAgree() == null) {
    		throw new ValidationException("invalid agree"); 
    	}
    	
    	if (p.getYear() <= 0) {
    		throw new ValidationException("invalid year"); 
    	}
    	
    	if (p.getDescription() == null || p.getDescription().length() == 0) {
    		throw new ValidationException("invalid description"); 
    	}
    	
    	if (p.getGps() == null || p.getGps().length() == 0) {
    		throw new ValidationException("invalid GPS"); 
    	}
    	/* creating user id */ 
    	p.setID(profileList.size() + 1);
    	/* return when all fields have been filled in correctly and a new user in memory is added. */
    	profileList.add(p);
        return "OK";
    }
    
    /* API  */
    /* Creating as user id */ 
    @RequestMapping("/database")
    public ArrayList<Profile> match(@RequestParam int userId){
    	Profile user = null;
    	for (int i = 0; i < profileList.size(); i++) {
    		Profile p = profileList.get(i);
    		if (p.getID() == userId) {
    			user = p;
    		}
    	}
    	
    	if (user == null) {
    		throw new ValidationException("invalid userId");
    	}
    	
    	ArrayList<Profile> matched = new ArrayList<Profile>();
    	for (int i = 0; i < profileList.size(); i++) {
    		Profile p = profileList.get(i);
    		
    		/* year  */
    		
    		int yearDiff = user.getYear() - p.getYear();
    		if (yearDiff < 0) {
    			yearDiff = yearDiff * -1;
    		}
    		
    		if (p.getID() != user.getID() &&
    				/* yer 10 */
					p.getAgree() == user.getAgree() &&  
					yearDiff <= 2022) {
    			matched.add(p);
    		}
    	}
    	
    	return matched;
    }
}