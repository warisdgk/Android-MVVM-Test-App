package com.warisdgk

import com.warisdgk.data.local.AppDatabase
import com.warisdgk.data.remote.PostsService
import com.warisdgk.ui.details.DetailsFragment
import com.warisdgk.ui.home.HomeFragment
import org.junit.Test

import org.junit.Assert.*


class BasicUnitTests {

    @Test
    fun test_base_url() {
        assertEquals("https://jsonplaceholder.typicode.com/", PostsService.BASE_URL)
    }

    @Test
    fun test_db_name() {
        assertEquals("posts-db", AppDatabase.DATABASE_NAME)
    }

    @Test
    fun test_home_arg_key() {
        assertEquals("postId", HomeFragment.KEY_POST_ID)
    }

    @Test
    fun test_details_arg_key() {
        assertEquals("postId", DetailsFragment.KEY_POST_ID)
    }

}