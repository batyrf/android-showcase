package com.igorwojda.showcase.feature.album.data.model

import com.igorwojda.showcase.feature.album.data.enum.AlbumDataImageSize
import com.igorwojda.showcase.feature.album.data.enum.toDomainEnum
import com.igorwojda.showcase.feature.album.data.enum.toEntityEnum
import com.igorwojda.showcase.feature.album.data.room.entity.AlbumImageDataEntity
import com.igorwojda.showcase.feature.album.domain.model.AlbumImageDomainModel
import com.squareup.moshi.Json

internal data class AlbumImageDataModel(
    @field:Json(name = "#text") val url: String,
    val size: AlbumDataImageSize
)

internal fun AlbumImageDataModel.toDomainModel() = AlbumImageDomainModel(
    url = this.url,
    size = this.size.toDomainEnum()
)

internal fun AlbumImageDataModel.toEntity() =
    this.size.toEntityEnum()?.let { AlbumImageDataEntity(this.url, it) }
