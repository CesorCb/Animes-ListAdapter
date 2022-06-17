package com.cesor.android.animes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cesor.android.animes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var listAdapter : AnimeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        getAllAnimes()
    }

    private fun setupRecyclerView() {
        listAdapter = AnimeListAdapter(this)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
        }
    }

    fun animes() : MutableList<Anime> {
        val shingekiNoKyojing = Anime(1, "Shingeki No Kyojin", "https://imgs.search.brave.com/TY-IQd3R5h5ys2IW5DY_qFq7raZ3crj-jv_bf8M2N2w/rs:fit:728:410:1/g:ce/aHR0cHM6Ly9jNC53/YWxscGFwZXJmbGFy/ZS5jb20vd2FsbHBh/cGVyLzkwMC8xOS82/NzUvc2hpbmdla2kt/bm8ta3lvamluLWVy/ZW4tamVhZ2VyLWFu/aW1lLXdhbGxwYXBl/ci1wcmV2aWV3Lmpw/Zw")
        val dragonBall = Anime(2, "Dragon Ball", "https://imgs.search.brave.com/vNrGejjEYTchNw_Sjs9izf7GyU4IH3pY7FALPxsxzUk/rs:fit:728:364:1/g:ce/aHR0cHM6Ly9jNC53/YWxscGFwZXJmbGFy/ZS5jb20vd2FsbHBh/cGVyLzE5Ny8yOTEv/NTg0L2RyYWdvbi1i/YWxsLWRyYWdvbi1i/YWxsLXN1cGVyLWdv/Z2V0YS1kcmFnb24t/YmFsbC1zdXBlci1z/YWl5YW4tZ29kLWhk/LXdhbGxwYXBlci1w/cmV2aWV3LmpwZw")
        val onePunchMan = Anime(3, "One Punch Man", "https://imgs.search.brave.com/Tz6q0sjugTbdSJ16nwSZ3mbhAdMfYacefUv00gORCdI/rs:fit:844:225:1/g:ce/aHR0cHM6Ly90c2Uz/Lm1tLmJpbmcubmV0/L3RoP2lkPU9JUC5D/Sm1ESi11VmFUSUtf/QVBWb2JmM0tnSGFF/SyZwaWQ9QXBp")
        val kimetsuNoYaiba = Anime(4, "Kimetsu No Yaiba", "https://imgs.search.brave.com/9X_0kixBwyUCgagHe21cRN9BTr4jFi3i96qp_mBjncY/rs:fit:735:310:1/g:ce/aHR0cHM6Ly9jNC53/YWxscGFwZXJmbGFy/ZS5jb20vd2FsbHBh/cGVyLzkxNy8yNDUv/ODAvYW5pbWUtZGVt/b24tc2xheWVyLWtp/bWV0c3Utbm8teWFp/YmEtdGFuamlyb3Ut/a2FtYWRvLWhkLXdh/bGxwYXBlci10aHVt/Yi5qcGc")
        val naruto = Anime(5, "Naruto", "https://imgs.search.brave.com/MYjjz_R66bEyvNzrAgGR0KhP3Y_KUWVXeLw-1kOiKAQ/rs:fit:728:411:1/g:ce/aHR0cHM6Ly9jNC53/YWxscGFwZXJmbGFy/ZS5jb20vd2FsbHBh/cGVyLzk1OC8xNDUv/Mjk3L25hcnV0by1z/aGlwcHV1ZGVuLWFu/aW1lLXNhc29yaS1q/aXJhaXlhLWhha3Ut/ZGVpZGFyYS1ob2th/Z2Utb3JvY2hpbWFy/dS1uYW1pa2F6ZS1t/aW5hdG8tdXp1bWFr/aS1rdXNoaW5hLW1v/bW9jaGktemFidXph/LWtvbmFuLXlhaGlr/by11Y2hpaGEtaXRh/Y2hpLXdhbGxwYXBl/ci1wcmV2aWV3Lmpw/Zw")
        val boruto = Anime(6, "Boruto", "https://imgs.search.brave.com/9Fvt9EFFoj2vL17ZaIRO34vW0CPnV1tvUZG9ZuwOWEY/rs:fit:1200:600:1/g:ce/aHR0cHM6Ly9zdGF0/aWMxLmNicmltYWdl/cy5jb20vd29yZHBy/ZXNzL3dwLWNvbnRl/bnQvdXBsb2Fkcy8y/MDE5LzEyL0JvcnV0/by1OYXJ1dG8tTmV4/dC1HZW5lcmF0aW9u/cy5qcGc")
        val evangelion = Anime(7, "Evangelion", "https://imgs.search.brave.com/tLdr3aXkL2eO3E3PF9XxbPtrk5yRucOXU4Fp_j_xJZg/rs:fit:610:310:1/g:ce/aHR0cHM6Ly9jNC53/YWxscGFwZXJmbGFy/ZS5jb20vd2FsbHBh/cGVyLzY1MC80OTIv/ODY0L25lb24tZ2Vu/ZXNpcy1ldmFuZ2Vs/aW9uLW1lY2gtZXZh/LXVuaXQtMDEtd2Fs/bHBhcGVyLXRodW1i/LmpwZw")

        return mutableListOf(shingekiNoKyojing, dragonBall, onePunchMan, kimetsuNoYaiba, naruto, boruto, evangelion)
    }

    private fun getAllAnimes(){
        val animeData = animes()
        listAdapter.submitList(animeData)

    }

    override fun onClick(anime: Anime) {
        Snackbar.make(binding.root, anime.name, Snackbar.LENGTH_LONG).show()
    }
}