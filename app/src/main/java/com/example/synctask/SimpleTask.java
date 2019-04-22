package com.example.synctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class SimpleTask extends AsyncTask<Void, Void, String> {
    // The TextView where we will show results
    private TextView mTextView;
    private static final String TAG = "SimpleAsyncTask";

    // Constructor that provides a reference to the TextView from the MainActivity
    public SimpleTask(TextView tv) {
        mTextView = tv;
    }

    /**
     * Runs on the background thread.
     *
     * @param voids No parameters in this use case.
     * @return Returns the string including the amount of time that
     * the background thread slept.
     */
    @Override
    protected String doInBackground(Void... voids) {

        // Generate a random number between 0 and 10
        Random r = new Random();
        int s = 10000;
        String status="";

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        //int s = n * 200;

        // Sleep for the random amount of time
        try
        { for (int i=0; i<=5; i++)
        { Log.d(TAG,"statement "+i); Thread.sleep(1000); }
        Thread.sleep(s); status = "Finished"; }
        catch (InterruptedException e) { e.printStackTrace(); }
        return status;
}



    /**
     * Does something with the result on the UI thread; in this case
     * updates the TextView.
     */
    protected void onPostExecute(String result) {
        mTextView.setText(result);
    }
}
