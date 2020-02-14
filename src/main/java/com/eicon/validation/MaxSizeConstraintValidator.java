package com.eicon.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.eicon.project.model.Produto;

public class MaxSizeConstraintValidator implements ConstraintValidator<MaxSizeConstraint, List<Produto> > {

	@Override
	public boolean isValid(List<Produto> value, ConstraintValidatorContext context) {
		return value.size() <= 10;
	}

}
