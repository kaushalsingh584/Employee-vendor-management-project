package com.credmarg.assignment.IO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseIO {
	
	private boolean authenticated;
	private String authority;

}
