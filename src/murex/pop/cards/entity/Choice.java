package murex.pop.cards.entity;

public class Choice {
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
