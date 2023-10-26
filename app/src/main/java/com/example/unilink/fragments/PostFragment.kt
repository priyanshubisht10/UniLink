package com.example.unilink.fragments

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.unilink.R
import com.example.unilink.databinding.FragmentPostBinding


class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding

    companion object {
        private const val IMAGE_PICK_REQUEST = 1
        private const val PERMISSION_REQUEST_CODE = 2
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPostBinding.inflate(layoutInflater)

        // Check and request permission if needed
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        val grant = PackageManager.PERMISSION_GRANTED

        if (ContextCompat.checkSelfPermission(requireContext(), permission) != grant) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(permission), PERMISSION_REQUEST_CODE)
        }

        // Button click listener to select an image from the gallery
        binding.selectImageButton.setOnClickListener {
            val pickImageIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(pickImageIntent, IMAGE_PICK_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_PICK_REQUEST && resultCode == Activity.RESULT_OK) {
            // The user has successfully picked an image
            val selectedImageUri = data?.data

            if (selectedImageUri != null) {
                // Load the selected image into the ImageView
                binding.imageView.setImageURI(selectedImageUri)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can now open the gallery
            } else {
                // Permission denied, handle accordingly (e.g., show a message)
            }
        }
    }
}