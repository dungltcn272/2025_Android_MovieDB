package com.nhom4.androidmoviedb.data.parse

import com.nhom4.androidmoviedb.data.model.MovieResponseDto
import org.json.JSONArray
import org.json.JSONObject

fun parseTrendingMovieResponseDto(json: JSONObject): MovieResponseDto {
    val status = json.optBoolean("status", false)
    val msg = json.optString("msg", "")
    val itemsJson = json.optJSONArray("items") ?: JSONArray()
    val paginationJson = json.optJSONObject("pagination") ?: JSONObject()
    val totalPages = paginationJson.optInt("totalPages", 0)
    return MovieResponseDto(status, msg, parseMovieItemList(itemsJson), totalPages)
}
