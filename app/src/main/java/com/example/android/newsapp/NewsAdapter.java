package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = NewsAdapter.class.getName();

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNewsArticle = getItem(position);

        String currentSection = currentNewsArticle.getSection();
        TextView sectionTextView = (TextView) convertView.findViewById(R.id.section);
        sectionTextView.setText(currentSection);

        String currentTitle = currentNewsArticle.getTitle();
        TextView titleTextView = (TextView) convertView.findViewById(R.id.title);
        titleTextView.setText(currentTitle);

        String currentAuthor = currentNewsArticle.getAuthor();
        TextView authorTextView = (TextView) convertView.findViewById(R.id.author);

        //hide the author TextView if there is no author to display
        if (currentAuthor.isEmpty()){
            authorTextView.setVisibility(View.GONE);
        } else {
            authorTextView.setText(currentAuthor);
        }

        String currentDate = formatDate(currentNewsArticle.getDate());
        TextView dateTextView = (TextView) convertView.findViewById(R.id.date);
        dateTextView.setText(currentDate);

        String currentTime = formatTime(currentNewsArticle.getDate());
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);
        timeTextView.setText(currentTime);

        return convertView;
    }

    /* Return the formatted date string (i.e. "Mar 3, 1984") from a string.
     */
    private String formatDate(String webPublicationDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss'Z'");

        try {
            Date date = dateFormat.parse(webPublicationDate);
            dateFormat.applyPattern("LLL dd, yyyy");
            return dateFormat.format(date);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Problem parsing date", e);
            return null;
        }
    }

    /* Return the formatted time string (i.e. "10:30 AM") from a string.
     */
    private String formatTime(String webPublicationDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss'Z'");

        try {
            Date time = dateFormat.parse(webPublicationDate);
            dateFormat.applyPattern("h:mm a");
            return dateFormat.format(time);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Problem parsing time", e);
            return null;
        }
    }
}
