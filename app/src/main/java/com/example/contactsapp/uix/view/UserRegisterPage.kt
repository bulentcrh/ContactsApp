package com.example.contactsapp.uix.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactsapp.R
import com.example.contactsapp.uix.viewModel.RegisterPageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegisterPage(
    registerPageViewModel: RegisterPageViewModel,
    navController: NavController
) {
    var personName by remember { mutableStateOf("") }
    var personTel by remember { mutableStateOf("") }
    var isNameError by remember { mutableStateOf(false) }
    var isPhoneError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add New Contact") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Avatar Placeholder
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                shape = MaterialTheme.shapes.extraLarge,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            // Name Field
            Column {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = personName,
                    onValueChange = { 
                        personName = it
                        isNameError = it.isEmpty()
                    },
                    label = { Text("Full Name") },
                    leadingIcon = { 
                        Icon(Icons.Default.Person, contentDescription = null)
                    },
                    isError = isNameError,
                    supportingText = {
                        if (isNameError) {
                            Text("Name is required")
                        }
                    }
                )
            }

            // Phone Field
            Column {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = personTel,
                    onValueChange = { 
                        personTel = it
                        isPhoneError = it.isEmpty()
                    },
                    label = { Text("Phone Number") },
                    leadingIcon = { 
                        Icon(Icons.Default.Phone, contentDescription = null)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    isError = isPhoneError,
                    supportingText = {
                        if (isPhoneError) {
                            Text("Phone number is required")
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Save Button
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                onClick = {
                    if (personName.isNotEmpty() && personTel.isNotEmpty()) {
                        registerPageViewModel.save(personName, personTel)
                        navController.navigateUp()
                    } else {
                        isNameError = personName.isEmpty()
                        isPhoneError = personTel.isEmpty()
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.save),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Save Contact")
            }
        }
    }
}