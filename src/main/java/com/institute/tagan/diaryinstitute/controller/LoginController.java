package com.institute.tagan.diaryinstitute.controller;

import com.institute.tagan.diaryinstitute.config.MySimpleUrlAuthenticationSuccessHandler;
import com.institute.tagan.diaryinstitute.model.Role;
import com.institute.tagan.diaryinstitute.model.User;
import com.institute.tagan.diaryinstitute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


 @GetMapping("/login")
 public String login(@AuthenticationPrincipal UserDetails currentUser){


        if(currentUser!=null) {
            Collection<? extends GrantedAuthority> authorities
                    = currentUser.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                    return "redirect:/teacher";

                } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                    return "redirect:/admin";
                }

            }

        }
    // User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    // for (Role r : user.getRoles()){
      //   if(r.getName().equals("ROLE_ADMIN")) {
     //        hasUserRole=true;
      //   }
   //  }
     return "login";
 }
    @PostMapping("/login")
    public String teacher(Model model, @AuthenticationPrincipal UserDetails currentUser) {

       // User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      //  for (Role r : user.getRoles()){
      //      if(r.getName().equals("ROLE_ADMIN")) {
       //         hasUserRole=true;
       //     }
      //  }


         // var roles = currentUser.getAuthorities();
         // for(var role : roles){
         //     if(role.toString()=="ROLE_ADMIN"){
          //        return "redirect:/admin";
          //    }

       //   }
        //User user = (User) userService.loadUserByUsername(name);
        //model.addAttribute("currentTeacher", currentUser);
       // return "teacher";
     //   if(hasUserRole) return "redirect:/admin";
    // else

       //  return "redirect:/teacher";
   return "";
    }
}