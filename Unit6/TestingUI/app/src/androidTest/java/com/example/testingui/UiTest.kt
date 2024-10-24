package com.example.testingui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class UiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSearchAndSelectItem() {
        // Khởi chạy giao diện phức tạp để kiểm thử
        composeTestRule.setContent {
            Greeting("UiTesting")
        }

        // Kiểm tra xem có hiển thị text "Search:"
        composeTestRule
            .onNodeWithText("Search:")
            .assertExists()

        // Nhập text vào Search Field
        composeTestRule
            .onNodeWithText(("")) // Tìm field chưa có text
            .performTextInput("Anh An dep trai qua")

        // Kiểm tra có nút Item 2 và nhấn vào nó
        composeTestRule
            .onNodeWithText("Item 2")
            .performClick()

        // Kiểm tra text "Selected: Item 2" đã xuất hiện
        composeTestRule
            .onNodeWithText("Selected: Item 2")
            .assertExists()
    }

    @Test
    fun testBottomNavigationExists() {
        // Khởi chạy giao diện để kiểm thử
        composeTestRule.setContent {
            Greeting("UiTesting")
        }

        // Kiểm tra xem Bottom Navigation có hiển thị không
        composeTestRule
            .onNodeWithText("Bottom Navigation")
            .assertExists()
    }
}