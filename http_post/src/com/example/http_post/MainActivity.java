package com.example.http_post;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView post_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		post_text = (TextView) findViewById(R.id.post_text);

		post_text.setOnClickListener(post_click);

	}

	// TextView.OnClickListener startTextOnClickListener = new
	// post_text.OnClickListener

	TextView.OnClickListener post_click = new TextView.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			// Create Http Client
			HttpClient httpClient = new DefaultHttpClient();

			// Create HTTP Post
			HttpPost httpPost = new HttpPost("http://www.google.com");

			List<NameValuePair> namePairValue = new ArrayList<NameValuePair>(2);
			namePairValue.add(new BasicNameValuePair("email",
					"dharmikisback@gmail.com"));
			namePairValue.add(new BasicNameValuePair("password", "******"));

			// Url Encoding the POST parameters

			try {
				httpPost.setEntity((HttpEntity) new UrlEncodedFormEntity(
						namePairValue));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Making HTTP Request
			try {
				HttpResponse response = httpClient.execute(httpPost);

				// writing response to log
				Log.d("Http Response:", response.toString());
			} catch (ClientProtocolException e) {
				// writing exception to log
				e.printStackTrace();
			} catch (IOException e) {
				// writing exception to log
				e.printStackTrace();

			}

		}

	};

}
