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
class SecondActivityTest{
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SecondActivity>(SecondActivity::class.java)

    private val wordResponse= "wordResponse"

    //Проверка, что нет ответа от 1 активити (не заполнено поле)
    @Test
    fun checkReceived() {
        onView(withId(R.id.text_message)).check(matches(withText("")))
    }

    //Проверка, что вначале текста нет в поле ввода, а потом оно заполняется пользователем корректно
    @Test
    fun editText() {
        onView(withId(R.id.editText_second)).check(matches(withText("")))
        onView(withId(R.id.editText_second)).perform(ViewActions.typeText(wordResponse))
        onView(withId(R.id.editText_second)).check(matches(withText(wordResponse)))
    }

    //Проверка перехода на другую активити (нажатия) по клику
    @Test
    fun clickSendButtonBack() {
        onView(withId(R.id.button_second)).perform(ViewActions.click())
    }
}