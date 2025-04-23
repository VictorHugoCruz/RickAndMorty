package com.devtor.rickandmorty.fake

import com.devtor.rickandmorty.data.NetworkRickAndMortyRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkRickAndMortyTest {
    @Test
    fun networkRickAndMortyRepositoryTest_getPhotos_verifyListCharacter() =
        runTest{
            val repository = NetworkRickAndMortyRepository(
                rickAndMortyService = FakeRickAndMortyApiService()
            )
            println(repository.getRickAndMortyPhotos())
            println(FakeDataSource.data)
            assertEquals(FakeDataSource.data, repository.getRickAndMortyPhotos())
        }


}