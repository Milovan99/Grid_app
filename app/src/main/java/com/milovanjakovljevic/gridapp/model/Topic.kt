package com.milovanjakovljevic.gridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val titleResourceId:Int,val topicNumber:Int,@DrawableRes val imageResourceId:Int)
