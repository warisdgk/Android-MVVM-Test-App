package com.warisdgk

import com.warisdgk.data.local.AppDatabase
import com.warisdgk.data.remote.PostsService
import com.warisdgk.ui.details.DetailsFragment
import com.warisdgk.ui.home.HomeFragment
import org.junit.Test

import org.junit.Assert.*


class BasicUnitTests {

    @Test
    fun testBaseUrl() {
        assertEquals("https://jsonplaceholder.typicode.com/", PostsService.BASE_URL)
    }

    @Test
    fun testDBName() {
        assertEquals("posts-db", AppDatabase.DATABASE_NAME)
    }

    @Test
    fun testHomeFragArgKey() {
        assertEquals("postId", HomeFragment.KEY_POST_ID)
    }

    @Test
    fun testDetailsFragArgKey() {
        assertEquals("postId", DetailsFragment.KEY_POST_ID)
    }

}