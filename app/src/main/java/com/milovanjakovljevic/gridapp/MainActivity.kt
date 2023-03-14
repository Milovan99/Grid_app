package com.milovanjakovljevic.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.milovanjakovljevic.gridapp.data.DataSource
import com.milovanjakovljevic.gridapp.model.Topic
import com.milovanjakovljevic.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridApp()

        }
    }
}

@Composable
fun GridApp() {
GridAppTheme() {
TopicGrid(topics = DataSource.topics)
}
}

@Composable
fun GridCard(topic: Topic,modifier: Modifier=Modifier){
 Card(elevation = 4.dp) {
     Row(){
         Box {
             Image(
                 painter = painterResource(id = topic.imageResourceId),
                 contentDescription = null,
                 modifier = modifier
                     .size(width = 68.dp, height = 68.dp)
                     .aspectRatio(1f),
                 contentScale = ContentScale.Crop
             )
         }

         Column( ) {
             Text(
                 text = stringResource(id = topic.titleResourceId),
                 style = MaterialTheme.typography.body2,
                 modifier = Modifier.padding(
                     start = 16.dp,
                     top = 16.dp,
                     end = 16.dp,
                     bottom = 8.dp
                 )
             )
             Row(verticalAlignment = Alignment.CenterVertically) {
                 Icon(
                     painter = painterResource(R.drawable.ic_grain),
                     contentDescription = null,
                     modifier = Modifier
                         .padding(start = 16.dp)
                 )
                 Text(
                     text = topic.topicNumber.toString(),
                     style = MaterialTheme.typography.caption,
                     modifier = Modifier.padding(start = 8.dp)
                 )
             }
         }
     }
 }
    
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TopicGrid(topics:List<Topic>,modifier: Modifier=Modifier){
LazyVerticalGrid(cells = GridCells.Fixed(2), content ={
    items(topics) {
GridCard(topic = it)
    }
},
verticalArrangement = Arrangement.spacedBy(8.dp),
horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = modifier.padding(8.dp)   )
}

