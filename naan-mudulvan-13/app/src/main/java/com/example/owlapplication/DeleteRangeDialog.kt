package com.example.owlapplication
import androidx.compose.foundation.clickable

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeleteDialog(
    contentList: List<String>,
    onDismiss: () -> Unit,
    onConfirm: (List<Int>) -> Unit,  // onConfirm expects a list of indices to delete
    sharedPreferences: SharedPreferences
) {
    var selectedIndices by remember { mutableStateOf<Set<Int>>(emptySet()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Delete Content") },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Select the content you want to delete:")

                Spacer(modifier = Modifier.height(8.dp))

                contentList.forEachIndexed { index, content ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                if (selectedIndices.contains(index)) {
                                    selectedIndices = selectedIndices - index
                                } else {
                                    selectedIndices = selectedIndices + index
                                }
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = selectedIndices.contains(index),
                            onCheckedChange = {
                                if (it) {
                                    selectedIndices = selectedIndices + index
                                } else {
                                    selectedIndices = selectedIndices - index
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = content,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(selectedIndices.toList())
                    onDismiss()
                }
            ) {
                Text("Delete")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
