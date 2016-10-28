package murex.pop.cards.activity;

import static android.graphics.Color.parseColor;
import static murex.pop.cards.activity.MeetingCardsGroups.PICKED_CARDS;

import java.util.Arrays;

import murex.pop.cards.entity.Choice;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CardsDisplay extends ListActivity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      Object[] serializable = (Object[]) getIntent().getExtras().getSerializable(PICKED_CARDS);
      final Choice[] choices = Arrays.copyOf(serializable, serializable.length, Choice[].class);

      setListAdapter(new ArrayAdapter<Choice>(this, android.R.layout.simple_list_item_1, choices) {

         int cardHeight = getWindowManager().getDefaultDisplay().getHeight() / choices.length;

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            view.setBackgroundColor(parseColor(choices[position].color()));
            TextView textView = ((TextView) view.findViewById(android.R.id.text1));
            textView.setHeight(cardHeight);
            textView.setText(choices[position].value());
            textView.setGravity(Gravity.CENTER);
            return view;
         }
      });
   }

}