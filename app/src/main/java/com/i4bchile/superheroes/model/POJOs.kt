package com.i4bchile.superheroes.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName="superhero")
data class SuperHero(
        val id:Int,
        val name:String,
        val slug:String,
        @Embedded val powerstats:PowerStats,
        @Embedded val appearence:Appearence,
        @Embedded val biography:Biography,
        @Embedded val work:Work,
        @Embedded val connections:Connection,
        @Embedded val images:Image
        )

data class Connection(val groupAffiliation:String, val relatives:String)

data class Image(
        val xs:String,
        val sm:String,
        val md:String,
        val lg:String
)

data class Work(val occupation:String, val base:String)


data class Biography(
    val fullName:String,
    val alterEgos:String,
    val aliases:List<String>,
    val placeOfBirth:String,
    val firstAppearence:String,
    val publisher:String,
    val allignment:String
)

data class Appearence (
        val gender:String,
        val race: String,
        val heigth: List<String>,
        val weigth: List<String>,
        val eyecolor:String,
        val haircolor:String
        )

data class PowerStats(
        val intelligence: Int,
        val strength: Int,
        val speed: Int,
        val durability: Int,
        val power: Int,
        val combat: Int
)


