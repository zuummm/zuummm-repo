package org.ave.pet.calculation;

public class NetCalculator {

    private Calculator calcMethod;
    private Position position;

    public void setCalcMethod(Calculator calcMethod) {
        this.calcMethod = calcMethod;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double calc() {
        if (calcMethod == null) {
            throw new RuntimeException("Missing calculation method");
        }
        if (position == null) {
            throw new RuntimeException("Position unknowm");
        }
        return calcMethod.calc(position);
    }
}
