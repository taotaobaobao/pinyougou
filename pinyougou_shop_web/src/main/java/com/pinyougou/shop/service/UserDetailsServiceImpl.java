package com.pinyougou.shop.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {
    private SellerService sellerService;

    public void setSellerService(SellerService sellerService){
        this.sellerService=sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbSeller seller = sellerService.findOne(username);

        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority("ROLE_SELLER");

        grantedAuthorities.add(authority);
        if(seller!=null){
            if(seller.getStatus().equals("1")){
                User user=new User(username,seller.getPassword(),grantedAuthorities);
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }

    }
}
