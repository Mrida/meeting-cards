package murex.pop.cards.entity;

import java.io.Serializable;

public class Choice implements Serializable {
   private String choiceValue;
   private String color;

   public Choice(String choiceValue, String color) {
      this.choiceValue = choiceValue;
      this.color = color;
   }

   public String value() {
      return choiceValue;
   }

   public String color() {
      return color;
   }
}
