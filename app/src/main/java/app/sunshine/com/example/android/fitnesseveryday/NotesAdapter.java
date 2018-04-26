package app.sunshine.com.example.android.fitnesseveryday;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ahmed Hassan on 7/18/2017.
 */

public class NotesAdapter extends ArrayAdapter<Note> {
    public NotesAdapter(Context context, int resource, List<Note> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.list_item, parent, false);
        }


        TextView Title = (TextView) convertView.findViewById(R.id.Title);
        TextView Step = (TextView) convertView.findViewById(R.id.Step);

        Note note = getItem(position);
        Title.setText(note.getTitle());
        Step.setText(note.getStep());

        return convertView;
    }
}
