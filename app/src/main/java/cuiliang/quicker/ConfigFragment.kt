package cuiliang.quicker

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker.OnValueChangeListener
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ConfigFragment : Fragment() {

    companion object {
        fun newInstance() = ConfigFragment()
    }

    private lateinit var viewModel: ConfigViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent { ConfigView() }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ConfigViewModel::class.java]
    }
}

@Preview
@Composable
fun ConfigView() {
    val sHost = remember { mutableStateOf("") }
    val sPort = remember { mutableStateOf("") }
    val authCode = remember { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CreateInput(v = sHost, resId = R.string.serviceHost)
        CreateInput(v = sPort, resId = R.string.servicePort)
        CreateInput(v = authCode, resId = R.string.authCode)
        CreateInput(v = authCode, resId = R.string.webSocketPort)
        CreateInput(v = authCode, resId = R.string.webSocketAuthCode)
        Button(onClick = {

        }) {
            Text(text = stringResource(id = R.string.btnConnect))
        }
        Text(text = stringResource(id = R.string.useAppHint))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateInput(v: MutableState<String>, @StringRes resId: Int) {
    OutlinedTextField(value = v.value,
        label = { Text(text = stringResource(id = resId)) },
        modifier = Modifier.padding(10.dp),
        onValueChange = {
            v.value = it
        })
}