package com.nhom4.androidmoviedb.data.parse

import com.nhom4.androidmoviedb.data.model.CategoryDto
import com.nhom4.androidmoviedb.data.model.CountryDto
import com.nhom4.androidmoviedb.data.model.ImdbInfoDto
import com.nhom4.androidmoviedb.data.model.ModifiedInfoDto
import com.nhom4.androidmoviedb.data.model.MovieItemDto
import com.nhom4.androidmoviedb.data.model.TmdbInfoDto
import org.json.JSONArray
import org.json.JSONObject

fun parseMovieItemList(itemsJson: JSONArray): List<MovieItemDto> {
    val items = mutableListOf<MovieItemDto>()
    for (i in 0 until itemsJson.length()) {
        val itemJson = itemsJson.getJSONObject(i)
        val tmdbJson = itemJson.optJSONObject("tmdb") ?: JSONObject()
        val imdbJson = itemJson.optJSONObject("imdb") ?: JSONObject()
        val modifiedJson = itemJson.optJSONObject("modified") ?: JSONObject()
        val categoryArray = itemJson.optJSONArray("category") ?: JSONArray()
        val countryArray = itemJson.optJSONArray("country") ?: JSONArray()
        val categoryList = mutableListOf<CategoryDto>()
        for (j in 0 until categoryArray.length()) {
            val cat = categoryArray.getJSONObject(j)
            categoryList.add(CategoryDto(cat.optString("id", ""), cat.optString("name", ""), cat.optString("slug", "")))
        }
        val countryList = mutableListOf<CountryDto>()
        for (j in 0 until countryArray.length()) {
            val c = countryArray.getJSONObject(j)
            countryList.add(CountryDto(c.optString("id", ""), c.optString("name", ""), c.optString("slug", "")))
        }
        items.add(
            MovieItemDto(
                tmdb = TmdbInfoDto(
                    type = tmdbJson.optString("type", ""),
                    id = tmdbJson.optString("id", ""),
                    season = if (tmdbJson.has("season")) tmdbJson.optInt("season") else null,
                    vote_average = tmdbJson.optDouble("vote_average", 0.0),
                    vote_count = tmdbJson.optInt("vote_count", 0)
                ),
                imdb = ImdbInfoDto(id = imdbJson.optString("id", "")),
                modified = ModifiedInfoDto(time = modifiedJson.optString("time", "")),
                _id = itemJson.optString("_id", ""),
                name = itemJson.optString("name", ""),
                slug = itemJson.optString("slug", ""),
                origin_name = itemJson.optString("origin_name", ""),
                type = itemJson.optString("type", ""),
                poster_url = itemJson.optString("poster_url", ""),
                thumb_url = itemJson.optString("thumb_url", ""),
                sub_docquyen = itemJson.optBoolean("sub_docquyen", false),
                chieurap = if (itemJson.has("chieurap")) itemJson.optBoolean("chieurap") else null,
                time = itemJson.optString("time", ""),
                episode_current = itemJson.optString("episode_current", ""),
                quality = itemJson.optString("quality", ""),
                lang = itemJson.optString("lang", ""),
                year = itemJson.optInt("year", 0),
                category = categoryList,
                country = countryList
            )
        )
    }
    return items
}
