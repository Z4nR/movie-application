package com.dicoding.picodiploma.movieapplication.data.source.local.entity.tvseries

import androidx.room.Embedded
import androidx.room.Relation
import com.dicoding.picodiploma.movieapplication.data.source.remote.response.GenresItem

data class TVSeriesDetails (
    @Embedded
    val tvSeriesEntity: TVSeriesEntity,

    @Relation(parentColumn = "tvSeriesId", entityColumn = "tvSeriesId")
    val genres: List<TVSeriesGenreEntity>
)