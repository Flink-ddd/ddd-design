package com.rmpl.business.common.specification;

/**
 * OrSpecification
 *
 * @author muxh
 */
public class OrSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> leftSpecification;
    private ISpecification<T> rightSpecification;

    public OrSpecification(ISpecification<T> leftSpecification, ISpecification<T> rightSpecification) {
        this.leftSpecification = leftSpecification;
        this.rightSpecification = rightSpecification;
    }

    @Override
    public boolean isSatisfied(T candidate) {
        return leftSpecification.isSatisfied(candidate) || rightSpecification.isSatisfied(candidate);
    }
}
