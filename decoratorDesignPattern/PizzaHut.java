package decoratorDesignPattern;

import decoratorDesignPattern.decorator.ExtraCheese;
import decoratorDesignPattern.decorator.Mushroom;

/*
* Adding feature on Base Pizza
*
 */

public class PizzaHut {

    public static void main(String args[]) {
        // 10 + 100
        BasePizza margheritaWithExtraCheese = new ExtraCheese(new Margherita());
        System.out.println("Margherita With ExtraCheese Price : " + margheritaWithExtraCheese.cost());

        // 20 + 10 + 100
//        BasePizza margheritaWithExtraCheeseAndExtraMushroom = new Mushroom(new ExtraCheese(new Margherita()));
        //or
        BasePizza margheritaWithExtraCheeseAndExtraMushroom = new Mushroom(margheritaWithExtraCheese);
        System.out.println("Margherita With ExtraCheese Price And Extra Mushroom : " + margheritaWithExtraCheeseAndExtraMushroom.cost());

    }

}
