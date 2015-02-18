package com.apps.fragments;

import java.util.ArrayList;
import java.util.List;

import com.apps.bhojnama.R;
import com.apps.bhojnama.R.drawable;
import com.apps.bhojnama.R.id;
import com.apps.bhojnama.R.layout;
import com.apps.datamodel.Userreviewlist;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class UserReviewFragment extends Fragment implements OnClickListener {
//	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
//	public static final String ITEM_NAME = "itemName";

	public UserReviewFragment() {}
	private View rootView;
	private List<Userreviewlist> myUserreview = new ArrayList<Userreviewlist>();
	private Button submit;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 rootView = inflater.inflate(R.layout.fragment_user_review, container, false);
	     submit= (Button) rootView.findViewById(R.id.button1);
	     
	     submit.setOnClickListener(this);
	     setListener();
		 populateUserreviewList();
	        populateListView();
	        return rootView;
	}

	private void populateUserreviewList() {
		
		myUserreview.add(new Userreviewlist(R.drawable.cropped_image,"Mark Dicosta", "It was an awsome experience","About:", "Boomers" ,"Rated:", R.drawable.star_active, R.drawable.star_active, 
				R.drawable.star_active, R.drawable.star_inactive, R.drawable.star_inactive));
		myUserreview.add(new Userreviewlist(R.drawable.cropped_image,"Faiza Nabita", "It was an awsome experience","About:", "Fish & Co" , "Rated:",R.drawable.star_active, R.drawable.star_active, 
				R.drawable.star_active, R.drawable.star_inactive, R.drawable.star_inactive));
		myUserreview.add(new Userreviewlist(R.drawable.cropped_image,"Xefer Rahman", "It was an awsome experience", "About:","Tarka" ,"Rated:", R.drawable.star_active, R.drawable.star_active, 
				R.drawable.star_active, R.drawable.star_inactive, R.drawable.star_inactive));
		myUserreview.add(new Userreviewlist(R.drawable.cropped_image,"Saif raihan", "It was an awsome experience","About:", "American Burger" ,"Rated:", R.drawable.star_active, R.drawable.star_active, 
				R.drawable.star_active, R.drawable.star_inactive, R.drawable.star_inactive));
		myUserreview.add(new Userreviewlist(R.drawable.cropped_image,"Dolar Hridoy", "It was an awsome experience","About:", "KFC" ,"Rated:", R.drawable.star_active, R.drawable.star_active, 
				R.drawable.star_active, R.drawable.star_inactive, R.drawable.star_inactive));
		myUserreview.add(new Userreviewlist(R.drawable.cropped_image,"Saffat Anib", "It was an awsome experience","About:", "Attin" ,"Rated:", R.drawable.star_active, R.drawable.star_active, 
				R.drawable.star_active, R.drawable.star_inactive, R.drawable.star_inactive));

		
	}

	private void populateListView() {
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), R.id.review_list); 
		ListView listview =(ListView)rootView.findViewById(R.id.review_list);
		listview.setAdapter(new MyUserreviewlistAdapter(getActivity(), myUserreview));
		
	}
	
	private class MyUserreviewlistAdapter extends ArrayAdapter<Userreviewlist>{

		public MyUserreviewlistAdapter(Activity activity, List<Userreviewlist> myUserreview){
			super(getActivity(),R.layout.row_user_review_list,myUserreview);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View itemView = convertView;
			if(itemView == null){
				itemView = getActivity().getLayoutInflater().inflate(R.layout.row_user_review_list,parent,false);
				
			}
			//find the list to work with
			Userreviewlist currentList = myUserreview.get(position);
			//fill the view
			ImageView imageview = (ImageView)itemView.findViewById(R.id.icon);
			imageview.setImageResource(currentList.getIcon());

			TextView text1= (TextView) itemView.findViewById(R.id.textView5);
			text1.setText(currentList.getName());
			
			TextView text2= (TextView) itemView.findViewById(R.id.textView3);
			text2.setText(currentList.getAbout());
			
			TextView text3= (TextView) itemView.findViewById(R.id.textView1);
			text3.setText(currentList.getRes_name());
			
			TextView text4= (TextView) itemView.findViewById(R.id.secondLine);
			text4.setText(currentList.getDesc());
			
			TextView text5= (TextView) itemView.findViewById(R.id.textView2);
			text5.setText(currentList.getRated());
			
			
			ImageView imageview1 = (ImageView)itemView.findViewById(R.id.imageView1);
			imageview1.setImageResource(currentList.getRating1());
			ImageView imageview2 = (ImageView)itemView.findViewById(R.id.ImageView02);
			imageview2.setImageResource(currentList.getRating2());
			ImageView imageview3 = (ImageView)itemView.findViewById(R.id.ImageView03);
			imageview3.setImageResource(currentList.getRating3());
			ImageView imageview4 = (ImageView)itemView.findViewById(R.id.imageView4);
			imageview4.setImageResource(currentList.getRating4());
			ImageView imageview5 = (ImageView)itemView.findViewById(R.id.ImageView01);
			imageview5.setImageResource(currentList.getRating5());
			return itemView;
			//return super.getView(position, convertView, parent);
		}
	
	}

	private void setListener() {
		submit.setOnClickListener(UserReviewFragment.this);

	}
	
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			Fragment fragment = null;
			Bundle args = new Bundle();
			args.putInt("position", getArguments().getInt("position"));
			fragment = new SubmitreviewFragment();
			fragment.setArguments(args);
			FragmentManager frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
			getActivity().setTitle("Sign Up");
			
		}
	}
	
	
	
}
