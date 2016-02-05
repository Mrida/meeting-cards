package murex.pop.cards.entity;

import java.util.ArrayList;
import java.util.List;

public class CardGroup {
   private String name;

   private List<String> entries;

   public CardGroup(String name) {
      this.name = name;
      entries = new ArrayList<>();
   }

   public void addEntry(String image){
      entries.add(image);
   }

   public String name() {
      return name;
   }

   public List<String> entries() {
      return entries;
   }
}
