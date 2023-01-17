package br.com.portal.coroutinesfilmes.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

	fun getFilms( callback: ( films: List<Film> ) -> Unit ) {
		Thread( Runnable {
			Thread.sleep( 3000 )
			callback.invoke(
				listOf(
					Film( id = 1, title = "film 01" ),
					Film( id = 2, title = "film 02" ),
					Film( id = 3, title = "film 03" ),
					Film( id = 4, title = "film 04" )
				)
			)
		}).start()
	}

	suspend fun getFilmsCoroutines() : List<Film> {
		return withContext( Dispatchers.Default ) {
			delay( 3000 )
			listOf(
				Film( id = 1, title = "film 01" ),
				Film( id = 2, title = "film 02" ),
				Film( id = 3, title = "film 03" ),
				Film( id = 4, title = "film 04" )
			)
		}
	}
}