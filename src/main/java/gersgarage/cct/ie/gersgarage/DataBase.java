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
* DataBase.java is distributed in the hope that it will be useful,
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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//localhost : local computer acts as a server
//1433 : SQL default port number
//username : dataBase

//password: use password, which is used at the time of installing SQL server management studio, In my case, it is 'root'

    public class DataBase {
        public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

            Connection conn=null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Gersgarage", "dataBase", "root");

                if(conn!=null)
                    System.out.println("Database Successfully connected");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }