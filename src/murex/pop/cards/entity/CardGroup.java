package murex.pop.cards.entity;

import java.util.ArrayList;
import java.util.List;

public class CardGroup {
   private String name;

   public List<Choice> entries() {
      return entries;
   }

   private List<Choice> entries;

   public CardGroup(String name) {
      this.name = name;
      entries = new ArrayList<>();
   }

   public void addEntry(String value, String color){
      entries.add(new Choice(value, color));
   }

   public String name() {
      return name;
   }

}
