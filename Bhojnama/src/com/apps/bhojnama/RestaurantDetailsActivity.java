package com.apps.bhojnama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.apps.adapter.HottestFoodItemAdapter;
import com.apps.bhojnamainfo.BhojNamaSingleton;

public class RestaurantDetailsActivity extends Activity implements OnClickListener, OnItemClickListener{

//	ImageView ivIcon;
//	TextView tvItemName;
//
//	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
//	public static final String ITEM_NAME = "itemName";

	private View rootView;
	private ListView foodList;
	private Button btnGetMeThere, btnBookTable, btnSubmitReview;
	private TextView txtViewRestuarantName, txtViewRestaurantAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_restaurant_details);
		//rootView = inflater.inflate(R.layout.fragment_restaurant_details, container, false);
		foodList = (ListView) findViewById(R.id.food_list);
//		ivIcon = (ImageView) view.findViewById(R.id.frag1_icon);
//		ivIcon.setImageDrawable(view.getResources().getDrawable(getArguments().getInt(IMAGE_RESOURCE_ID)));
		
		btnGetMeThere = (Button) findViewById(R.id.btn_get_me_there);
		btnBookTable = (Button) findViewById(R.id.btn_book_table);
		btnSubmitReview = (Button)findViewById(R.id.btn_submit_review);
		
		txtViewRestuarantName = (TextView) findViewById(R.id.txt_view_restaurant_name);
		txtViewRestuarantName.setText(BhojNamaSingleton.getInstance().getHottestInfoList().get(getIntent().getExtras().getInt("position")).getRestaurantName());
		txtViewRestaurantAddress = (TextView)findViewById(R.id.txt_view_address);
		txtViewRestaurantAddress.setText(BhojNamaSingleton.getInstance().getHottestInfoList().get(getIntent().getExtras().getInt("position")).getCity());
		
		setListener();
		populatesFoodListView();
	}

	private void setListener() {
		btnBookTable.setOnClickListener(RestaurantDetailsActivity.this);
		btnSubmitReview.setOnClickListener(RestaurantDetailsActivity.this);
		btnGetMeThere.setOnClickListener(RestaurantDetailsActivity.this);
		
	}

	private void populatesFoodListView() {
		foodList.setOnItemClickListener(this);
		//foodList.setAdapter(new HottestFoodItemAdapter(this, BhojNamaSingleton.getInstance().getHottestInfoList().get(1).getHottestFoodItemList(), getIntent().getExtras().getInt("position")));
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
			Intent intent = new Intent(this, NearbyMapDirectionActivity.class);
			intent.putExtra("list_position", 1);
			intent.putExtra("view_type", "hottest");
			startActivity(intent);
			
		} else if (v.getId() == R.id.btn_submit_review) {
			/*Fragment fragment = null;
			Bundle args = new Bundle();
			args.putInt("position", getArguments().getInt("position"));
			fragment = new SignUpFragment();
			fragment.setArguments(args);
			FragmentManager frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
			this.setTitle("Sign Up");*/
			
		} else if (v.getId() == R.id.btn_book_table) {
			/*Toast.makeText(this, "Position: " + getArguments().getInt("position"), Toast.LENGTH_SHORT).show();
			Fragment fragment = null;
			Bundle args = new Bundle();
			args.putInt("position", getArguments().getInt("position"));
			fragment = new BooktableFragment();
			fragment.setArguments(args);
			FragmentManager frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
			this.setTitle("Sign Up");*/
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
		 /* Fragment fragment = null;
		  Bundle args = new Bundle();
		  args.putInt("position", position);
		  
		  fragment = new FooddetailsFragment();
		  fragment.setArguments(args);
		  FragmentManager frgManager = getFragmentManager();
		  frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
		  this.setTitle("Food Item Deatils");*/
		
	}

}
