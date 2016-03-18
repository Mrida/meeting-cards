package murex.pop.cards.activity;

import static android.graphics.Color.parseColor;
import static murex.pop.cards.Constants.MEETING_INDEX;
import static murex.pop.cards.Constants.meetings;

import java.util.List;

import murex.pop.cards.R;
import murex.pop.cards.entity.CardGroup;
import murex.pop.cards.entity.Choice;
import murex.pop.cards.entity.Meeting;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MeetingCardsGroups extends Activity {

   private String[] selectedLabels;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.meeting_cards_group);

      final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.meetingsLinearLayout);

      final Meeting selectedMeeting = meetings[getIntent().getIntExtra(MEETING_INDEX, -1)];

      selectedLabels = new String[selectedMeeting.cardGroups().size()];

      List<CardGroup> cardGroups = selectedMeeting.cardGroups();
      for (int i = 0; i < cardGroups.size(); i++) {
         linearLayout.addView(createCardGroupsView(cardGroups.get(i), i));
      }

      linearLayout.addView(createVoteButton());
   }

   private Button createVoteButton() {
      final Button back = new Button(this);
      back.setText("VOTE");
      back.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            StringBuilder sb = new StringBuilder();
            for (String selectedLabel : selectedLabels) {
               sb.append(selectedLabel + " ");
            }

            Toast.makeText(MeetingCardsGroups.this, sb.toString(), Toast.LENGTH_SHORT).show();
         }
      });
      return back;
   }

   private ListView createCardGroupsView(final CardGroup cardGroup, final int cardGroupIndex) {
      final ListView list = new ListView(this);
      list.setPadding(0, 10, 0, 0);
      list.setBackgroundColor(Color.BLACK);

      list.addHeaderView(createCardGroupHeader(cardGroup));

      list.setAdapter(new ArrayAdapter<Choice>(this, android.R.layout.simple_list_item_1, cardGroup.entries()) {
         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            final Choice choice = cardGroup.entries().get(position);
            view.setBackgroundColor(parseColor(choice.color()));
            TextView text = (TextView) view.findViewById(android.R.id.text1);
            text.setText(choice.value());
            return view;
         }

      });

      list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         View previouslySelectedItem = null;

         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (previouslySelectedItem != null) {
               previouslySelectedItem.setBackgroundColor(Color.TRANSPARENT);
            }

            view.setBackgroundColor(Color.LTGRAY);
            selectedLabels[cardGroupIndex] = parent.getItemAtPosition(position).toString();
            previouslySelectedItem = view;
         }
      });
      return list;
   }

   private TextView createCardGroupHeader(CardGroup cardGroup) {
      final TextView listHeader = new TextView(this);
      listHeader.setClickable(false);
      listHeader.setAllCaps(true);
      listHeader.setTextSize(14f);
      listHeader.setBackgroundColor(Color.WHITE);
      listHeader.setTextColor(Color.BLACK);
      listHeader.setText(cardGroup.name());
      return listHeader;
   }
}