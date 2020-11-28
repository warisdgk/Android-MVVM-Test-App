package com.warisdgk.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.warisdgk.data.entities.Post

@Dao
interface PostDao {

    @Query("SELECT * FROM posts")
    fun getAllPosts(): LiveData<List<Post>>

    @Query("SELECT * FROM posts WHERE id = :id")
    fun getPost(id: Int): LiveData<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Post>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: Post)

}