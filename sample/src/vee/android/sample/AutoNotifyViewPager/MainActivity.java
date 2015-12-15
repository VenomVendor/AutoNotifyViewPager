
package vee.android.sample.AutoNotifyViewPager;

import com.venomvendor.library.AutoNotifyViewPager;
import com.venomvendor.library.AutoNotifyViewPager.OnPageChangeListener;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	/**
	 * TAG for Log
	 */
	private final String tag = getClass().getSimpleName();

	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link AutoNotifyViewPager} that will host the section contents.
	 */
	AutoNotifyViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		mSectionsPagerAdapter.setCount(50);
		// Set up the ViewPager with the sections adapter.
		mPager = (AutoNotifyViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mSectionsPagerAdapter);
		String x = AutoNotifyViewPager.LAST_COMMIT_HASH;

		// Optional
		// AutoNotifyViewPager.OnPageChangeListener
		mPager.addOnPageChangeListener(mPageChangeListener);

	}

	private OnPageChangeListener mPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int position) {
			// Log.i(tag, "onPageSelected" + " , " + position);
			if (position % 2 == 0) {
				mSectionsPagerAdapter.setCount(200);
			} else {
				mSectionsPagerAdapter.setCount(100);
			}
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			// Log.i(tag, "onPageScrolled " + position + " , " + positionOffset
			// + " , " + positionOffsetPixels);
		}

		@Override
		public void onPageScrollStateChanged(int state) {
			// Log.i(tag, "onPageScrollStateChanged");
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		private int mCount = 100;

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		public void setCount(int count) {
			mCount = count;
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			return PlaceholderFragment.newInstance(position + 1);
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return mCount;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "Page : " + position;
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@SuppressLint("NewApi")
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			TextView textView = (TextView) rootView.findViewById(R.id.section_label);
			textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
