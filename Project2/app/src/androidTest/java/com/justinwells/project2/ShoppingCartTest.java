package com.justinwells.project2;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ShoppingCartTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shoppingCartTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.add_to_cart), isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.movie_card),
                                childAtPosition(
                                        withId(R.id.movies_in_cart),
                                        0)),
                        0),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.remove_button), isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.textView), withText("NO MOVIES IN CART"),

                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.total_price), withText("Total Price: $0.00"),

                        isDisplayed()));
        textView2.check(matches(withText("Total Price: $0.00")));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.checkout_button), withText("PROCEED TO CHECKOUT"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction relativeLayout2 = onView(
                allOf(
                        isDisplayed()));
        relativeLayout2.check(matches(isDisplayed()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.back), withText("back"), isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.add_to_cart), isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.add_to_cart), isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.price), withText("$25.00"),

                        isDisplayed()));
        textView3.check(matches(withText("$25.00")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.price), withText("$25.00"),

                        isDisplayed()));
        textView4.check(matches(withText("$25.00")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.total_price), withText("Total Price: $50.00"),

                        isDisplayed()));
        textView5.check(matches(withText("Total Price: $50.00")));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.checkout_button), withText("PROCEED TO CHECKOUT"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction relativeLayout3 = onView(
                allOf(withId(R.id.activity_checkout),

                        isDisplayed()));
        relativeLayout3.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
