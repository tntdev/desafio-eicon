package com.eicon.validation.constraint;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.eicon.project.model.entity.Produto;

public class MinSizeConstraintValidator implements ConstraintValidator<MinSizeConstraint, List<Produto> > {

	
	@Override
	  public void initialize(MinSizeConstraint constraintAnnotation) {
	    ConstraintValidator.super.initialize(constraintAnnotation);
	  }

	@Override
	public boolean isValid(List<Produto> value, ConstraintValidatorContext context) {
		return value != null &&  !value.isEmpty();
	}

}
