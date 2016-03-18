package murex.pop.cards.activity;

import static android.graphics.Color.parseColor;
import static android.view.View.inflate;

import murex.pop.cards.R;
import murex.pop.cards.entity.CardGroup;
import murex.pop.cards.entity.Choice;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

public class SingleChoiceListView {

   static ListView getListView(final CardGroup cardGroup, final int cardGroupIndex, final Context context, final String[] selectedLabels) {

      final ListView list = new ListView(context);
      list.setPadding(0, 10, 0, 0);
      list.setBackgroundColor(Color.BLACK);

      final View cardGroupHeader = inflate(context, R.layout.card_group_header, null);
      list.addHeaderView(cardGroupHeader);

      ((TextView) cardGroupHeader.findViewById(R.id.cardGroupHeaderText)).setText(cardGroup.name());

      list.setAdapter(new ArrayAdapter<Choice>(context, android.R.layout.simple_list_item_single_choice, cardGroup.entries()) {
         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            final Choice choice = cardGroup.entries().get(position);

            TextView text = (TextView) view.findViewById(android.R.id.text1);
            text.setBackgroundColor(parseColor(choice.color()));
            text.setText(choice.value());
            return view;
         }

      });

      list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         CheckedTextView previouslySelectedItem = null;

         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
               return;
            }
            if (previouslySelectedItem != null) {
               previouslySelectedItem.setChecked(false);
            }
            CheckedTextView text = (CheckedTextView) view.findViewById(android.R.id.text1);
            text.setChecked(true);
            selectedLabels[cardGroupIndex] = parent.getItemAtPosition(position).toString();
            previouslySelectedItem = text;
         }
      });
      return list;
   }
}
