package com.eicon.validation.constraint;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.eicon.project.model.entity.Produto;

public class MaxSizeConstraintValidator implements ConstraintValidator<MaxSizeConstraint, List<Produto> > {

	
	@Override
	  public void initialize(MaxSizeConstraint constraintAnnotation) {
	    ConstraintValidator.super.initialize(constraintAnnotation);
	  }

	@Override
	public boolean isValid(List<Produto> value, ConstraintValidatorContext context) {
		return value.size() <= 10;
	}

}
