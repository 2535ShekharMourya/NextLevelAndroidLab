package com.azad.masterrecyclerview.util

import com.azad.masterrecyclerview.datamodel.postsData.PostsItem
import com.azad.masterrecyclerview.localroomdatabase.PostEntity

object Utility {
    fun PostsItem.toEntity(): PostEntity {
        return PostEntity(
            body = body,
            email = email,
            id = id,
            name = name,
            postId = postId
        )
    }

    fun PostEntity.toPostItem(): PostsItem {
        return PostsItem(
            body = body,
            email = email,
            id = id,
            name = name,
            postId = postId
        )
    }
}