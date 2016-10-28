package murex.pop.cards.activity;

import static android.view.View.inflate;
import static murex.pop.cards.Constants.MEETING_INDEX;
import static murex.pop.cards.Constants.meetings;
import static murex.pop.cards.activity.SingleChoiceListView.getListView;

import java.util.List;

import murex.pop.cards.R;
import murex.pop.cards.entity.CardGroup;
import murex.pop.cards.entity.Choice;
import murex.pop.cards.entity.Meeting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MeetingCardsGroups extends Activity {

   private Choice[] selectedChoices;
   static final String PICKED_CARDS = "PICKED_CARDS";

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.meeting_cards_group);

      final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.meetingsLinearLayout);

      final Meeting selectedMeeting = meetings[getIntent().getIntExtra(MEETING_INDEX, -1)];

      selectedChoices = new Choice[selectedMeeting.cardGroups().size()];

      createCardGroups(linearLayout, selectedMeeting);
      inflate(this, R.layout.vote_button, linearLayout);

   }

   private void createCardGroups(LinearLayout linearLayout, Meeting selectedMeeting) {
      List<CardGroup> cardGroups = selectedMeeting.cardGroups();
      for (int i = 0; i < cardGroups.size(); i++) {
         linearLayout.addView(createCardGroup(cardGroups.get(i), i, selectedChoices));
      }
   }

   private ListView createCardGroup(final CardGroup cardGroup, final int cardGroupIndex, Choice[] selectedChoices) {
      return getListView(cardGroup, cardGroupIndex, this, selectedChoices);
   }

   public void vote(View view) {
      Intent intent = new Intent(this, CardsDisplay.class);

      Bundle bundle = new Bundle();
      bundle.putSerializable(PICKED_CARDS,  selectedChoices);
      intent.putExtras(bundle);

      startActivity(intent);
   }
}