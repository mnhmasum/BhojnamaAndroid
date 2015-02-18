package com.apps.fragments;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.apps.bhojnama.R;
import com.apps.bhojnamainfo.BhojNamaSingleton;
import com.apps.datamodel.HottestInfo;
import com.apps.datamodel.hottestlist;
import com.apps.jsonparser.JsonParser;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class SubmitreviewFragment extends Fragment {
	
	
	TextView title,description,rating;
	EditText title_edit,desc_edit,rating_edit;

	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
	public static final String ITEM_NAME = "itemName";

	public SubmitreviewFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.review, container,
				false);

		title = (TextView) view.findViewById(R.id.title_text);
		description = (TextView) view.findViewById(R.id.desc_text);
		rating = (TextView) view.findViewById(R.id.rating_text);
		
		title_edit=(EditText) view.findViewById(R.id.title);
		desc_edit=(EditText) view.findViewById(R.id.description);
		rating_edit=(EditText) view.findViewById(R.id.rating);
	
		return view;
	}
	


}
