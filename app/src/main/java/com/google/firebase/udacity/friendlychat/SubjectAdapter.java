package com.google.firebase.udacity.friendlychat;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.google.firebase.udacity.friendlychat.R.id.messageTextView;

/**
 * Created by Toshiba on 11/30/2017.
 */

public class SubjectAdapter extends ArrayAdapter<Subject> {

    private int mColorResourceId;

    public SubjectAdapter(Activity context, ArrayList<Subject> subjects, int backgroundColor) {

        super(context, 0, subjects);
        mColorResourceId = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_subject, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Subject currentSubject = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView subjectTextView = (TextView) listItemView.findViewById(R.id.subject_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        subjectTextView.setText(currentSubject.getName());
//
//
        return listItemView;
    }


}