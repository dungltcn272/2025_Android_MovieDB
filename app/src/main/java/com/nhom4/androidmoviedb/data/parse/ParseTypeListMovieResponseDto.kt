package com.nhom4.androidmoviedb.data.parse

import com.nhom4.androidmoviedb.data.model.MovieResponseDto
import org.json.JSONArray
import org.json.JSONObject

fun parseTypeListMovieResponseDto(json: JSONObject): MovieResponseDto {
    val status = json.optBoolean("status", false)
    val msg = json.optString("msg", "")
    val dataJson = json.optJSONObject("data") ?: JSONObject()
    val itemsJson = dataJson.optJSONArray("items") ?: JSONArray()
    val paramsJson = dataJson.optJSONObject("params") ?: JSONObject()
    val paginationJson = paramsJson.optJSONObject("pagination") ?: JSONObject()
    val totalPages = paginationJson.optInt("totalPages", 0)
    return MovieResponseDto(status, msg, parseMovieItemList(itemsJson), totalPages)
}
