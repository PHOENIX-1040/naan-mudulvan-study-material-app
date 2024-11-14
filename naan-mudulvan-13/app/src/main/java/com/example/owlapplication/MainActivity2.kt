/*package com.example.owlapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.owlapplication.ui.theme.OwlApplicationTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}
@Composable
fun Greeting() {
    Column(
        modifier = Modifier.padding(start = 26.dp, end = 26.dp, bottom = 26.dp, top = 26.dp)
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painterResource(id = R.drawable.img_1),
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .scale(scaleX = 1.5F, scaleY = 1.5F)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = stringResource(id = R.string.course1),
            color = Color(0xFFB2F436),
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.topic1),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.subheading1_1),
            modifier = Modifier.align(Alignment.Start),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.text1_1),
            modifier = Modifier.align(Alignment.Start),
            textAlign = TextAlign.Justify,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.subheading1_2),
            modifier = Modifier.align(Alignment.Start),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.text1_2),
            modifier = Modifier.align(Alignment.Start),
            textAlign = TextAlign.Justify,
            fontSize = 16.sp
        )




    }
}

 */
/*package com.example.owlapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.owlapplication.ui.theme.OwlApplicationTheme

class MainActivity2 : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

        setContent {
            OwlApplicationTheme {
                Greeting(sharedPreferences)
            }
        }
    }
}

@Composable
fun Greeting(sharedPreferences: SharedPreferences) {
    var showDialog by remember { mutableStateOf(false) }
    var additionalContent by remember { mutableStateOf(loadContent(sharedPreferences)) }

    if (showDialog) {
        AddContentDialog2(
            onDismiss = { showDialog = false },
            onConfirm = { newText ->
                additionalContent += "\n$newText"
                saveContent(sharedPreferences, additionalContent)
                showDialog = false
            }
        )
    }

    Box(
        modifier = Modifier
            .padding(26.dp)
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.scale(2f)
            )

            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = stringResource(id = R.string.course1),
                color = Color(0xFAFD8383),
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.topic1),
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.subheading1_1),
                modifier = Modifier.align(Alignment.Start),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.text1_1),
                modifier = Modifier.align(Alignment.Start),
                textAlign = TextAlign.Justify,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            if (additionalContent.isNotEmpty()) {
                Text(
                    text = additionalContent,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Justify,
                    fontSize = 16.sp,
                )
            }
        }

        // Cyan icon at the top-right corner
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Content",
            tint = Color.White,
            modifier = Modifier
                .size(36.dp)
                .background(Color.Cyan, shape = CircleShape)
                .align(Alignment.TopEnd) // Align to top-end (top-right corner)
                .padding(4.dp)
                .clickable {
                    showDialog = true
                }
        )
    }
}

fun saveContent(sharedPreferences: SharedPreferences, content: String) {
    with(sharedPreferences.edit()) {
        putString("additional_content", content)
        apply()
    }
}

fun loadContent(sharedPreferences: SharedPreferences): String {
    return sharedPreferences.getString("additional_content", "") ?: ""
}

@Composable
fun AddContentDialog2(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var newText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Add New Content") },
        text = {
            Column {
                Text("Enter new content below:")
                Spacer(modifier = Modifier.height(8.dp))
                BasicTextField(
                    value = newText,
                    onValueChange = { newTextValue -> newText = newTextValue },
                    modifier = Modifier
                        .background(Color.LightGray, shape = CircleShape)
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onConfirm(newText) }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
*/

/*package com.example.owlapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    var showDialog by remember { mutableStateOf(false) }
    var additionalContent by remember { mutableStateOf("") }

    if (showDialog) {
        AddContentDialog2(
            onDismiss = { showDialog = false },
            onConfirm = { newText ->
                additionalContent += "\n$newText"
                showDialog = false
            }
        )
    }

    Column(
        modifier = Modifier
            .padding(26.dp)
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .scale(scaleX = 1.5F, scaleY = 1.5F)
            )

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Content",
                tint = Color.White,
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Cyan, shape = CircleShape)
                    .padding(8.dp)
                    .offset(x = (-16).dp, y = 16.dp)
                    .clickable {
                        showDialog = true
                    }
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = stringResource(id = R.string.course1),
            color = Color(0xFF008577),
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.topic1),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.subheading1_1),
            modifier = Modifier.align(Alignment.Start),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.text1_1),
            modifier = Modifier.align(Alignment.Start),
            textAlign = TextAlign.Justify,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (additionalContent.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = additionalContent,
                modifier = Modifier.align(Alignment.Start),
                textAlign = TextAlign.Justify,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun AddContentDialog2(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var newText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Add New Content") },
        text = {
            Column {
                Text("Enter new content below:")
                Spacer(modifier = Modifier.height(8.dp))
                BasicTextField(
                    value = newText,
                    onValueChange = { newText = it },
                    modifier = Modifier
                        .background(Color.LightGray, shape = CircleShape)
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(newText) }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}


 */

package com.example.owlapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    var showAddDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var additionalContent by remember { mutableStateOf("") }

    if (showAddDialog) {
        AddContentDialog2(
            onDismiss = { showAddDialog = false },
            onConfirm = { newText ->
                additionalContent += "\n$newText"
                showAddDialog = false
            }
        )
    }

    if (showDeleteDialog) {
        DeleteContentDialog2(
            onDismiss = { showDeleteDialog = false },
            onConfirm = {
                additionalContent = ""
                showDeleteDialog = false
            }
        )
    }

    Column(
        modifier = Modifier
            .padding(26.dp)
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .scale(scaleX = 1.5F, scaleY = 1.5F)
            )

            Row(
                modifier = Modifier.padding(end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Content",
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.Cyan, shape = CircleShape)
                        .padding(8.dp)
                        .offset(x = 0.dp, y = 0.dp)
                        .clickable {
                            showAddDialog = true
                        }
                )

                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Content",
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.Red, shape = CircleShape)
                        .padding(8.dp)
                        .offset(x = 0.dp, y = 0.dp)
                        .clickable {
                            showDeleteDialog = true
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = stringResource(id = R.string.course1),
            color = Color(0xFF008577),
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.topic1),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.subheading1_1),
            modifier = Modifier.align(Alignment.Start),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.text1_1),
            modifier = Modifier.align(Alignment.Start),
            textAlign = TextAlign.Justify,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (additionalContent.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = additionalContent,
                modifier = Modifier.align(Alignment.Start),
                textAlign = TextAlign.Justify,
                fontSize = 16.sp,
                //color = Color.Gray
            )
        }
    }
}

@Composable
fun AddContentDialog2(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var newText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Add New Content") },
        text = {
            Column {
                Text("Enter new content below:")
                Spacer(modifier = Modifier.height(8.dp))
                BasicTextField(
                    value = newText,
                    onValueChange = { newText = it },
                    modifier = Modifier
                        .background(Color.LightGray, shape = CircleShape)
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(newText) }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun DeleteContentDialog2(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Delete Content") },
        text = { Text("Are you sure you want to delete all additional content?") },
        confirmButton = {
            Button(onClick = { onConfirm() }) {
                Text("Delete")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}
