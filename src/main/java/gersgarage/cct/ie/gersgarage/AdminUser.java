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
* AdminUser.java is distributed in the hope that it will be useful,
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

package gersgarage.cct.ie.gersgarage;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.context.annotation.Role;

public class AdminUser implements UserDetails {
    private User user;
    public AdminUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        @SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>) user.getRoles();
        for( @SuppressWarnings("unused") Role role : roles ) {
            authorities.add( new SimpleGrantedAuthority());
        }
        return authorities;

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ((AdminUser) user).isEnabled();
    }
}
