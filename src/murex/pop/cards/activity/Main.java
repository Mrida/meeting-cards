package murex.pop.cards.activity;

import static murex.pop.cards.Constants.MEETING_INDEX;
import static murex.pop.cards.Constants.meetings;

import murex.pop.cards.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends ListActivity {

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, meetings));
   }

   @Override
   protected void onListItemClick(ListView l, View v, int position, long id) {
      Intent intent = new Intent(this, MeetingCardsGroups.class);
      intent.putExtra(MEETING_INDEX, position);
      startActivity(intent);
   }
}
