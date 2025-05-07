package com.example.androidunittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuoteFromAssets_InvalidJSON_expected_Exception() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "malformed.json")
    }

    @Test
    fun testPopulateQuoteFromAssets_ValidJSON_expected_Count() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(15, quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_Expected_CorrectQuote() {
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is First Quote", "1"),
                Quote("This is second Quote", "2"),
                Quote("This is third Quote", "3")
            )
        )

        val quote = quoteManager.getPreviousQuote()
        assertEquals("1", quote.author)
    }

    @Test
    fun testNextQuote_Expected_CorrectQuote() {
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is First Quote", "1"),
                Quote("This is second Quote", "2"),
                Quote("This is third Quote", "3")
            )
        )

        val quote = quoteManager.getNextQuote()
        assertEquals("2", quote.author)
    }
}