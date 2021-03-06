package com.github.kimchidev.pagination.calculator;

import com.github.kimchidev.pagination.constant.PaginatorConstant;
import com.github.kimchidev.pagination.constant.PagingOption;
import com.github.kimchidev.pagination.object.PaginatedObject;
import com.github.kimchidev.pagination.object.PaginationObject;

import java.util.Map;

public class CalculatorProxy implements Calculator {

    private Calculator calculator;

    public CalculatorProxy(PaginatorConstant constant) throws Exception {
        this.calculator = AppropriateCalculatorProvider.getInstance().provide(constant);
    }

    @Override
    public void setting(PaginationObject object, boolean goPre, boolean goNext) {
        this.calculator.setting(object, goPre, goNext);
    }

    @Override
    public void moveNext(boolean goNext) {
        this.calculator.moveNext(goNext);
    }

    @Override
    public void movePre(boolean goPre) {
        this.calculator.movePre(goPre);
    }

    @Override
    public void calculate(PaginationObject object) throws Exception {
        this.calculator.calculate(object);

    }

    @Override
    public void applyOption(PagingOption option) throws Exception {
        this.calculator.applyOption(option);
    }

    @Override
    public PaginatedObject getResult() {
        return this.calculator.getResult();
    }

    @Override
    public Map<String, Integer> getCalculatedData() {
        return this.calculator.getCalculatedData();
    }
}
