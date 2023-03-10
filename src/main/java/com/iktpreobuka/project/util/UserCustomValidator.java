package com.iktpreobuka.project.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.project.entities.dto.KorisnikDTO;

@Component
public class UserCustomValidator implements Validator {

	@Override
	public boolean supports(Class<?> myClass) {
		return KorisnikDTO.class.equals(myClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		KorisnikDTO user = (KorisnikDTO) target;

		if (!user.getSifra().equals(user.getConfirmedPassword())) {
			errors.reject("400", "Passwords must be the same");
		}

	}

}

