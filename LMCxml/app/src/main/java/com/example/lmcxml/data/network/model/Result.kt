package com.example.lmcxml.data.network.model

import java.time.ZonedDateTime

data class Result(
    val `abstract`: String?,
    val byline: String?,
    val created_date: String,
    val des_facet: List<String>,
    val geo_facet: List<String>,
    val item_type: String,
    val kicker: String,
    val material_type_facet: String,
    val multimedia: List<Multimedia>?,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val published_date: ZonedDateTime?,
    val section: String,
    val short_url: String,
    val subsection: String,
    val title: String?,
    val updated_date: String,
    val uri: String,
    val url: String
)