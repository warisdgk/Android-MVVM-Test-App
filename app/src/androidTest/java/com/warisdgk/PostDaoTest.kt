package com.warisdgk

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.warisdgk.data.entities.Post
import com.warisdgk.data.local.AppDatabase
import com.warisdgk.data.local.PostDao
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PostDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var postDao: PostDao
    private val postA = Post(1, 1, "Post A", "Post body A")
    private val postB = Post(2, 2, "Post B", "Post body B")
    private val postC = Post(3, 3, "Post C", "Post body C")

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        postDao = database.postDao()

        postDao.insertAll(listOf(postA, postB, postC))
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testInsertionByMatchingSize() {
        val posts = getValue(postDao.getAllPosts())
        assertThat(posts.size, CoreMatchers.equalTo(3))
    }

    @Test
    fun testPostAData() {
        val post = getValue(postDao.getPost(postC.id))
        assertThat(post.id, CoreMatchers.equalTo(3))
    }

    @Test
    fun testPostInsertion() = runBlocking {
        val posts = getValue(postDao.getAllPosts())
        assertThat(posts.size, CoreMatchers.equalTo(3))

        val postD = Post(
            4,
            4,
            "Post D",
            "Post D Body"
        )
        postDao.insert(postD)

        val postsAfterInsertion =
            getValue(postDao.getAllPosts())
        assertThat(postsAfterInsertion.size, CoreMatchers.equalTo(4))
    }
}