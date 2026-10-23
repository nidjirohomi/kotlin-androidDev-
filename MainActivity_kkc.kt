package com.example.myapplicationkkc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class User(
    val avatar: String,
    val name: String,
    val job: String,
    val projects: String,
    val tasks: String,
    val exp: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val users = listOf(
                User("Т", "Тилек Асилбек уулу", "WEB-разработчик", "32", "12", "9"),
                User("Т", "Тилек Асилбек уулу", "WEB-разработчик", "32", "12", "9"),
                User("Т", "Тилек Асилбек уулу", "WEB-разработчик", "32", "12", "9")
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFECEFF1)) // Мягкий общий фон экрана
                    .padding(top = 32.dp, start = 14.dp, end = 14.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                users.forEach { user ->


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFFF5F7FA))
                            .padding(14.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {


                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF3F51B5)), // Синий аватар
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = user.avatar,
                                        color = Color.White,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }

                                Column {
                                    Text(
                                        text = user.name,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF1A237E)
                                    )
                                    Text(
                                        text = user.job,
                                        fontSize = 13.sp,
                                        color = Color(0xFF5C6BC0)
                                    )
                                }
                            }


                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFE8EEF5))
                                        .padding(vertical = 8.dp, horizontal = 4.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(
                                        text = user.projects,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        color = Color(0xFF1A237E)
                                    )
                                    Text(
                                        text = "проектов",
                                        fontSize = 11.sp,
                                        color = Color.Gray
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFE8EEF5))
                                        .padding(vertical = 8.dp, horizontal = 4.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(
                                        text = user.tasks,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        color = Color(0xFF1A237E)
                                    )
                                    Text(
                                        text = "задач",
                                        fontSize = 11.sp,
                                        color = Color.Gray
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFE8EEF5))
                                        .padding(vertical = 8.dp, horizontal = 4.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(
                                        text = user.exp,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        color = Color(0xFF1A237E)
                                    )
                                    Text(
                                        text = "лет опыта",
                                        fontSize = 11.sp,
                                        color = Color.Gray
                                    )
                                }
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Button(
                                    onClick = { },
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("Написать")
                                }
                                OutlinedButton(
                                    onClick = { },
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("Подписаться")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
