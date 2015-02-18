package com.apps.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.adapter.HottestFoodItemAdapter;
import com.apps.bhojnama.NearbyMapDirectionActivity;
import com.apps.bhojnama.R;
import com.apps.bhojnamainfo.BhojNamaSingleton;

public class RestaurantDetailsFragment extends Fragment implements OnClickListener, OnItemClickListener{

//	ImageView ivIcon;
//	TextView tvItemName;
//
//	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
//	public static final String ITEM_NAME = "itemName";

	public RestaurantDetailsFragment() {}
	
	private View rootView;
	private ListView foodList;
	private Button btnGetMeThere, btnBookTable, btnSubmitReview;
	private TextView txtViewRestuarantName, txtViewRestaurantAddress;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_restaurant_details, container, false);
		foodList = (ListView) rootView.findViewById(R.id.food_list);
//		ivIcon = (ImageView) view.findViewById(R.id.frag1_icon);
//		ivIcon.setImageDrawable(view.getResources().getDrawable(getArguments().getInt(IMAGE_RESOURCE_ID)));
		
		btnGetMeThere = (Button) rootView.findViewById(R.id.btn_get_me_there);
		btnBookTable = (Button) rootView.findViewById(R.id.btn_book_table);
		btnSubmitReview = (Button) rootView.findViewById(R.id.btn_submit_review);
		
		txtViewRestuarantName = (TextView) rootView.findViewById(R.id.txt_view_restaurant_name);
		txtViewRestuarantName.setText(BhojNamaSingleton.getInstance().getHottestInfoList().get(getArguments().getInt("position")).getRestaurantName());
		txtViewRestaurantAddress = (TextView) rootView.findViewById(R.id.txt_view_address);
		txtViewRestaurantAddress.setText(BhojNamaSingleton.getInstance().getHottestInfoList().get(getArguments().getInt("position")).getCity());
		
		setListener();
		populatesFoodListView();
		
		rootView.setFocusableInTouchMode(true);
		rootView.requestFocus();
		rootView.setOnKeyListener(new View.OnKeyListener() {
		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
		            String tag = null;
					Log.e(tag, "keyCode: " + keyCode);
		            if( keyCode == KeyEvent.KEYCODE_BACK ) {
		                Log.e(tag, "onKey Back listener is working!!!");
		                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		                return true;
		            } else {
		                return false;
		            }
		        }
		    });

		
		return rootView;
		
		
	}

	private void setListener() {
		btnBookTable.setOnClickListener(RestaurantDetailsFragment.this);
		btnSubmitReview.setOnClickListener(RestaurantDetailsFragment.this);
		btnGetMeThere.setOnClickListener(RestaurantDetailsFragment.this);
		
	}

	private void populatesFoodListView() {
		foodList.setOnItemClickListener(this);
		foodList.setAdapter(new HottestFoodItemAdapter(getActivity(), BhojNamaSingleton.getInstance().getHottestInfoList().get(1).getHottestFoodItemList(), getArguments().getInt("position")));
	}
	
//	public void onBackPressed() {
//		Fragment fragment = null;
//		  Bundle args = new Bundle();
//		  fragment = new HomeFragment();
//		  fragment.setArguments(args);
//		  FragmentManager frgManager = getFragmentManager();
//		  frgManager.beginTransaction().replace(R.id.content_frame, fragment)
//					.commit();
//	  
//	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_make_food_shots) {
			
		} else if (v.getId() == R.id.btn_get_me_there) {
			Intent intent = new Intent(getActivity(), NearbyMapDirectionActivity.class);
			intent.putExtra("list_position", 1);
			intent.putExtra("view_type", "hottest");
			startActivity(intent);
			
		} else if (v.getId() == R.id.btn_submit_review) {
			Fragment fragment = null;
			Bundle args = new Bundle();
			args.putInt("position", getArguments().getInt("position"));
			fragment = new SignUpFragment();
			fragment.setArguments(args);
			FragmentManager frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
			getActivity().setTitle("Sign Up");
			
		} else if (v.getId() == R.id.btn_book_table) {
			Toast.makeText(getActivity(), "Position: " + getArguments().getInt("position"), Toast.LENGTH_SHORT).show();
			Fragment fragment = null;
			Bundle args = new Bundle();
			args.putInt("position", getArguments().getInt("position"));
			fragment = new BooktableFragment();
			fragment.setArguments(args);
			FragmentManager frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
			getActivity().setTitle("Sign Up");
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
		  Fragment fragment = null;
		  Bundle args = new Bundle();
		  args.putInt("position", position);
		  
		  fragment = new FooddetailsFragment();
		  fragment.setArguments(args);
		  FragmentManager frgManager = getFragmentManager();
		  frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
		  getActivity().setTitle("Food Item Deatils");
		
	}

}
