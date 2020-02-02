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
* Profile.java is distributed in the hope that it will be useful,
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


public class Profile {

	/* Here are Set and Get for user profile creation */ 
	
	private int id;
	public int getID() {
		return id;
	}
	
	public void setID(int newID) {
		id = newID;
	}
	
	 private String name;
	 
	      public String getName() {
     return name; 
	}
	 
   public void setName(String newName) {
	   name = newName;  
	   
	   
   }
   
   private String email;
	 
	    public String getEmail() {
   return email; 
	}
	 
 public void setEmail(String newEmail) {
	   email = newEmail;  
	   
	   
 }
   
 private String password;
 
       public String getPassword() {
 return password; 
}
 
public void setPassword(String newPassword) {
 password = newPassword;  
     
}

private Boolean agree;

public Boolean getAgree() {
return agree; 
}

public void setAgree(Boolean newAgree) {
agree = newAgree;  
    
}

private int year;

public int getYear() {
return year; 
}

public void setYear(int newYear) {
year = newYear;  
    
}

private String description;

public String getDescription() {
return description; 
}

public void setDescription(String newDescription) {
description = newDescription;  

}

private String gps; 

public String getGps() {
return gps; 
}

public void setGps(String newGps) {
gps = newGps;  

}

}
