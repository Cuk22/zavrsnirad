package com.iktpreobuka.project.config;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends OncePerRequestFilter{
	
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private SecretKey secretKey;
	
	public JWTAuthorizationFilter(SecretKey secretkey) {
		super();
		this.secretKey = secretkey;
	}
	
	private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX)) {
			return false;
		}
		return true;
	}

	private Claims validateToken(HttpServletRequest requst) {
		String jwtToken = requst.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwtToken).getBody();
	}
	
	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List<String>) claims.get("authorities");
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null, 
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
				SecurityContextHolder.getContext().setAuthentication(auth);
	}
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
			try {
				if (checkJWTToken(request, response)) {
					Claims claims = validateToken(request);
					if (claims.get("authorities") != null) {
								setUpSpringAuthentication(claims);
					} else {
						SecurityContextHolder.clearContext();
					}
				} else {
				SecurityContextHolder.clearContext();
				}
				chain.doFilter(request, response);
			} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
				return;
			}
		
	}

}
