package com.stackinflow.androidapptemplate.util

import com.stackinflow.androidapptemplate.network.Endpoints
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockWebServerSuccessDispatcher : Dispatcher() {
  override fun dispatch(request: RecordedRequest): MockResponse {
    request.path?.let {
      return when {
        it.contains(Endpoints.GET_JOKES) -> {
          val content = FileUtil.loadText("responses/success_login.json")
          MockResponse().setResponseCode(200)
            .setBody(content)
        }
        else -> MockResponse().setResponseCode(501)
      }
    }
    return MockResponse().setResponseCode(501)
  }
}
