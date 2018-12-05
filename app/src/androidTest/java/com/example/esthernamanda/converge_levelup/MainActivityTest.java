package com.example.esthernamanda.converge_levelup;

import android.content.pm.ActivityInfo;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch(){
        View view = mainActivity.findViewById(R.id.my_recycler_view);
        onView(withId(R.id.my_recycler_view)).check(matches(isDisplayed()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.my_recycler_view)).perform(scrollToPosition(5), click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(view);

    }


    @Test
    public void testRecyclerViewIsDisplayed(){
        View view = mainActivity.findViewById(R.id.my_recycler_view);
        onView(withId(R.id.my_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerViewOnItemClick(){
        View view = mainActivity.findViewById(R.id.my_recycler_view);
        onView(withId(R.id.my_recycler_view)).check(matches(isDisplayed()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.my_recycler_view)).perform(scrollToPosition(5), click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testDevlopersDetailsDisplayed(){
        View view = mainActivity.findViewById(R.id.my_recycler_view);
        onView(withId(R.id.my_recycler_view)).check(matches(isDisplayed()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.my_recycler_view)).perform(scrollToPosition(5), click());

        onView(withId(R.id.username_details_txt)).check(matches(isDisplayed()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.url_details_txt)).check(matches(isDisplayed()));
        pressBack();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testOrientationChange(){
        View view = mainActivity.findViewById(R.id.my_recycler_view);
        mainActivityActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        onView(withId(R.id.my_recycler_view)).check(matches(isDisplayed()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainActivityActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        onView(withId(R.id.my_recycler_view)).check(matches(isDisplayed()));

    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}