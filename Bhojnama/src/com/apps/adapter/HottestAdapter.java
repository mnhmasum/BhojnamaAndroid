package com.apps.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.adapter.NearbyAdapter.ViewHolder;
import com.apps.bhojnama.R;
import com.apps.bhojnamainfo.BhojNamaSingleton;
import com.apps.datamodel.HottestInfo;
import com.apps.datamodel.hottestlist;

public class HottestAdapter extends BaseAdapter{
	
	private ArrayList<HottestInfo> hottestInfo;
	private Context context;
	private LayoutInflater mInflater;
	
	public HottestAdapter(Context context, ArrayList<HottestInfo> hottestInfo) {
		this.hottestInfo = hottestInfo;
		this.context = context;
				
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.hottestInfo.size();
	}

	@Override
	public Object getItem(int position) {
		return this.hottestInfo.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		final ViewHolder holder;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.row_list_hottest, null);

			holder = new ViewHolder();
			holder.txtViewRestaurantName = (TextView) convertView.findViewById(R.id.txt_view_restaurant_name);
			holder.txtViewAddress = (TextView) convertView.findViewById(R.id.txt_view_address);
			holder.logo= (ImageView) convertView.findViewById(R.id.icon);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.txtViewRestaurantName.setText(BhojNamaSingleton.getInstance().getHottestInfoList().get(position).getRestaurantName());
		holder.txtViewAddress.setText(BhojNamaSingleton.getInstance().getHottestInfoList().get(position).getRestaurantAbout());
		//holder.logo.setI
		return convertView;
	}
	
	static class ViewHolder {
		TextView txtViewRestaurantName;
		TextView txtViewAddress;
		TextView txtViewDescription;
		TextView txtViewStartDate;
		TextView txtViewStartDay;
		
		TextView txtViewEndDate;
		TextView txtViewEndDay;
		
		TextView txtViewStartTime;
		TextView txtViewEndTime;
		
		TextView txtViewTo;
		ImageView logo;
		ImageView imgViewFavoriate;
	}

}
