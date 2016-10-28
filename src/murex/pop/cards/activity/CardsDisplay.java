package murex.pop.cards.activity;

import static murex.pop.cards.activity.MeetingCardsGroups.PICKED_CARDS;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CardsDisplay extends ListActivity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final String[] cards = getIntent().getStringArrayExtra(PICKED_CARDS);

      setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cards){

         int cardHeight = getWindowManager().getDefaultDisplay().getHeight() / cards.length;
         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
            Toast.makeText(CardsDisplay.this,String.valueOf(CardsDisplay.this.getWindow().getDecorView().getPaddingTop()),Toast.LENGTH_SHORT).show();

            View view = super.getView(position, convertView, parent);
            TextView textView = ((TextView) view.findViewById(android.R.id.text1));
            textView.setHeight(cardHeight);
            return view;
         }
      });
   }


}