package com.example.mylibrary

import com.example.mylibrary.model.FindMyIpModel
import com.example.mylibrary.repository.remote.ApiService
import com.example.mylibrary.repository.remote.MainRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MainRepositoryTest {

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        // Set the main dispatcher for testing
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Reset the main dispatcher after testing
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }


    @Test
    fun `getIp should return FindMyIpModel from apiService`() = testDispatcher.runBlockingTest {
        // Given
        val apiService = mockk<ApiService>()
        val mainRepository = MainRepository(apiService)

        val expectedResult = FindMyIpModel(
            "1234",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            false,
            "",
            0.0,
            0.0,
            "",
            "",
            "",
            "",
            "",
            "",
            0.0,
            1,
            "",
            ""
        )

        coEvery { apiService.getIP() } returns expectedResult

        // When
        val result = mainRepository.getIp().toList()

        // Then
        assertEquals(expectedResult, result)
    }

    @Test
    fun `getIp should emit the result on Dispatchers IO`() = testDispatcher.runBlockingTest {
        // Given
        val apiService = mockk<ApiService>()
        val mainRepository = MainRepository(apiService)

        coEvery { apiService.getIP() } returns FindMyIpModel(
            "1234",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            false,
            "",
            0.0,
            0.0,
            "",
            "",
            "",
            "",
            "",
            "",
            0.0,
            1,
            "",
            ""
        )

        // When
        mainRepository.getIp().collect { /* do nothing, just collect */ }

        // Then
        // Ensure that the flow is collected on Dispatchers.IO
        assertEquals(Dispatchers.IO, testDispatcher)
    }
}