package com.hackaton.composetest.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hackaton.composetest.R
import java.util.*

data class TodoItem(
    val task: String,
    val icon: TodoIcon = TodoIcon.Default,
    val id: UUID = UUID.randomUUID()
)

enum class TodoIcon(val imageVector: ImageVector, @StringRes val contentDescription: Int) {
    Square(Icons.Default.CropSquare, R.string.cd_crop_square),
    Done(Icons.Default.Done, R.string.cd_done),
    Event(Icons.Default.Event, R.string.cd_event),
    Privacy(Icons.Default.PrivacyTip, R.string.cd_privacy),
    Trash(Icons.Default.RestoreFromTrash, R.string.cd_restore);

    companion object {
        val Default = Square
    }
}