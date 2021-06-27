package com.example.mvvm_roomsqlite_coroutine.ui_view

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_roomsqlite_coroutine.R
import com.example.mvvm_roomsqlite_coroutine.adapter.MyAdapter
import com.example.mvvm_roomsqlite_coroutine.databinding.ActivityMainBinding
import com.example.mvvm_roomsqlite_coroutine.interfaces.AddInterface
import com.example.mvvm_roomsqlite_coroutine.model.Item
import com.example.mvvm_roomsqlite_coroutine.repository.ShoppingRepository
import com.example.mvvm_roomsqlite_coroutine.utils.InsertDialogue
import com.example.mvvm_roomsqlite_coroutine.utils.ShoppingDB
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var speechIntent:Intent
    val record=1
    private lateinit var allList: MutableList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shoppingDB= ShoppingDB(this)
        val repository= ShoppingRepository(shoppingDB)
        val factory= MainViewModelFactory(repository)
       viewModel= ViewModelProvider(this,factory).get(MainViewModel::class.java)

        // initilize adapter....
        val adapter= MyAdapter(mutableListOf(),mutableListOf(),viewModel)
        binding.recycleView.layoutManager= LinearLayoutManager(this)
        binding.recycleView.adapter= adapter
        binding.insertBtn.setOnClickListener(this)
        binding.search.voiceImage.setOnClickListener(this)

        // get all item
        viewModel.getAllItem().observe(this, Observer {
            allList= it
            adapter.itemList= allList
            adapter.searchList= allList
            adapter.notifyDataSetChanged()
        })
        recordSet()
        binding.refresh.setOnRefreshListener {

            viewModel.getAllItem().observe(this, Observer {
                allList= it
                adapter.itemList= allList
                adapter.searchList= allList
                adapter.notifyDataSetChanged()
            })
            binding.refresh.isRefreshing= false

        }

        binding.search.searchEditText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
              adapter.filter.filter(p0)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

       // binding.recycleView.getView

    }


    private fun recordSet() {
        speechRecognizer= SpeechRecognizer.createSpeechRecognizer(this)
        speechIntent= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        // set listener
        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(bundle: Bundle) {
                //binding.search.searchEditText.setText("Say something....")
                binding.voiceStatus.text="Say something...."
            }

            override fun onBeginningOfSpeech() {
                //binding.search.searchEditText.setText("Listening...")
                //txtFind.setText("Listening...")
                binding.voiceStatus.text="Listening..."
            }

            override fun onRmsChanged(v: Float) {}
            override fun onBufferReceived(bytes: ByteArray) {}
            override fun onEndOfSpeech() {
                binding.voiceStatus.text="Listening end..."
                //binding.search.searchEditText.setText("Enter name")
                //txtFind.setText(getString(R.string.find_food_place_or_service))
            }

            override fun onError(i: Int) {
               // txtFind.setText("Can't Listening")
               // binding.search.searchEditText.setText("Can't Listening")
                binding.voiceStatus.text="Can't Listening..."
            }

            override fun onResults(bundle: Bundle) {
                val data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                binding.search.searchEditText.setText(data!![0])
            }

            override fun onPartialResults(bundle: Bundle) {

            }
            override fun onEvent(i: Int, bundle: Bundle) {

            }
        })

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.insertBtn ->{

                InsertDialogue(
                object : AddInterface{
                    override fun onAddButtonClicked(item: Item) {
                        viewModel.insert(item)
                    }

                }).show(supportFragmentManager,"insert")
            }
            R.id.voiceImage ->{

                checkPermission(android.Manifest.permission.RECORD_AUDIO,"record",record)
                //speechRecognizer.startListening(speechIntent)
            }
        }
    }

    private fun checkPermission(permission:String, name:String, requestCode:Int){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            when{
                ContextCompat.checkSelfPermission(applicationContext,permission) == PackageManager.PERMISSION_GRANTED -> {
                    //Toast.makeText(applicationContext,"$name permission granted",Toast.LENGTH_SHORT).show()
                    speechRecognizer.startListening(speechIntent)
                }
                shouldShowRequestPermissionRationale(permission) ->{
                    showDialogue(permission,name,requestCode)
                }
                else -> {
                    ActivityCompat.requestPermissions(this, arrayOf(permission),requestCode)
                }
            }
        }
    }

    private fun showDialogue(permission: String, name: String, requestCode: Int) {
        val builder= AlertDialog.Builder(this)
        builder.apply {
            setMessage("Permission to access your $name is require to use this app")
            setTitle("Permission required")
            setPositiveButton("OK"){ dialogInterface: DialogInterface, i: Int ->

                ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission),requestCode)

            }
        }
        builder.create().show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fun innerCheck(name:String){
            if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext,"$name permission deny",Toast.LENGTH_SHORT).show()
            }
            else{
                //Toast.makeText(applicationContext,"$name permission granted",Toast.LENGTH_SHORT).show()
                speechRecognizer.startListening(speechIntent)
            }
        }
        when(requestCode){

            record-> innerCheck("record")
        }
    }

}