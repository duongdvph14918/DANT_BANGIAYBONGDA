
package com.men.secutity.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.men.entity.Accounts;
import com.men.service.AccountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountService accountService;
    @Autowired 
    HttpSession session;
    

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts user = accountService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
        UserDetailsImpl detailsImpl = UserDetailsImpl.build(user);
        System.out.println(detailsImpl.getAuthorities());
        session.setAttribute("User", detailsImpl);
        session.setAttribute("nameAcount", username);
        return detailsImpl;
    }
    
	/*
	 * public static UserDetailsImpl getUser() { UserDetailsImpl userDetailsImpl =
	 * null;
	 * if(SecurityContextHolder.getContext().getAuthentication().getPrincipal()
	 * instanceof UserDetailsImpl) { userDetailsImpl = (UserDetailsImpl)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); }
	 * return userDetailsImpl; }
	 */
}