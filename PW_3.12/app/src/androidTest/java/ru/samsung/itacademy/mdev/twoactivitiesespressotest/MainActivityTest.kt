package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.Test as Test

@RunWith(AndroidJUnit4 :: class)
class MainActivityTest{
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    //Проверка, что изначально нет ответа от 2 активити
    @Test
    fun checkResponse() {
        onView(withId(R.id.text_message_reply)).check(matches(withText("")))
    }

    //Проверка, что вначале текста нет в поле ввода, а потом поле заполняется пользователем успешно
    private val wordSend = "wordSend"
    @Test
    fun editText() {
        onView(withId(R.id.editText_main)).check(matches(withText("")))
        onView(withId(R.id.editText_main)).perform(ViewActions.typeText(wordSend))
        onView(withId(R.id.editText_main)).check(matches(withText(wordSend)))
    }

    //Проверка перехода на другую активити по клику
    @Test
    fun clickButton() {
        onView(withId(R.id.button_main)).perform(ViewActions.click())
        onView(withId(R.id.text_header)).check(matches(isDisplayed()))
    }
}