package murex.pop.cards.entity;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
   private String name;
   private List<CardGroup> groups;

   public Meeting(String name) {
      this.name = name;
      groups = new ArrayList<>();
   }

   public void addCardGroup(CardGroup group){
      groups.add(group);
   }

   public String name() {
      return name;
   }

   public List<CardGroup> cardGroups() {
      return groups;
   }

   @Override
   public String toString() {
      return name;
   }
}
