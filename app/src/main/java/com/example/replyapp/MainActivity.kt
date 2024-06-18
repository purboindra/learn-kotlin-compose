package com.example.replyapp



import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.replyapp.ui.ReplyApp
import com.example.replyapp.ui.ReplyHomeViewModel


class MainActivity : ComponentActivity() {
    
    private val viewModel: ReplyHomeViewModel by viewModels()
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiState by viewModel.uiState.collectAsState()
            ReplyApp(replyHomeUIState = uiState, closeDetailScreen = {
                viewModel.closeDetailScreen()
            }, navigateToDetail = { emailId ->
                viewModel.setSelectedEmail(emailId)
            }
            )
        }
    }
}
//
//@Preview(
//    uiMode = UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
//@Preview(
//    uiMode = UI_MODE_NIGHT_NO,
//    name = "DefaultPreviewLight"
//)
//@Composable
//fun ReplyAppPreviewLight() {
//    ReplyApp(
//        replyHomeUIState = ReplyHomeUIState(
//            emails = LocalEmailsDataProvider.allEmails
//        )
//    )
//}