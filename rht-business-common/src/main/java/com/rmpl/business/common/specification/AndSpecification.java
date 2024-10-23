package com.rmpl.business.common.specification;

/**
 * AndSpecification
 *
 * @author muxh
 */
public class AndSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> leftSpecification;
    private ISpecification<T> rightSpecification;

    public AndSpecification(ISpecification<T> leftSpecification, ISpecification<T> rightSpecification) {
        this.leftSpecification = leftSpecification;
        this.rightSpecification = rightSpecification;
    }

    @Override
    public boolean isSatisfied(T candidate) {
        return leftSpecification.isSatisfied(candidate) && rightSpecification.isSatisfied(candidate);
    }
}
