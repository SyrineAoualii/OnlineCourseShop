package com.Aouali.OnlineCourseShopmicroservice3.payload.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String refreshToken;
	private Long id;
	private String username;
	private String email;
	private LocalDateTime createTime;
	private List<String> roles;


	public JwtResponse(String accessToken, String refreshToken, Long id, String username, String email,	LocalDateTime createTime, List<String> roles) {
		this.token = accessToken;
		this.refreshToken = refreshToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.createTime=createTime;
		this.roles = roles;

	}


}
