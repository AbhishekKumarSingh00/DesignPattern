package decoratorDesignPattern.decorator;

import decoratorDesignPattern.BasePizza;

public class Mushroom extends ToppingsDecorator{

    BasePizza basePizza;

    public Mushroom(BasePizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 20;
    }
}
