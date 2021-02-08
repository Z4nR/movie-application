package com.dicoding.picodiploma.movieapplication.ui.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.movieapplication.data.source.remote.response.MovieResultsItem
import com.dicoding.picodiploma.movieapplication.data.source.remote.response.TVSeriesResultsItem
import com.dicoding.picodiploma.movieapplication.databinding.FragmentFavoriteListBinding
import com.dicoding.picodiploma.movieapplication.ui.detail.DetailActivity
import com.dicoding.picodiploma.movieapplication.ui.movie.MovieAdapter
import com.dicoding.picodiploma.movieapplication.ui.tvseries.TVSeriesAdapter
import com.dicoding.picodiploma.movieapplication.viewmodel.ViewModelFactory

class FavoriteListFragment : Fragment() {

    companion object{
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(index: Int) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    private lateinit var fragmentFavoriteListBinding: FragmentFavoriteListBinding
    private lateinit var viewModel: FavoriteListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteListBinding =
            FragmentFavoriteListBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return fragmentFavoriteListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance()
            viewModel = ViewModelProvider(this, factory)[FavoriteListViewModel::class.java]

            when(arguments?.getInt(ARG_SECTION_NUMBER, 0)){
                1 -> { // Show movie list
                    showMovieList()
                }

                2 -> { // Show tv series list
                    showTVSeriesList()
                }
            }
        }
    }

    /**
     * Show movie list in fragment
     */
    private fun showMovieList(){
//        setLoading(true)
//
//        // Observe movies
//        viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
//            setLoading(false)
//            val movieAdapter = MovieAdapter()
//            movieAdapter.setMovies(movies)
//
//            with(fragmentFavoriteListBinding.rvList){
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = movieAdapter
//            }
//
//            // On click listener
//            movieAdapter.setOnItemClickCallback(object: MovieAdapter.OnItemClickCallback{
//                override fun onItemClicked(movie: MovieResultsItem) {
//                    val intent = Intent(activity, DetailActivity::class.java)
//                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie.id)
//                    intent.putExtra(DetailActivity.EXTRA_ID, DetailActivity.MOVIE_ID)
//                    startActivity(intent)
//                }
//            })
//
//            movieAdapter.notifyDataSetChanged()
//        })
    }

    /**
     * Show movie list in fragment
     */
    private fun showTVSeriesList(){
//        setLoading(true)
//
//        viewModel.getTVSeries().observe(viewLifecycleOwner, {tvSeries ->
//            setLoading(false)
//            val tvSeriesAdapter = TVSeriesAdapter()
//            tvSeriesAdapter.setTVSeries(tvSeries)
//
//            with(fragmentFavoriteListBinding.rvList){
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = tvSeriesAdapter
//            }
//
//            tvSeriesAdapter.setOnItemClickCallback(object: TVSeriesAdapter.OnItemClickCallback{
//                override fun onItemClicked(tvSeries: TVSeriesResultsItem) {
//                    val intent = Intent(activity, DetailActivity::class.java)
//                    intent.putExtra(DetailActivity.EXTRA_TV_SERIES, tvSeries.id)
//                    intent.putExtra(DetailActivity.EXTRA_ID, DetailActivity.TV_SERIES_ID)
//                    startActivity(intent)
//                }
//            })
//
//            tvSeriesAdapter.notifyDataSetChanged()
//        })
    }

    /**
     * Set visibility of progressBar
     */
    private fun setLoading(isVisible: Boolean){
        if(isVisible)
            fragmentFavoriteListBinding.progressBar.visibility = View.VISIBLE
        else
            fragmentFavoriteListBinding.progressBar.visibility = View.GONE
    }
}