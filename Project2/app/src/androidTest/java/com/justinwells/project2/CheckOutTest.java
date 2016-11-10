package com.justinwells.project2;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.justinwells.project2.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CheckOutTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkOutTest() {
        ViewInteraction appCompatImageButton = onView(
allOf(withId(R.id.add_to_cart), isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
allOf(withId(R.id.add_to_cart), isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction floatingActionButton = onView(
allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.checkout_button), withText("PROCEED TO CHECKOUT"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction relativeLayout = onView(
allOf(

isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction appCompatButton2 = onView(
allOf(withId(R.id.back), withText("back"), isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        ViewInteraction appCompatImageButton3 = onView(
allOf(withId(R.id.add_to_cart), isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction floatingActionButton2 = onView(
allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction relativeLayout2 = onView(
allOf(childAtPosition(
allOf(withId(R.id.movie_card),
childAtPosition(
withId(R.id.movies_in_cart),
0)),
0),
isDisplayed()));
        relativeLayout2.check(matches(isDisplayed()));

        ViewInteraction appCompatButton3 = onView(
allOf(withId(R.id.checkout_button), withText("PROCEED TO CHECKOUT"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction relativeLayout3 = onView(
allOf(withId(R.id.activity_checkout),

isDisplayed()));
        relativeLayout3.check(matches(isDisplayed()));

        ViewInteraction appCompatButton4 = onView(
allOf(withId(R.id.pay_and_finish), withText("finish and pay"),
withParent(allOf(withId(R.id.activity_checkout),
withParent(withId(android.R.id.content)))),
isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction relativeLayout4 = onView(
allOf(withId(R.id.activity_checkout),

isDisplayed()));
        relativeLayout4.check(matches(isDisplayed()));

        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.first_name), isDisplayed()));
        appCompatEditText.perform(replaceText("tsty"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.last_name), isDisplayed()));
        appCompatEditText2.perform(replaceText("mctestf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.address), isDisplayed()));
        appCompatEditText3.perform(replaceText("123 test st"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.card_number), isDisplayed()));
        appCompatEditText4.perform(replaceText("1234567890"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.card_number), withText("1234567890"), isDisplayed()));
        appCompatEditText5.perform(pressImeActionButton());

        ViewInteraction appCompatButton5 = onView(
allOf(withId(R.id.pay_and_finish), withText("finish and pay"),
withParent(allOf(withId(R.id.activity_checkout),
withParent(withId(android.R.id.content)))),
isDisplayed()));
        appCompatButton5.perform(click());

        pressBack();

        ViewInteraction relativeLayout5 = onView(
allOf(

isDisplayed()));
        relativeLayout5.check(matches(isDisplayed()));

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
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
