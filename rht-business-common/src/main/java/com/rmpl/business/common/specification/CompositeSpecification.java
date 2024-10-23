package com.rmpl.business.common.specification;

/**
 * CompositeSpecification
 *
 * @author muxh
 */
public abstract class CompositeSpecification<T> implements ISpecification<T> {

    @Override
    public ISpecification and(ISpecification specification) {
        return new AndSpecification<>(this, specification);
    }

    @Override
    public ISpecification or(ISpecification specification) {
        return new OrSpecification<>(this, specification);
    }

    @Override
    public ISpecification not(ISpecification specification) {
        return new NotSpecification<>(this, specification);
    }

}
