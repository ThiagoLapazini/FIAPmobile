package com.example.appfiapreciclagem

import android.R
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import androidx.appcompat.app.AppCompatActivity
import com.example.appfiapreciclagem.databinding.ActivityApoiadoresTelaBinding


class ApoiadoresTela : AppCompatActivity() {

    private lateinit var binding: ActivityApoiadoresTelaBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityApoiadoresTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageView = binding.imageView
        val imageUrl = "https://s3-alpha-sig.figma.com/img/4cdd/18b9/e89bf47631cfff524958722c911ea99e?Expires=1696204800&Signature=qq5quG1WotXqdhGQwo5wWMOsfglpjiI30vJNXb1L2MZcF7snT2GDKQmdp0T85d3imu1SoFnI09RUbHu8EhlQCft~L9i7JSPT8gQRR0EzE9BOh~qibPJ74SU8UJjY9lldIYAVmdqtASj1ZJxexQknl98vr3QjzG3KVXzLeqMX85bhf6rJmVUhGQXgwnLs~flaEp3FukZYNOp2HifmhJRLx~ciwAYAkLyZwJh5rSp2TdrVmQgnYv-dCgxrvL7Q-3W23dkVGgB6XMkowvKXXoCoCaQ8Jjci26DsGAq2ZqDgIk9DYHWxhUhW7~~ihymQ4BH3OfG1vm05LevA2ZwvE44zPw__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4"


        Glide.with(this)
            .load(imageUrl)
            .into(imageView);

        binding.telaInicial3.setOnClickListener {
            val telainicial = Intent(this, MainActivity::class.java)
            startActivity(telainicial)
        }
        binding.blogTela3.setOnClickListener {
            val telaBlog = Intent(this, TelaBlog::class.java)
            startActivity(telaBlog)
        }
    }
}