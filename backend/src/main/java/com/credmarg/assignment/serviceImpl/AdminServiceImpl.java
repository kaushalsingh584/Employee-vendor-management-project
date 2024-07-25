package com.credmarg.assignment.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import com.credmarg.assignment.IO.AdminIO;
import com.credmarg.assignment.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	private Map<String, AdminIO> adminDetailsMap = new HashMap<>();

	@Override
	public AdminIO saveAdmin(AdminIO admin) {
		UserDetails user = User.withUsername(admin.getEmail()).password("{noop}"+admin.getPassword())
				.authorities("ADMIN").build();
		inMemoryUserDetailsManager.createUser(user);
		adminDetailsMap.put(admin.getEmail(), admin);
		return admin;
	}

	@Override
	public UserDetails getAllAdmins() {
//		List<AdminIO> adminList = new ArrayList<>();
//		 for(Entry<String, AdminIO> entry: adminDetailsMap.entrySet()) {
//			 adminList.add(entry.getValue());
//		    }
//		 return adminList;
		return inMemoryUserDetailsManager.loadUserByUsername("ks@gmail.com");
      
		
	}

	@Override
	public AdminIO getAdminbyUsername(String username) {
		// TODO Auto-generated method stub
		return adminDetailsMap.getOrDefault(username, null);
	}

}
