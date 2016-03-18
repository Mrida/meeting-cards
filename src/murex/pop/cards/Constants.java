package murex.pop.cards;

import murex.pop.cards.entity.CardGroup;
import murex.pop.cards.entity.Meeting;

public final class Constants {
   public static final String MEETING_INDEX = "MEETING_INDEX";
   public static final Meeting[] meetings = meetingsMap();

   private static Meeting[] meetingsMap() {
      Meeting[] meetings = new Meeting[5];
      for (int i = 0; i < meetings.length; i++) {
         final String meetingName = "Meeting" + i;
         meetings[i] = new Meeting(meetingName);
         final String group1Desc = "Group1 - " + meetingName;
         final String group2Desc = "Group2 - " + meetingName;
         final CardGroup group1 = new CardGroup(group1Desc);
         final CardGroup group2 = new CardGroup(group2Desc);

         group1.addEntry("SAD - " + group1Desc, "red");
         group1.addEntry("MAD - " + group1Desc, "yellow");
         group1.addEntry("GLAD - " + group1Desc, "green");

         group2.addEntry("1 - " + group2Desc, "red");
         group2.addEntry("2 - " + group2Desc, "yellow");
         group2.addEntry("3 - " + group2Desc, "green");

         meetings[i].addCardGroup(group1);
         meetings[i].addCardGroup(group2);
      }
      return meetings;
   }

}
